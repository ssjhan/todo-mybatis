package com.example.demo.todo.entity;

import lombok.*;

@Setter @Getter @ToString //set get toString 자동생성
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 전체 필드 초기화 생성자
// 역할: 하나의 할 일 데이터의 집합 객체
public class Todo {

    private Long id; // 할일들을 식별하는 번호

    private String userid; // 할 일을 등록한 회원의 식별자

    private String title; // 할 일 내용

    private boolean done; // 할 일 완료 여부



}
