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
    private static final Pool<Kryo> KRYO_POOL = new Pool<Kryo>(true, false, 8) {
        @Override
        protected Kryo create() {
            Kryo kryo = new Kryo();
            return kryo;
        }
    };

    private static final Pool<Output> OUTPUT_POOL = new Pool<Output>(true, false, 16) {
        @Override
        protected Output create() {
            Output output = new Output(1024, -1);
            return output;
        }
    };

    private static final Pool<Input> INPUT_POOL = new Pool<Input>(true, false, 16) {
        @Override
        protected Input create() {
            Input input = new Input(1024);
            return input;
        }
    };

    @Override
    public byte[] serialize(T object) throws IOException {
        return new byte[0];
    }

    @Override
    public T deserialize(byte[] bytes, Class<T> clz) throws IOException {
        return null;
    }
}
