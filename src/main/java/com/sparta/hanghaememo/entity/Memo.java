package com.sparta.hanghaememo.entity;

import com.sparta.hanghaememo.dto.MemoRequestDto;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Memo extends Timestamped {
    //메모 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;
    //유저 아이디
    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String username;


    public Memo(MemoRequestDto requestDto, Long id, String username) {
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.userId = id;
        this.username = username;
    }

    public void update(MemoRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }

}