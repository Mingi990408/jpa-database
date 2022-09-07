package com.example.backend.controller;

import com.example.backend.dto.MemberJpa;
import com.example.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("")
    public String home(){
        return "Home.html";
    }

    @ResponseBody
    @GetMapping("/SignUp")
    public MemberJpa SignUp(@RequestParam String id, String password){
        MemberJpa memberJpa = new MemberJpa();
        memberJpa.setId(id);
        memberJpa.setPw(password);
        return memberService.join(memberJpa);
    }

    @ResponseBody
    @GetMapping("/login")
    public String login(@RequestParam String id, String password){
        MemberJpa result = memberService.Login(id, password).get();
        result.toString();
        return "로그인성공";
    }

}
