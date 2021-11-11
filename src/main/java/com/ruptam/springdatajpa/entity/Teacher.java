package com.ruptam.springdatajpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_teacher")
@Builder
public class Teacher {
    
    @Id
    @SequenceGenerator(
        name = "teacher_sequence",
        sequenceName = "teacher_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "teacher_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    // @OneToMany(
    //     cascade = CascadeType.ALL
    // )
    // @JoinColumn(
    //     name = "teacher_id",
    //     referencedColumnName = "id"
    // )
    // private List<Course> courses;
}
