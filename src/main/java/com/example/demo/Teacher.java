package com.example.demo;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
//@Getter 
//@Setter
public class Teacher extends Person {
	
    @Column(name="school_name", length=50, nullable=false, unique=false)
    private String schoolName ; 
}