package com.house.common.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.Pool;

import java.io.IOException;

/**
 * Kryo序列化工具类
 * @author house
 */
public class KyroSeriaizer<T> implements Serializer<T> {
    /**
     * kryo池，线程安全
     */
    private static final Pool<Kryo> KRYO_POOL = new Pool<Kryo>(true, false, 8) {
        @Override
        protected Kryo create() {
            Kryo kryo = new Kryo();
            kryo.setReferences(true);
            return kryo;
        }
    };

    /**
     * output池，线程安全
     */
    private static final Pool<Output> OUTPUT_POOL = new Pool<Output>(true, false, 16) {
        @Override
        protected Output create() {
            Output output = new Output(1024, -1);
            return output;
        }
    };

    /**
     * input池，线程安全
     */
    private static final Pool<Input> INPUT_POOL = new Pool<Input>(true, false, 16) {
        @Override
        protected Input create() {
            Input input = new Input(1024);
            return input;
        }
    };

    @Override
    public byte[] serialize(T object) {
        Kryo kryo = KRYO_POOL.obtain();
        Output output = OUTPUT_POOL.obtain();
        try {
            output.reset();
            kryo.register(object.getClass());
            kryo.writeClassAndObject(output, object);
            return output.getBuffer();
        }finally {
            KRYO_POOL.free(kryo);
            OUTPUT_POOL.free(output);
        }
    }

    @Override
    public T deserialize(byte[] bytes) {
        Kryo kryo = KRYO_POOL.obtain();
        Input input = INPUT_POOL.obtain();
        try {
            input.setBuffer(bytes);
            return (T) kryo.readClassAndObject(input);
        }finally {
            KRYO_POOL.free(kryo);
            INPUT_POOL.free(input);
        }
    }
}
