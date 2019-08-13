package com.house.common.converter;

/**
 * 对象转换器接口
 * @author house
 */
public interface Converter<S, T> {
    /**
     * 正向转换
     * @param s 源对象
     * @return 目标对象
     */
    T doForward(S s);

    /**
     * 逆向转换
     * @param t 源对象
     * @return 目标对象
     */
    S doBackward(T t);
}
