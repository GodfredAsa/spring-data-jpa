package com.dailycodebuffer.spring.data.jpa.tutorial.Repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.Entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.List;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void savingCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Sighn")
                .mobile("0204067441")
                .build();

        Course course = Course.builder()
                .courseTitle("Things Life take from Us")
                .courseCredit(5)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void printCourseByEmail(){
        List<Course> courseList = courseRepository.findCourseByCourseTitle("Data Science");
        System.out.println(courseList);
    }

    @Test
    public void printAllCourse(){
        List<Course> courseList = courseRepository.findAll();
//        courseList.stream().forEach(System.out::println); // this line makes it run error
    }

    /**
     * Pagination
     */

    @Test
    public void findAllPageOfCourses(){
        //Pagination

        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);

        List<Course> courseList = courseRepository.findAll(secondPageWithTwoRecords).getContent();

        long totalNumberOfElement = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
        long nPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println("Total Number of Elements: " + totalNumberOfElement );
        System.out.println("Number of Pages: " + nPages );

        courseList.stream().forEach(System.out::println);



    }



}