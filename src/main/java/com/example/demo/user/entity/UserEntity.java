package com.example.demo.user.entity;

import com.example.demo.user.dto.UserRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter @Setter@ToString
@AllArgsConstructor
public class UserEntity {

    private String customerid;
    private String username;
    private String email;
    private String password1;
    private String telnumber;

    private String addr;
    private String detailaddr;


    public UserEntity(){
        this.customerid = UUID.randomUUID().toString();
    }

    public UserEntity(UserRequestDTO dto){
        this();
        this.email = dto.getEmail();
        this.username = dto.getUsername();
        this.password1 = dto.getPassword1();
        this.telnumber = dto.getTelnumber();
        this.addr = dto.getAddr();
        this.detailaddr = dto.getDetailaddr();
    }

}
