package com.sparta.hanghaememo.service;

import com.sparta.hanghaememo.dto.MemoRequestDto;
import com.sparta.hanghaememo.entity.Memo;
import com.sparta.hanghaememo.entity.User;
import com.sparta.hanghaememo.entity.UserRoleEnum;
import com.sparta.hanghaememo.jwt.JwtUtil;
import com.sparta.hanghaememo.repository.MemoRepository;
import com.sparta.hanghaememo.repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    //게시글 작성
    @Transactional
    public Memo createMemo(MemoRequestDto requestDto, HttpServletRequest request) {
        //Request에서 Token 가져오기
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        //토큰이 있는 경우에만 게시글 작성 가능
        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                //토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            //토큰에서 가져온 사용자 정보를 사용하여 DB 조회
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );

            //요청 받은 Dto로 DB에 저장할 객체 만들기
            Memo memo = memoRepository.saveAndFlush(new Memo(requestDto, user.getId()));

            return new MemoRequestDto(memo);
        } else {
            return null;
        }
    }

    //게시글 조회
    @Transactional(readOnly = true)
    public List<MemoRequestDto> getMemos(HttpServletRequest request) {
        //Request에서 Token 가져오기
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        //토큰이 있는 경우에만 게시글 조회 가능
        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                //토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            //토큰에서 가져온 사용자 정보를 사용하여 DB 조회
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );

            //사용자 권한 가져와서 ADMIN 이면 전체 조회, USER 이면 본인이 작성한 게시글만 조회
            UserRoleEnum userRoleEnum = user.getRole();
            List<MemoRequestDto> list = new ArrayList<>();
            List<Memo> memoList;

            if (userRoleEnum == UserRoleEnum.USER) {
                //사용자 권한이 USER일 경우
                memoList = memoRepository.findAllByUserId(user.getId());
            } else {
                memoList = memoRepository.findAllByOrderByModifiedAtDesc();
            }

            for (Memo memo : memoList) {
                list.add(new MemoRequestDto(memo));
            }

            return list;
        } else {
            return null;
        }

    }


    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        memo.update(requestDto);
        return memo.getId();
    }

    @Transactional
    public Long deleteMemo(Long id) {
        memoRepository.deleteById(id);
        return id;
    }
}