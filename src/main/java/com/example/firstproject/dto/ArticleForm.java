package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@AllArgsConstructor
//생성자가 자동으로 추가되는 어노테이션이다.
@ToString
public class ArticleForm {
    private String title;       // 제목을 받을 필드
    private String content;     // 내용을 받을 필드


    public Article toEntity() {
        // DTO인 form 객체를 entity 객체로 변환하는 역할을 한다.

        return new Article(null, title, content);
        // id는 자동생성이라 null을 반환해야한다.
    }
}
