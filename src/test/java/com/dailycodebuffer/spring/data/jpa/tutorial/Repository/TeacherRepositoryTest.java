package com.dailycodebuffer.spring.data.jpa.tutorial.Repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.Entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Ideally when you create a teacher you must also create the course he teaches
 * per the design of this model
 */
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

//        Adding lists of courses or multiple courses
        Course materialDesign = Course.builder()
                .courseTitle("Angular Framework")
                .courseCredit(5)
                .build();

        Course htmlAndCSS = Course.builder()
                .courseTitle("Web Development")
                .courseCredit(6)
                .build();


        Teacher teacher = Teacher.builder()
                .firstName("Godfred")
                .lastName("Asamoah")
                .mobile("0544704424")
//                .courses(List.of(materialDesign,htmlAndCSS))
                .build();
        teacherRepository.save(teacher);
    }

}