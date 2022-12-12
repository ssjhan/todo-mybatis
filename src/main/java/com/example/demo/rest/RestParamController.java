package com.example.demo.rest;

import lombok.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/param")
public class RestParamController {

    @GetMapping("/user")  // URL : /param/user?name=홍길동
    public String userName(HttpServletRequest request) {

        // 홍길동
        String name = request.getParameter("name");

        return String.format("당신의 이름은 %s입니다.", name);
    }

    @GetMapping("/user2")  //  /param/user2?name=짹짹이&age=25
    public String userName(
            @RequestParam(value = "name", required = false) String nm,
            @RequestParam(defaultValue = "10") int age
    ) {

        return String.format(
                "당신의 이름은 %s님이고, 나이는 %d세입니다."
                , nm, age);
    }


    // /param/user3?name=김철수&age=30&address=서울&height=171.88&hobby=축구&hobby=농구
    @GetMapping("/user3")
    public String user3(UserDTO userInfo) {

        return String.format(
                "당신의 이름은 %s님이고, 나이는 %d세이고, "
                        + "주소는 %s이며, 키는 %.2fcm며 취미는 %s들이다."
                , userInfo.getName()
                , userInfo.getAge()
                , userInfo.getAddress()
                , userInfo.getHeight()
                , userInfo.getHobby()
        );
    }

    @GetMapping("/user4/{userNum}")
//    @RequestMapping(value = "/user4/{userNum}", method = RequestMethod.GET)
    public String user4(@PathVariable("userNum") int num) {
        return String.format("회원번호는 %d번입니다.", num);
    }


    @Setter // 필수
    @Getter
    @ToString
    @NoArgsConstructor  // 필수
    @AllArgsConstructor
    public static class UserDTO {

        private String name;
        private int age;
        private String address;
        private double height;
        private List<String> hobby;
    }

}
