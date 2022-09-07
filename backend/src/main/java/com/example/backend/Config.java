package com.example.backend;

import com.example.backend.repository.JpaMemberRepositoryImpl;
import com.example.backend.repository.MemberRepository;
import com.example.backend.service.MemberService;
import com.example.backend.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityManager;

@Configuration
public class Config implements WebMvcConfigurer {

    // 기본 JPA
    private final EntityManager em;

    @Autowired
    public Config(EntityManager em){
        this.em = em;
    }

//    private final MemberRepository memberRepository;
//
//    @Autowired
//    public Config(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepositoryImpl(em);
    }

//    @Bean
//    public DataSource getDataSource(){
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://database-mole.ctepfv8i7jc2.us-east-1.rds.amazonaws.com:3306/mole");
//        dataSourceBuilder.username("mole");
//        dataSourceBuilder.password("wlsghd5936!");
//        return dataSourceBuilder.build();
//    }


}
