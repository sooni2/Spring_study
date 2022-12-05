package com.sparta.hanghaememo.dto;

import com.sparta.hanghaememo.entity.Memo;
import lombok.Getter;

@Getter
public class MemoRequestDto {

    private String contents;
    private String password;
    private String title;
    private String author;
    private String userId;
}
