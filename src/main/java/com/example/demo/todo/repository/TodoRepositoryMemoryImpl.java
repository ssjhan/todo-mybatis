package com.example.demo.todo.repository;


import com.example.demo.todo.entity.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 역할: 할 일 데이터를 메모리에 CRUD하는 역할

@Repository
public class TodoRepositoryMemoryImpl implements  TodoRepository{


    //메모리 저장소
    /**
     * key : 할 일의 식별 id값
     * value : 할 일 집합객체
     */

    //Map : int -> Integer, long -> Long
    private static final Map<Long, Todo> toDoMap = new HashMap<>();

    static{
        toDoMap.put(1L, new Todo(1L, "김철수", "저녁밥 만들기", false));
        toDoMap.put(2L, new Todo(2L, "박영희", "산책가기", false));
        toDoMap.put(3L, new Todo(3L,  "김철수", "노래연습하기", true));
    }


    @Override
    public boolean save(Todo todo) {
        if(todo == null) return false;

         toDoMap.put(todo.getId(), todo);
        return true;

    }

    @Override
    public List<Todo> findAll() {

        List<Todo> toDoList = new ArrayList<>();

        //Map을 돌릴려면 keySet()
        for (Long id : toDoMap.keySet()) {
            Todo todo  = toDoMap.get(id);
            toDoList.add(todo);
        }
        return toDoList;
    }

    @Override
    public Todo findOne(Long id) {
        return toDoMap.get(id);
    }

    @Override
    public boolean remove(Long id) {
        Todo todo =  toDoMap.remove(id);
        return todo != null;
    }


}
