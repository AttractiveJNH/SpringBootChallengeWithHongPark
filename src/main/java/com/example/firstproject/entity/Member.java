package com.example.firstproject.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Controller;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column
    public Long id;

    @Column
    private String email;

    @Column
    private String password;

}
