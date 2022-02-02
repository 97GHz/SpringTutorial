package com.example.SpringTutorial.service;

import com.example.SpringTutorial.domain.Member;
import com.example.SpringTutorial.repository.MemberRepository;
import com.example.SpringTutorial.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void join1() {
        //given
        Member member = new Member();
        member.setName("ssqwe");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void join2() {
        Member m1 = new Member();
        m1.setName("spring2");
        Member m2 = new Member();
        m2.setName("spring2");

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
