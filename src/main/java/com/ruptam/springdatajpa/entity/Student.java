package com.ruptam.springdatajpa.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
    name = "tbl_student",
    uniqueConstraints = @UniqueConstraint(
        name="unique_email",
        columnNames = "email_address"
    )    
)
public class Student {

    @Id
    @SequenceGenerator(
        allocationSize = 1, 
        name = "student_sequence", 
        sequenceName = "student_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    @Column(name = "id")
    private Long studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String emailId;

    @Embedded
    private Gurdian gurdian;

}
