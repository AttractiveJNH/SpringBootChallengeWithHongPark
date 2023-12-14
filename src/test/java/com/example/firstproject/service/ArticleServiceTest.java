package com.example.firstproject.service;

import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //스프링부트 테스트임을 선언한다
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index() {

        //1. 예상 데이터 작성
        //2. 실제 데이터
        List<Article> articles = articleService.index();
        //3. 비교 및 검증
    }
}