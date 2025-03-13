package com.jinhui.wmiss.entity;

import lombok.Data;

// User.java
@Data  // Lombok 注解，自动生成 getter/setter
public class User {
    private String name;
    private String email;
}
