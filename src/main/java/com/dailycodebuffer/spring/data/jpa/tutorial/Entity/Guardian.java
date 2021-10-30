package com.dailycodebuffer.spring.data.jpa.tutorial.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guardian {
    @Column(name = "guardian_fullName")
    private String name;
    @Column(name = "guardian_email")
    private String guardianEmail;
    @Column(name = "guardian_mobile")
    private String mobile;
}
