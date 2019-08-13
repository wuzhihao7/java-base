package com.house.common.serializer;

import java.io.IOException;

/**
 * @author house
 */
public interface Serializer<T> {
    byte[] serialize(T object) throws IOException;

    T deserialize(byte[] bytes, Class<T> clz) throws IOException;
}
