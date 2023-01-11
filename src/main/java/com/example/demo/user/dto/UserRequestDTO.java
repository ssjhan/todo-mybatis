package com.example.demo.user.dto;

import lombok.*;

@Setter @Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private String email;
    private String password;
    private String username;



}
