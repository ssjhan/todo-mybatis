package com.example.demo.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter @Setter@ToString
@AllArgsConstructor
public class UserEntity {

    private String id;
    private String username;
    private String email;
    private String password;

    public UserEntity(){
        this.id = UUID.randomUUID().toString();
    }

}
