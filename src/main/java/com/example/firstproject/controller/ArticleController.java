package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Slf4j // Simple Logging Facade For Java  / 로깅 기능을 쓸 수 있다.
@Controller     // 컨트롤러임을 선언한다.
public class ArticleController {

    @Autowired // 스프링부트가 미리 생성해놓은 리포지토리 객체 주입
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")        // URL 요청을 접수한다.
    public String newArticleForm() {     // 메서드 생성 및 반환값을 작성한다.

        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) { // form 데이터를 DTO로 받기

//        System.out.println(form.toString()); // DTO에 폼 데이터가 잘 담겼는지 확인
        log.info(form.toString());

        // 1. DTO를 Entity로 변환
        Article article = form.toEntity();
//        System.out.println(article.toString()); // DTO 엔티티로 잘 변환 됐는지 확인
        log.info(article.toString());

        //2. Repository를 통하여 Entity를 DB(Database)에 저장
        Article saved = articleRepository.save(article); // article 엔티티를 저장해 saved 객체에 반환
//        System.out.println(saved.toString()); // article이 DB에 잘 저장 됐는지 확인
        log.info(saved.toString());

        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")       // 데이터 조회 요청 접수
    public String show(@PathVariable Long id, Model model){
    //@PathVariable : URL요청으로 들어온 전달값을 컨트롤러의 매개변수로 가져오는 어노테이션

        log.info("id = " + id); // id를 잘 받았는가 로그 찍어보기.

        //1. id를 조회해 데이터 가져오기
      Article articleEntity = articleRepository.findById(id).orElse(null);
      //id 값으로 데이터를 찾을 때 해당 값이 없으면 null을 반환하라.

        //2. 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);

        //3. 뷰 페이지 반환하기
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){

        //1. 모든 데이터 가져오기
        List<Article> articleEntitylist = articleRepository.findAll();

        //2. 모델에 데이터 등록하기
        model.addAttribute("articleList", articleEntitylist);

        //3. 뷰 페이지 설정하기
        return "articles/index";
    }

}
