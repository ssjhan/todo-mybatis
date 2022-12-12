package com.example.demo.ibatis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Setter @Getter @ToString
@AllArgsConstructor
public class TestEntity {

    private String id;
    private String username;
    private int age;

    public TestEntity() {
        this.id = UUID.randomUUID().toString();
    }
}
