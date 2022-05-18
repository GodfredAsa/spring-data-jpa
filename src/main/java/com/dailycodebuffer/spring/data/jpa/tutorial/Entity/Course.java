package com.dailycodebuffer.spring.data.jpa.tutorial.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseTitle;
    private Integer courseCredit;

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;


//Many courses can be taught by a teacher
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;



}
