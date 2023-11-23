package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller     // 컨트롤러임을 선언한다.
public class ArticleController {

    @Autowired // 스프링부트가 미리 생성해놓은 리포지토리 객체 주입
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")        // URL 요청을 접수한다.
    public String newArticleForm(){     // 메서드 생성 및 반환값을 작성한다.

        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){ // form 데이터를 DTO로 받기

        System.out.println(form.toString()); // DTO에 폼 데이터가 잘 담겼는지 확인

        // 1. DTO를 Entity로 변환
        Article article = form.toEntity();
        System.out.println(article.toString()); // DTO 엔티티로 잘 변환 됐는지 확인

        //2. Repository를 통하여 Entity를 DB(Database)에 저장
        Article saved = articleRepository.save(article); // article 엔티티를 저장해 saved 객체에 반환
        System.out.println(saved.toString()); // article이 DB에 잘 저장 됐는지 확인

        return "";
    }
}
