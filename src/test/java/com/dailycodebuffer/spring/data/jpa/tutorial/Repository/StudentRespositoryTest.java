package com.dailycodebuffer.spring.data.jpa.tutorial.Repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.Entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class StudentRespositoryTest {
    @Autowired
    private StudentRespository studentRespository;

    @Test
    public void saveStudent(){
        Guardian guardian = Guardian.builder()
                .name("Angelica Kyeah")
                .guardianEmail("angelica@gmail.com")
                .mobile("0544704432")
                .build();
        
        Student student = Student.builder()
                .firstName("Kobina")
                .lastName("Cheah")
                .studentEmail("kobicheah@gmail.com")
                .guardian(guardian)
                .build();
        System.out.println(student);
        studentRespository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRespository.findAll();
        studentList.stream()
                .forEach(System.out::println);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> studentList = studentRespository.findStudentByFirstName("David");
        studentList.stream()
                .forEach(System.out::println);
    }

    @Test
    public void printStudentByLastName(){
        Student studentList  = studentRespository.findStudentByLastName("Bentil Mensah");
        System.out.println(studentList);
    }

    @Test
    public void printStudentByGuardianName(){
        List<Student> studentList = studentRespository.findByGuardianName("Stephen Mensah");
        System.out.println(studentList);
    }

    @Test
    public void printStudentByLastNameAndFirstName(){
        Student student = studentRespository.findStudentByLastNameAndFirstName("Gadagoe","Truth");
        System.out.println(student);
    }

//    Testing JPA Query methods
    @Test
    public void printGetStudentByEmailAddress(){
        Student student = studentRespository.getStudentByEmailAddress("truthgad35@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String  student = studentRespository.getStudentFirstNameByEmailAddress("truthgad35@gmail.com");
        System.out.println("First name: " + student);
    }

    @Test
    public void printStudentFirstNameAndLastNameByEmailAddress(){
        String  student = studentRespository.getStudentFirstNameAndLastNameByEmailAddress("truthgad35@gmail.com");
        System.out.println("First name: " + student);
    }

//    NATIVE QUERIES

    @Test
    public void printGetStudentByNativeQuery(){
        Student student = studentRespository.getStudentByEmailAddressNativeQuery("freder@turntabl.io");
        System.out.println(student);
    }

//     QUERY PARAMS

    @Test
    public void printGetStudentByEmailAddressUsingQueryParam(){
        Student student = studentRespository.getStudentByEmailAddressUsingQueryParam("freder@turntabl.io");
        System.out.println(student);
    }

//    UPDATING QUERIES

@Test
    public void updateStudentFirstNameByEmail_UsingNativeParam(){
        studentRespository.updateStudentFirstNameByEmail_UsingNativeParam
                (
                "Fredrick Gunnar",
                "freder@turntabl.io"
                );
    }

//    Pagination in Students
//    @Test
//    public void findAllPageOfStudent(){
//        Pageable firstThreePages = PageRequest.of(0,4);
//
//        List<Student> studentPage = studentRespository.findAll(firstThreePages).getContent();
//        studentPage.stream().forEach(System.out::println);
//    }







}