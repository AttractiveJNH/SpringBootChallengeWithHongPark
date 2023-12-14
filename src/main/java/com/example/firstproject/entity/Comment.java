package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // GenerationType.IDENTITY = 데이터를 추가해 데이터를 생성 할 때 마다 DB가 알아서 id값을 증가시킨다.
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article; // 해당 댓글의 부모 게시글

    @Column(name="nickname")
    private String nickname; // 댓글을 단 사람

    @Column(name="body")
    private String body; // 댓글 본문
}
