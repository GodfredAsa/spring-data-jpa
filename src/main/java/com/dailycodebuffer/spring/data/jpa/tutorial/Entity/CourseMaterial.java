package com.dailycodebuffer.spring.data.jpa.tutorial.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseMaterialID;
    private String courseUrl;


    /*
     * when saving a course courseMaterial is required.
     * You can't save a course without a course Material
     */
    @OneToOne(
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
