package com.example.mapping.domain;

import lombok.Data;

@Data
public class User {

    String username;
    int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
