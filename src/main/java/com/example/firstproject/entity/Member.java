package com.example.firstproject.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Controller;

@Entity
@AllArgsConstructor
@ToString
public class Member {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

}
