package com.binde.banking_app.repository;

import com.binde.banking_app.entity.Course;
import com.binde.banking_app.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void savedCourseMaterial(){
        Course course = Course.builder()
                .title("basics")
                .credit("7")
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(course)
                .url("www.binde.com")
                .build();
        courseMaterialRepository.save(courseMaterial);

    }
    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial>courseMaterials =
                courseMaterialRepository.findAll();
        System.out.println("Course materials" + courseMaterials);

    }

}