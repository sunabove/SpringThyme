package com.example.demo;

import javax.persistence.*;

import lombok.Data;

@Entity 
@Data
public class MyCalc {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    Double a = 0.0 ;
    String op = "+" ;    
    Double b = 0.0 ;
    Double c = 0.0 ;
    
}