package com.house.common.serializer;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = -545769456851805390L;
    private int age;
    private String name;
}