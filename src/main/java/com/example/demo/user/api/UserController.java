package com.example.demo.user.api;

import com.example.demo.security.TokenProvider;
import com.example.demo.user.dto.UserRequestDTO;
import com.example.demo.user.dto.UserResponseDTO;
import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final TokenProvider provider;

    // 회원 가입 기능
    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody UserRequestDTO reqDto) {

        try {
            // userReqDto를 서비스에 전송
            // userEntity로 변환
            UserEntity entity = new UserEntity(reqDto);
            log.info("/auth/signup POST!! - {}", entity);

            UserEntity user = userService.createServ(entity);

            return ResponseEntity.ok().body(new UserResponseDTO(entity));

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody UserRequestDTO  dto ){
        log.info("/auth/signin POST!! - login info : {}", dto);

        try {
            UserEntity user =   userService.validateLogin(dto.getEmail(), dto.getPassword());

            //토큰 생성
            final String token = provider.create(user);

           UserResponseDTO responseDTO = new UserResponseDTO(user);
            responseDTO.setToken(token); // 발행한 토큰을 응답정보에 포함

            return ResponseEntity.ok().body(responseDTO);

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }//ctrl + alt + t(여러가지 문법 자동생성 단축키(예 : try-catch))
    }
}