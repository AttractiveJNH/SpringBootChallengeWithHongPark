package com.example.firstproject.controller;


import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;


@Slf4j
@Controller
public class MemberController {

    @Autowired
    MemberRepository memberRepository;


    @GetMapping("/signup")
    public String registerMember() {
        return "members/new";
    }

    @PostMapping("/join")
    public String joinMember(MemberForm memberForm) {

        log.info(memberForm.toString());

        Member member = memberForm.toEntity();      // dto->entity
        log.info(member.toString());

        Member saved = memberRepository.save(member);
        log.info(saved.toString());       //  DB에 저장이 됐는가 확인.

        return "redirect:/members/" + saved.getId();

    }

    //셀프체크 풀어보기

    @GetMapping("/members/new")
    public String newMemberForm(){
        return "members/new";
    }


    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {

        Member member = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", member);

        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model) {

        Iterable<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);

        return "members/index";
    }




}
