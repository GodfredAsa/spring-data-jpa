package com.dailycodebuffer.spring.data.jpa.tutorial.Repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.Entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.Entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;




//not working
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;
    @Autowired
    private CourseRepository courseRepository;

    /**
     * creating a Method to create a CourseMaterial with course
     * Saving a courseMaterial requires you to include a course per the model design
     */
    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .courseTitle("Business Intelligence")
                .courseCredit(4)
                .build();
        courseRepository.save(course);

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .courseUrl("www.ait.edu.gh")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);



    }

}