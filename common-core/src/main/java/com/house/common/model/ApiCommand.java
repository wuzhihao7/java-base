package com.house.common.model;


import com.house.common.serializer.Serializer;
import lombok.Data;

import javax.naming.directory.SearchResult;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * API请求类
 * @author house
 */
@Data
public class ApiCommand<T> implements Serializable {
    private static final long serialVersionUID = 9089361505276095369L;
    /**
     * 请求唯一标志
     */
    private String id;
    /**
     * 请求日期
     */
    private LocalDate date;
    /**
     * 请求时间
     */
    private LocalDateTime time;
    /**
     * 请求报文体
     */
    private T data;
}
