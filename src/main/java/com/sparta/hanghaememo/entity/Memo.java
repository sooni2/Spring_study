package com.sparta.hanghaememo.entity;

import com.sparta.hanghaememo.dto.MemoRequestDto;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Memo extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private Long userId;


    public Memo(MemoRequestDto requestDto, Long userId) {
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.userId = userId;
    }

    public void update(MemoRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
    }
}