package com.ruptam.springdatajpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AttributeOverrides({
    @AttributeOverride(
        name = "name",
        column = @Column(name = "gurdian_name")
    ),
    @AttributeOverride(
        name = "email",
        column = @Column(name = "gurdian_email")
    ),
    @AttributeOverride(
        name = "phoneNumber",
        column = @Column(name = "gurdian_phoneNumber")
    )
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gurdian {

    private String name;
    private String email;
    private String phoneNumber;
    
}
