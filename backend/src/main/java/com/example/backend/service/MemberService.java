package com.example.backend.service;

//import com.example.backend.dto.Member;

import com.example.backend.dto.MemberJpa;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface MemberService {
    MemberJpa join(MemberJpa memberJpa);
    Optional<MemberJpa> Login(String id, String pw);
}
