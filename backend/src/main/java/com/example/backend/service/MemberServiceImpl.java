package com.example.backend.service;

import com.example.backend.dto.MemberJpa;
import com.example.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public MemberJpa join(MemberJpa memberJpa) {
        MemberJpa join = memberRepository.save(memberJpa);
        return join;
    }

    @Override
    public Optional<MemberJpa> Login(String id, String pw) {
        return memberRepository.FindForLogin(id,pw);
    }
}
