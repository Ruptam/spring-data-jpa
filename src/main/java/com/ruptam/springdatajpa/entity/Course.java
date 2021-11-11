package com.ruptam.springdatajpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_course")
@Builder

public class Course {
    @Id
    @SequenceGenerator(
        name = "course_sequence_generator",
        sequenceName = "course_sequence_generator",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "course_sequence_generator"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "credit")
    private int credit;

    @Column(name = "title")
    private String title;

    @OneToOne(
        mappedBy = "course",
        optional = false,
        cascade = CascadeType.ALL
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "teacher_id",
        referencedColumnName = "id"
    )
    private Teacher teacher;

    @ManyToMany(
        cascade = CascadeType.ALL
    )
    @JoinTable(
        name = "tbl_student_course_mp",
        joinColumns = @JoinColumn(
            name = "course_id",
            referencedColumnName = "id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "student_id",
            referencedColumnName = "id"
        )
    )
    private List<Student> students;
}
