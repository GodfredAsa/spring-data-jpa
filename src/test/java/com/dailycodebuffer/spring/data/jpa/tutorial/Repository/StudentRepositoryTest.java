package com.dailycodebuffer.spring.data.jpa.tutorial.Repository;
import com.dailycodebuffer.spring.data.jpa.tutorial.Entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Guardian guardian = Guardian.builder()
                .name("Kwabena")
                .guardianEmail("kwabena.sams@gmail.com")
                .mobile("0204067441")
                .build();

        Student student = Student.builder()
                .firstName("Kings")
                .lastName("Kanga")
                .studentEmail("kingskanga@gmail.com")
                .guardian(guardian)
                .build();
        System.out.println(student);
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        studentList
                .forEach(System.out::println);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> studentList = studentRepository.findStudentByFirstName("David");
        studentList
                .forEach(System.out::println);
    }

    @Test
    public void printStudentByLastName(){
        Student studentList  = studentRepository.findStudentByLastName("Bentil Mensah");
        System.out.println(studentList);
    }

    @Test
    public void printStudentByGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("Stephen Mensah");
        System.out.println(studentList);
    }

    @Test
    public void printStudentByLastNameAndFirstName(){
        Student student = studentRepository.findStudentByLastNameAndFirstName("Gadagoe","Truth");
        System.out.println(student);
    }

//    Testing JPA Query methods
    @Test
    public void printGetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("truthgad35@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String  student = studentRepository.getStudentFirstNameByEmailAddress("truthgad35@gmail.com");
        System.out.println("First name: " + student);
    }

    @Test
    public void printStudentFirstNameAndLastNameByEmailAddress(){
        String  student = studentRepository.getStudentFirstNameAndLastNameByEmailAddress("truthgad35@gmail.com");
        System.out.println("First name: " + student);
    }

//    NATIVE QUERIES

    @Test
    public void printGetStudentByNativeQuery(){
        Student student = studentRepository.getStudentByEmailAddressNativeQuery("freder@turntabl.io");
        System.out.println(student);
    }

//     QUERY PARAMS

    @Test
    public void printGetStudentByEmailAddressUsingQueryParam(){
        Student student = studentRepository
                .getStudentByEmailAddressUsingQueryParam("freder@turntabl.io");
        System.out.println(student);
    }

//    UPDATING QUERIES

@Test
    public void updateStudentFirstNameByEmail_UsingNativeParam(){
        studentRepository.updateStudentFirstNameByEmail_UsingNativeParam(
                "Emmanuel Goddingod Asamoah",
                "freder@turntabl.io"
                );
    }

//    Pagination in Students
//    @Test
//    public void findAllPageOfStudent(){
//        Pageable firstThreePages = (Pageable) PageRequest.of(0,4);
//
//        List<Student> studentPage = studentRepository.findAll((org.springframework.data.domain.Pageable) firstThreePages).getContent();
//        studentPage.forEach(System.out::println);
//    }
}