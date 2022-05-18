package com.dailycodebuffer.spring.data.jpa.tutorial.Repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//    Methods for finding student
    List<Student> findStudentByFirstName(String firstName);
    Student findStudentByLastName(String lastName);
    List<Student> findByGuardianName(String name );
    Student findStudentByLastNameAndFirstName(String lastName, String firstName);

//    JPA Query Methods is based on the classNames not the table attributes
    @Query("select s from Student s where s.studentEmail = ?1 ")
    Student getStudentByEmailAddress(String studentEmail);

    @Query("select s.firstName from Student s where s.studentEmail = ?1 ")
    String getStudentFirstNameByEmailAddress(String studentEmail);

    @Query("select s.firstName, s.lastName from Student s where s.studentEmail = ?1 ")
    String getStudentFirstNameAndLastNameByEmailAddress(String studentEmail);




//   Native Queries: used for complex data selection && WRITTEN IN SQL SYNTAX
    @Query(                                        // s.table_column  =: ?1
            value ="SELECT *FROM  tbl_student s where s.student_email = :studentEmail",//classAtt Name
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeQuery(String studentEmail);


// NATIVE NAMED PARAM QUERY
    @Query(
            value = "SELECT *FROM  tbl_student s where s.student_email = :studentEmail",
            nativeQuery = true
    )
    Student getStudentByEmailAddressUsingQueryParam(@Param("studentEmail") String studentEmail);



//    UPDATING COLUMN OR TABLE QUERIES
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_Name = :firstName where student_email = :studentEmail",
//            value = "update tbl_student set first_Name = ?1 where student_email = ?2",
            nativeQuery = true
    )
    int updateStudentFirstNameByEmail_UsingNativeParam(String firstName,String studentEmail);



}
