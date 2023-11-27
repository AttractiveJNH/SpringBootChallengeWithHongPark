package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // 엔티티임을 선언한다.
@ToString
@AllArgsConstructor
@NoArgsConstructor // 기본 생성자를 추가해주는 어노테이션
@Getter
public class Article {

    @Id     // 엔티티의 대푯값 지정
    @GeneratedValue     // 자동 생성 기능 추가(숫자가 자동으로 증가한다)
    private Long id;

    @Column
    private String title; // title 필드 선언, DB 테이블의 title 열과 연결됨.

    @Column
    private String content; // content 필드 선언, DB 테이블의 content 열과 연결됨.


}
