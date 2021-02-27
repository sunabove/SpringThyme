package com.example.demo;

import javax.persistence.*;

import lombok.*;

@Entity
@Data @EqualsAndHashCode(callSuper=false)
public class Teacher extends Person {
	
    @Column(name="school_name", length=50, nullable=false, unique=false)
    private String schoolName ; 
}