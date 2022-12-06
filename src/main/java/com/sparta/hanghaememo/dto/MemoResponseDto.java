package com.sparta.hanghaememo.dto;

import com.sparta.hanghaememo.entity.Memo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class MemoResponseDto {

    private Long id;
    private String title;
    private String contents;
    private Long userId;
    private String username;

    private LocalDateTime createAt;

    private LocalDateTime modifiedAt;


    public MemoResponseDto(Memo memo) {
        this.id = memo.getId();
        this.title = memo.getTitle();
        this.contents = memo.getContents();
        this.userId = memo.getUserId();
        this.username = memo.getUsername();
        this.createAt = memo.getCreatedAt();
        this.modifiedAt = memo.getModifiedAt();
    }
}
