package com.example.firstproject.controller;


import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    MemberRepository memberRepository;


    @GetMapping("/signup")
    public String registerMember(){
        return "members/new";
    }

    @PostMapping("/join")
    public String joinMember(MemberForm memberForm){

        Member member = memberForm.toEntity();      // dto->entity
        System.out.println(memberForm.toString());

        Member saved = memberRepository.save(member);
        System.out.println(saved.toString());       //  DB에 저장이 됐는가 확인.

        return "";

    }
}
