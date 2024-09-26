package com.binde.banking_app.repository;

import com.binde.banking_app.entity.Course;
import com.binde.banking_app.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void printAllCourses(){
        List<Course>courses = courseRepository.findAll();
        System.out.println("Courses " + courses);
    }
    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Durtim")
                .lastName("Lasing")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credit("9")
                .teacher(teacher)
                .build();

        courseRepository.save(course);

    }
     @Test
    public void findAllPagination(){
        Pageable findPageWithThreeRecords =
                PageRequest.of(0,3);

        Pageable findWithTwoRecords = PageRequest.of(1,2);

        List<Course>courses =
                courseRepository.findAll(findPageWithThreeRecords).getContent();

        Long totalElement =
                courseRepository.findAll(findPageWithThreeRecords).getTotalElements();

        int totalPage = courseRepository.findAll(findPageWithThreeRecords).getTotalPages();
         System.out.println(totalPage);
         System.out.println(totalElement);
         System.out.println("courses" + courses);

    }

}