package com.example.demo.user.repository;

import com.example.demo.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    // 이메일주소를 통해 회원정보 조회하기
    UserEntity findUserByEmail(String email);

    // 이메일 주소가 중복인지 조회하기
    boolean existsByEmail(String email);

    // 회원 가입하기
    boolean register(UserEntity entity);

    // 회원의 프로필 사진 경로 조회
    String findProfile(String userId);
}