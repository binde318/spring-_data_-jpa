package com.binde.banking_app.repository;

import com.binde.banking_app.entity.Course;
import com.binde.banking_app.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){
        Course courseDBA = Course.builder()
                .credit("8")
                .title("java 8")
                .build();
        Course courseDBB = Course.builder()
                .credit("8")
                .title("java 8")
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Mark")
                .lastName("Ramdur")
                //.courses(List.of(courseDBB,courseDBA))
                .build();
        teacherRepository.save(teacher);

    }

}