package com.example.demo.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Setter @Getter @ToString
// @NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 전체 필드 초기화 생성자
// 역할: 하나의 할 일 데이터의 집합 객체
public class ToDo {

    private String id; // 할일들을 식별하는 번호
    private String userId; // 할 일을 등록한 회원의 식별자
    private String title; // 할 일 내용
    private boolean done; // 할 일 완료 여부
    private  Date regDate; // 할 일 시간 등록 여부

    // 일련번호
    private static long seq;

    public ToDo() {
        this.id = UUID.randomUUID().toString();
    }

    public ToDo(String title) {
        this();
        this.title = title;
        this.userId = "noname";
        this.regDate = getRegDate();
    }
}
