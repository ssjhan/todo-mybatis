package com.example.demo.user.dto;

import lombok.*;

@Setter @Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private String email;
    private String password1;
    private String username;
    private String telnumber;
    private String addr;
    private String detailaddr;


}
