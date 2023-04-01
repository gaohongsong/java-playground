package com.onyx.springbootdemo.vo;

import lombok.Builder;
import lombok.Data;

public class Test {
    public static void main(String[] args) {
        User user = User.builder().id(1).name("pitou").build();
    }
}

@Data
@Builder
class User {
    private int id;
    private String name;
}