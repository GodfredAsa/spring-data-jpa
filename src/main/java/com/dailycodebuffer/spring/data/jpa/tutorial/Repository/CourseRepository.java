package com.dailycodebuffer.spring.data.jpa.tutorial.Repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.Entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findCourseByCourseTitle(String courseTitle);
//    List<Course> findAll();

//    CUSTOM SORTING METHODS

    Page<Course> findByCourseTitleContaining(
            String courseTitle,
            Pageable pageable);
}
