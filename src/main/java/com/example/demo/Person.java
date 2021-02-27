package com.example.demo;

import javax.persistence.*;

import lombok.Data;

@Entity 
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
public class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
    private String name; 
    
    @Temporal(TemporalType.DATE)
    private java.util.Date birthDate; 
}