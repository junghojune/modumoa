package com.hosu.project.modumoa.member.service;

import com.hosu.project.modumoa.member.model.Member;
import com.hosu.project.modumoa.member.model.PostSignUpReqDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Member creatMember(){

        return Member.builder()
                .name("정호준")
                .email("test@email.com")
                .password("1111")
                .birthDay("1998-09-04")
                .host(true)
                .phoneNumber("01071730340")
                .build();
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void SaveMemberTest(){
        PostSignUpReqDto postSignUpReqDto = PostSignUpReqDto.builder()
                .name("정호준")
                .email("test@email.com")
                .password("1111")
                .birthday("1998-09-04")
                .host(true)
                .phoneNumber("01071730340")
                .build();
        Member member = creatMember();
        Member savedMember = memberService.signUp(postSignUpReqDto);

        assertEquals(member.getEmail(), savedMember.getEmail());
        assertEquals(member.getName(), savedMember.getName());
        assertEquals(member.getPhoneNumber(), savedMember.getPhoneNumber());
        assertEquals(member.getStatus(), savedMember.getStatus());
    }
}