package com.example.demo;

import javax.persistence.*;

enum Gender {
    MALE, 
    FEMALE
}

@Entity
@Table(name="STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="STUDENT_NAME", length=50, nullable=false, unique=true)
    private String name;
    
    //@Transient
    private transient Integer age;
    
    @Temporal(TemporalType.DATE)
    private java.util.Date birthDate;
    //private java.sql.Date birthDate;
    
    @Enumerated(EnumType.STRING)
    private Gender gender; 
}