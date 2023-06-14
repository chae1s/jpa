package com.example.jpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

// @Controller
@RestController
public class AppController {
    // 사용자의 입력을 받는 요소 -> MVC 패턴의 C를 담당
    // RequestMapping과 같이 사용

    private final AppService service;

    public AppController(AppService service) {
        this.service = service;
    }

    @RequestMapping("students")
    public void students() {
        List<Object> result = service.readStudentAll();
    }

    @GetMapping("home")
    public String home() {

        return "home";
    }

    @GetMapping("body")
    public String body() {

        return "body";
    }
}
