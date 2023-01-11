package com.example.demo.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PwEncoderTest {

    @Autowired
    PasswordEncoder encoder;

    @Test
    @DisplayName("평문 패스워드가 암호화 되어야 한다.")
    void pwEncodigTest() {
        //given
        String rawpw = "abc1234!";

        //when
        String encodePw = encoder.encode(rawpw);

        //then
        System.out.println("encodePw = " + encodePw);
    }

    @Test
    @DisplayName("평문패스워드와 암호화 패스워드를 비교해야 한다.")
    void encodingPwLoginTest(){
        //given
        String rawPw = "appple123"; //사용자가 입력한 패스워드
        String encodePw = encoder.encode(rawPw); // 데이터베이스에 저장된 패스워드

        //when
//        boolean flag = rawPw.equals(encodePw);

        boolean flag = encoder.matches(rawPw, encodePw);

        //then
        System.out.println("flag = " + flag);
    }
}
