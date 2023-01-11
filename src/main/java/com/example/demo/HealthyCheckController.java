package com.example.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 백엔드 서버가 살아있는지 확인
@RestController
@Slf4j
public class HealthyCheckController {

    @GetMapping("/")
    public String check() {
        log.info("server is running...");
        return "server is running....";
    }
}