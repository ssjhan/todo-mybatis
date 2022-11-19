package com.example.demo.todo.repository;


import com.example.demo.todo.entity.Todo;

import java.util.List;

// 역할 : 할 일 데이터를 CRUD한다(생성, 조회, 수정, 삭제)
public interface TodoRepository {

    //할일 생성 기능

    /**
     * 할 일 데이터를 저장소에 저장하는 기능
     * @param todo - 할 일 데이터의 집합
     * @return - 저장 성공시 true, 실패 시 false 반환
     */
    boolean save(Todo todo);

    //할일 목록조회 기능
    List<Todo> findAll();


    //할일 개별조회 기능
    Todo findOne(Long id);


    //할일 삭제 기능
    boolean remove(Long id);


}
