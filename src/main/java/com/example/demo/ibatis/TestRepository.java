package com.example.demo.ibatis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 이 인터페이스의 의존성을 마이바티스에게 위임
public interface TestRepository {

    // 데이터 저장 기능
    boolean save(TestEntity entity);

    // 데이터 수정 기능
    boolean modify(TestEntity entity);

    // 데이터 삭제 기능
    boolean remove(String id);

    // 데이터 전체 조회 기능
    List<TestEntity> findAll();
}
