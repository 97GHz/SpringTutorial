package com.example.SpringTutorial.service;

import com.example.SpringTutorial.domain.Member;
import com.example.SpringTutorial.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
        //DI(Dependency Injection)
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join1() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void join2() {
        Member m1 = new Member();
        m1.setName("spring");
        Member m2 = new Member();
        m2.setName("spring");

        memberService.join(m1);
        assertThrows(IllegalStateException.class, () -> memberService.join(m2));
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}