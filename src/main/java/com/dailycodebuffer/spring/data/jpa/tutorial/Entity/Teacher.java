package com.dailycodebuffer.spring.data.jpa.tutorial.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;
    private String firstName;
    private String lastName;
    private String mobile;


//    1 teacher can teach List<Course> --> OneToMany
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name  = "teacher_Id", referencedColumnName = "teacherId")
    private List<Course> courses;


}
