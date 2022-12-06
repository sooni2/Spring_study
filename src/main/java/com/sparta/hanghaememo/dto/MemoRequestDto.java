package com.sparta.hanghaememo.dto;

import com.sparta.hanghaememo.entity.Memo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemoRequestDto {

    private String contents;
    private String title;
    private Long id;

    public MemoRequestDto(Memo memo) {
        this.contents = memo.getContents();
        this.title = memo.getTitle();
        this.id = memo.getId();
    }
}
