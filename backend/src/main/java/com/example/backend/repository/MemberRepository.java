package com.example.backend.repository;

//import com.example.backend.dto.Member;
import com.example.backend.dto.MemberJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface MemberRepository{
    MemberJpa save(MemberJpa memberJpa);
    Optional<MemberJpa> FindForLogin(String id, String pw);
}
