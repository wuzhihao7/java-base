package com.house.common.serializer;

import org.nustaq.serialization.FSTConfiguration;

/**
 * Fst序列化工具类
 * @author wuzhihao
 */
public class FstSerializer<T> implements Serializer<T> {
    private static final FSTConfiguration FST_CONFIGURATION = FSTConfiguration.createDefaultConfiguration();

    @Override
    public byte[] serialize(T object) {
        if(object == null){
            return EMPTY_BYTE_ARRAY;
        }
        return FST_CONFIGURATION.asByteArray(object);
    }

    @Override
    public T deserialize(byte[] bytes) {
        if(bytes == null || bytes.length <= 0){
            return null;
        }
        return (T)FST_CONFIGURATION.asObject(bytes);
    }
}
