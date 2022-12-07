package com.sparta.hanghaememo.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    @Size(min = 4, max = 10, message = "아이디의 길이는 4자에서 10자 사이입니다")
    @Pattern(regexp = "[a-z0-9]*$", message = "아이디 형식이 일치하지 않습니다")
    private String username;

    @Size(min = 8, max = 15, message = "비밀번호의 길이는 8자에서 15자 사이입니다")
    @Pattern(regexp = "[a-zA-Z0-9`~!@#$%^&*()_=+|{};:,.<>/?]*$", message = "비밀번호 형식이 일치하지 않습니다")
    private String password;

    private boolean admin = false;
    private String adminToken = "";
}