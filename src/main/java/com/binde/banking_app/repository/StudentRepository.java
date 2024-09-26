package com.binde.banking_app.repository;

import com.binde.banking_app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student>findByFirstName(String firstName);
    public List<Student>findByFirstNameContaining(String name);

    public List<Student>findByLastNameNotNull();
    public List<Student>findByGuardianName(String guardianName);
    //JPQL query
   @Query("select s from Student s where s.email=?1")
    Student getStudentByEmailAddress(String emailId);


    @Query("select s.firstName from Student s where s.email=?1")
    String getStudentFirstNameByEmailAddress(String emailId);
    //Native Query
    @Query(
            value = "SELECT * FROM tbl_student s where s.email=?",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

//Native Named Param
    @Query(
            value = "SELECT * FROM tbl_student s where s.email= :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name =?1 where email =?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);
}



