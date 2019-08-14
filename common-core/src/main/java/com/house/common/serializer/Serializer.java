package com.house.common.serializer;

import java.io.IOException;

/**
 * @author house
 */
public interface Serializer<T> {
    /**
     * 序列化对象
     * @param object 对象实例
     * @return 序列化结果
     * @throws IOException
     */
    byte[] serialize(T object);

    /**
     * 反序列化对象
     * @param bytes 字节数组
     * @param clazz 字节码对象
     * @return 反序列化结果
     * @throws IOException
     */
    T deserialize(byte[] bytes, Class<T> clazz);
}
