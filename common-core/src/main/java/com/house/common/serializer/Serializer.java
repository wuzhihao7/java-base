package com.house.common.serializer;

/**
 * @author house
 */
public interface Serializer<T> {
    /**
     * 空字节数组
     */
    final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    /**
     * 序列化对象
     * @param object 对象实例
     * @return 序列化结果
     */
    byte[] serialize(T object);

    /**
     * 反序列化对象
     * @param bytes 字节数组
     * @return 反序列化结果
     */
    T deserialize(byte[] bytes);
}
