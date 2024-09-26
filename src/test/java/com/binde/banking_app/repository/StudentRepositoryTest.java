package com.binde.banking_app.repository;

import com.binde.banking_app.entity.Guardian;
import com.binde.banking_app.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
@Autowired
    private StudentRepository studentRepository;
@Test
    public void saveStudent(){
    Student student = Student.builder()
            .firstName("James")
            .lastName("Nimak")
            .email("nimnan@gmail.com")
            //.guardianName("Maxwell")
            //.getGuardianEmail("maxwell@gmail.com")
            //.getGuardianMobile("09167911079")
            .build();
    studentRepository.save(student);
}
@Test
public void saveStudentWithGuardian(){
    Guardian guardian = Guardian.builder()
            .name("lami")
            .email("lami@gmail.com")
            .mobile("08167911080")
            .build();
    Student student= Student.builder()
            .firstName("Mani")
            .lastName("Jemda")
            .email("mani@gmail.com")
            .guardian(guardian)
            .build();
    studentRepository.save(student);
}
@Test
public void printAllStudentByFirstName(){
    List<Student>students = studentRepository.findByFirstName("Mani");
    System.out.println("Student" + students);
}
@Test
public void printAllStudent(){
    List<Student>students = studentRepository.findAll();
    System.out.println("Students " + students);
}

    @Test
    public void printAllStudentByFirstNameContaining(){
        List<Student>students = studentRepository.findByFirstNameContaining("Ma");
        System.out.println("Student" + students);
    }
   @Test
    public void printStudentBasedOnGuardianName(){
    List<Student>students = studentRepository.findByGuardianName("Lami");
        System.out.println("Student " + students);
    }
    @Test
    public void printStudentByEmailAddress(){
    Student student =
            studentRepository.getStudentByEmailAddress("lami@gmail.com");
        System.out.println("student email" + student);
    }

   @Test
    public void getStudentFirstNameByEmailAddress(){
    String string = studentRepository.getStudentFirstNameByEmailAddress("mani@gmail.com");
        System.out.println("email " + string);
    }
   @Test
    public void printgetStudentByEmailAddressNative(){
    Student student = studentRepository.getStudentByEmailAddressNative("mani@gmail.com");
       System.out.println("email " + student);

    }

    @Test
    public void getStudentByEmailAddressNativeNamedParam(){
    Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("mani@gmail.com");
        System.out.println("Student " + student);
    }
@Test
public void updateStudentNameByEmailIdTest(){
    studentRepository.updateStudentNameByEmailId("charles","mani@gmail.com");
}

}