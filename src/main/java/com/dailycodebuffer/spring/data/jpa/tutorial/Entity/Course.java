package com.dailycodebuffer.spring.data.jpa.tutorial.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseTitle;
    private Integer courseCredit;

    @OneToOne(
            mappedBy = "course" //course attribute in CourseMaterial
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "teacher_teacher_id",
    referencedColumnName = "teacherId"
    )
    private Teacher teacher;



}
