package com.example.backend;

//import com.example.backend.repository.MemberRepositoryImpl;
//import com.example.backend.service.MemberServiceImpl;
import com.example.backend.dto.MemberJpa;
import com.example.backend.repository.MemberRepository;
import com.example.backend.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest  // 엔티티 메니저를 사용 하는 테스트 이기 때문에 순수 자바 코드인 테스트에서 넣어 줘야 함...ㅠㅠ
@Transactional // 리셋
public class MemberServiceTest {

    @Autowired MemberService memberService;
//    private EntityManager em;

    @Test
    void Sign_Up(){
        MemberJpa result = memberService.Login("asd","ddd").get();
        System.out.println("result = " + result);

    }

    @Test
//    @Commit // 적용 시키기
    void InsertDummies(){
        MemberJpa memberJpa = new MemberJpa();
        memberJpa.setId("asd");
        memberJpa.setPw("ddd");
        System.out.println(memberJpa.toString());
        //Create!!
        MemberJpa result = memberService.join(memberJpa);

        assertThat(result.getId()).isEqualTo("asd");
    }

}
