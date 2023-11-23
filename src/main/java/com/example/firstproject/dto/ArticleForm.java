package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class ArticleForm {
    private String title;       // 제목을 받을 필드
    private String content;     // 내용을 받을 필드

    // 전송받은 제목과 내용을 필드에 저장하는 생성자 추가
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    
    // 데이터를 잘 받았는지 확인 할 toString() 메서드 추가
    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Article toEntity() {
        // DTO인 form 객체를 entity 객체로 변환하는 역할을 한다.

        return new Article(null, title, content);
        // id는 자동생성이라 null을 반환해야한다.
    }
}
