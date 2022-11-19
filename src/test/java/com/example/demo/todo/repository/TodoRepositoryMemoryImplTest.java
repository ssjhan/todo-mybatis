package com.example.demo.todo.repository;

import com.example.demo.todo.entity.Todo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*; //앞에 문장 적기 싫으면 import static

@SpringBootTest // 스프링 컨테이너를 테스트 클래스에서 사용가능
class TodoRepositoryMemoryImplTest {

    @Autowired
    TodoRepository repository;


    // 단언 : 강력하게 주장한다
    @Test
    @DisplayName("저장소에서 목록을 조회했을 때 할 일의 개수가 3개여야 한다.")
    void findAllTest(){

        //given : 테스트 시 필요한 데이터

        //when : 테스트의 실제 상황
        List<Todo> todoList = repository.findAll();

        //then : 테스트 결과 단언
        assertEquals(3,todoList.size());
        assertNotNull(todoList);


    }

    @Test
    @DisplayName("아아디가 2번인 할일 데이터를 조회했을 때  그 작성자 이름이 박영희이어야 한다.")
    void findOneTest(){

        //given
        long id = 2L;

        //when
        Todo todo = repository.findOne(id);

        //then
        assertEquals("박영희", todo.getUserid());
        assertFalse(todo.isDone());
    }

    @Test
    @DisplayName("1번 할일을 삭제한후 다시 조회했을 때 null이 나와야 한다.")
    void removeTest() {
        // given
            long id = 1L;

        // when
        boolean flag = repository.remove(id);
        Todo todo = repository.findOne(id);

        // then
        assertTrue(flag);
        assertNull(todo);
        assertEquals(2, repository.findAll().size());


    }

    @Test
    @DisplayName("새로운 4번 할일을 등록하고 등록했을 때 전체목록의 갯수가 4개여야 한다.")
    void saveTest() {
        // given
       Todo newTodo =  new Todo(4L, "성석" , "학원끝", true);

        // when
        boolean flag = repository.save(newTodo);

        List<Todo> toDoList = repository.findAll();

        // then
        assertTrue(flag);
        assertEquals(4, toDoList.size());


    }



}