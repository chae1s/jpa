package com.example.jpa;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {
    // 주된 비지니스 로직이 구현되는 공간
    // Controller -> Service
    // 1. 데이터베이스 조회
    // 2. Component 사용
    // 3. 모은 데이터를 가지고 응답 (의사결정)

    private final AppRepository repository;

    public AppService(AppRepository repository) {
        this.repository = repository;
    }

    public List<Object> readStudentAll() {
        List<Object> queryResult = repository.selectStudentAll();

        return queryResult;
    }
}
