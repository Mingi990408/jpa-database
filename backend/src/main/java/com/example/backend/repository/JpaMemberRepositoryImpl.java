package com.example.backend.repository;

//import com.example.backend.dto.Member;
import com.example.backend.dto.MemberJpa;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Component
public class JpaMemberRepositoryImpl implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public MemberJpa save(MemberJpa memberJpa) {
        em.persist(memberJpa);
        return memberJpa;
    }

    @Override
    public Optional<MemberJpa> FindForLogin(String id, String pw) {
        List<MemberJpa> result = em.createQuery("select m from user_data m where m.Id = :id and m.Pw = :pw", MemberJpa.class)
                .setParameter("id", id)
                .setParameter("pw", pw)
                .getResultList();
        return result.stream().findAny();
    }


//
//    @Override
//    public boolean Login(String Id, String Pw) {
//        System.out.println("Id = " + Id + ", Pw = " + Pw);
//        if (Id.equals("asd") && Pw.equals("ddd")){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
//
//    @Override
//    public void SignUp(String Id, String Pw) {
//        Member member = new Member();
//        member.setId(Id);
//        member.setPw(Pw);
//        em.persist(member);
//    }
}
