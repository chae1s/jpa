package com.example.jpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Controller
public class AppController {
    // 사용자의 입력을 받는 요소 -> MVC 패턴의 C를 담당
    // RequestMapping과 같이 사용

    private final AppService service;

    public AppController(AppService service) {
        this.service = service;
    }


    @GetMapping("create")
    public @ResponseBody String create() {
        this.service.createStudent(
                "alex", 35, "010-1234-5678", "alex@gmail.com"
        );

        return "done";

    }

    @GetMapping("read")
    public @ResponseBody String read() {
        this.service.readStudent();
        return "done-read";
    }

    @GetMapping("read-all")
    public @ResponseBody String readAll() {
        this.service.readStudentAll();
        return "done-read-all";
    }

    @GetMapping("update")
    public @ResponseBody String update() {
        this.service.updateStudent(1L, "alexander");

        return "done-update";
    }

    @GetMapping("delete")
    public @ResponseBody String delete() {
        this.service.deleteStudent(1L);

        return "done-delete";
    }

    @GetMapping("find")
    public @ResponseBody String find() {
        this.service.findAllByTest();

        return "done-find";
    }


    @GetMapping("home")
    public String home() {

        return "home";
    }

    @GetMapping("body")
    public @ResponseBody String body() {

        return "body";
    }
}
