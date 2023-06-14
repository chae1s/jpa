package com.example.jpa;

import com.example.jpa.entity.StudentEntity;
import com.example.jpa.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppService {
    // 주된 비지니스 로직이 구현되는 공간
    // Controller -> Service
    // 1. 데이터베이스 조회
    // 2. Component 사용
    // 3. 모은 데이터를 가지고 응답 (의사결정)

    private final AppRepository repository;
    private final StudentRepository studentRepository;

    public AppService(AppRepository repository, StudentRepository studentRepository) {
        this.repository = repository;
        this.studentRepository = studentRepository;
    }

    // CREATE
    public void createStudent(String name, Integer age, String phone, String email) {
        StudentEntity newEntity = new StudentEntity();
        newEntity.setName(name);
        newEntity.setAge(age);
        newEntity.setPhone(phone);
        newEntity.setEmail(email);

        this.studentRepository.save(newEntity);
    }

    // READ
    public void readStudent() {
        System.out.println(this.studentRepository.findById(1L));
    }

    // READ ALL
    public void readStudentAll() {
        System.out.println(this.studentRepository.findAll());
    }

    // UPDATE
    public void updateStudent(Long id, String name) {
        Optional<StudentEntity> optionalEntity = this.studentRepository.findById(id);
        // 수정할 Entity를 찾은 경우
        if (optionalEntity.isPresent()) {
            StudentEntity target = optionalEntity.get();
            target.setName(name);
            this.studentRepository.save(target);
        } else {
            System.out.println("could not find");
        }
    }

    // DELETE
    public void deleteStudent(Long id) {
        Optional<StudentEntity> optionalEntity = this.studentRepository.findById(id);

        if (optionalEntity.isPresent()) {
            StudentEntity target = optionalEntity.get();
            this.studentRepository.delete(target);
        } else {
            System.out.println("could not find");
        }
    }

    // findAllBy
    public void findAllByTest() {
        System.out.println("----------------------------------");
        System.out.println("findAllByOrderByName");
        List<StudentEntity> studentEntities = this.studentRepository.findAllByOrderByName();
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }

        System.out.println("----------------------------------");
        System.out.println("findAllByOrderByAgeDesc");
        studentEntities = this.studentRepository.findAllByOrderByAgeDesc();
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }

        System.out.println("----------------------------------");
        System.out.println("findAllByAgeLessThan(21)");
        studentEntities = this.studentRepository.findAllByAgeLessThan(21);
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }

        System.out.println("----------------------------------");
        System.out.println("findAllByPhoneStartingWith(\"010-\")");
        studentEntities = this.studentRepository.findAllByPhoneStartingWith("010-");
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }

        System.out.println("----------------------------------");
    }

}
