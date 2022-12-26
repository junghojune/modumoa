package com.hosu.project.modumoa.member.controller;

import com.hosu.project.modumoa.exception.AlreadyRegisteredUserException;
import com.hosu.project.modumoa.exception.MemberOrPasswordNotFoundException;
import com.hosu.project.modumoa.member.model.PostLoginReqDto;
import com.hosu.project.modumoa.member.model.PostSignUpReqDto;
import com.hosu.project.modumoa.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute PostLoginReqDto postLoginReqDto) throws MemberOrPasswordNotFoundException {

        try {
            memberService.login(postLoginReqDto);
        } catch (Exception e) {
            return "redirect:login";
        }

        return "redirect:/";
    }

    @GetMapping("/join")
    public String join() {
        return "member/join";
    }

    @PostMapping("/join")
    public String signUp(@ModelAttribute PostSignUpReqDto postSignUpReqDto) throws AlreadyRegisteredUserException {
        memberService.signUp(postSignUpReqDto);

        return "redirect:login";
    }

    @DeleteMapping("/signOut")
    public void signOut(PostLoginReqDto loginReqDto){
        memberService.signOut(loginReqDto);
    }


}
