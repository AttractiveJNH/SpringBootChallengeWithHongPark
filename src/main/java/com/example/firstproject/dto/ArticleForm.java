package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@AllArgsConstructor
//생성자가 자동으로 추가되는 어노테이션이다.
@ToString
@Getter @Setter
@NoArgsConstructor
public class ArticleForm {

    private Long id;            // id 필드 추가
    private String title;       // 제목을 받을 필드
    private String content;     // 내용을 받을 필드


    public Article toEntity() {
        // DTO인 form 객체를 entity 객체로 변환하는 역할을 한다.

        return new Article(id, title, content);

    }
}
