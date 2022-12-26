package com.hosu.project.modumoa.member.service;

import com.hosu.project.modumoa.exception.AlreadyRegisteredUserException;
import com.hosu.project.modumoa.exception.CustomException;
import com.hosu.project.modumoa.exception.MemberOrPasswordNotFoundException;
import com.hosu.project.modumoa.member.model.Member;
import com.hosu.project.modumoa.member.model.PostLoginReqDto;
import com.hosu.project.modumoa.member.model.PostSignUpReqDto;
import com.hosu.project.modumoa.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.hosu.project.modumoa.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<Member> login(PostLoginReqDto loginReqDto){
        Optional<Member> member = memberRepository.findByEmail(loginReqDto.getEmail());

        if(member.isEmpty()){
            throw new CustomException(NOT_FOUND_USER);
        }

        if(!passwordEncoder.matches(loginReqDto.getPassword(), member.get().getPassword())){
            throw new CustomException(INVALID_FORMAT);
        }

        return member;
    }
    public Member signUp(PostSignUpReqDto postSignUpReqDto){
        if(memberRepository.findByEmail(postSignUpReqDto.getEmail()).isPresent()){
            throw new CustomException(DUPLICATED_USERNAME);
        }

        return memberRepository.save(Member.builder()
                        .name(postSignUpReqDto.getName())
                        .email(postSignUpReqDto.getEmail())
                        .password(passwordEncoder.encode(postSignUpReqDto.getPassword()))
                        .birthDay(postSignUpReqDto.getBirthday())
                        .phoneNumber(postSignUpReqDto.getPhoneNumber())
                        .host(postSignUpReqDto.isHost())
                        .status(0)
                .build());
    }

    public void signOut(PostLoginReqDto loginReqDto){

    }
}
