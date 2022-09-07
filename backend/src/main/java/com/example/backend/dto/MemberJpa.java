package com.example.backend.dto;

import lombok.*;

import javax.persistence.*;

@Entity(name = "user_data")
@Setter
@Getter
@ToString
public class MemberJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MemberNum;

    @Column
    private String Id;

    @Column
    private String Pw;
}
