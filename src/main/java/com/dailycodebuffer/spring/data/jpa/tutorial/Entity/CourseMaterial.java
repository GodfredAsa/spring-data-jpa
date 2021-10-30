package com.dailycodebuffer.spring.data.jpa.tutorial.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseMaterialID;
    private String courseUrl;

    @OneToOne(
            /**
             * when saving a course courseMaterial is required.
             * You cant save a course without a course Material
             */

            cascade = CascadeType.ALL,
            fetch  = FetchType.LAZY,
            optional = false // default optional = true,
    )
    @JoinColumn(
            name = "course_materialId", // course_Id in table
            referencedColumnName = "courseId" // courseId in Course
    )
    private Course course;

}
