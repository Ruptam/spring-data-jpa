package com.ruptam.springdatajpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(
    name = "tbl_course_material"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    
    @Id
    @SequenceGenerator(
        name = "course_material_sequence",
        sequenceName = "course_material_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "course_material_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "url")
    private String url;

    @OneToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    //referencedColumnName is the column defined in other table's primary key
    //name is the new column name defined the mapping column in the table
    private Course course;
}
