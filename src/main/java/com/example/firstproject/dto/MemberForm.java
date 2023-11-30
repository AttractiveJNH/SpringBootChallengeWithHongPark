package com.example.firstproject.dto;

import com.example.firstproject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter @Setter
public class MemberForm {

    private String email;

    private String password;


    public Member toEntity() {
        return new Member(null, email, password);
    }
}
