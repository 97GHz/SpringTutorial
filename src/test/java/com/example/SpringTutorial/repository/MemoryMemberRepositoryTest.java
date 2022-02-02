package com.example.SpringTutorial.repository;

import com.example.SpringTutorial.domain.Member;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName(){
        Member m1 = new Member();
        m1.setName("spring1");
        repository.save(m1);

        Member m2 = new Member();
        m2.setName("spring2");
        repository.save(m2);

        Member result = repository.findByName("spring1").get();
        Assertions.assertEquals(m1, result);
    }

    @Test
    public void findAll(){
        Member m1 = new Member();
        m1.setName("spring1");
        repository.save(m1);

        Member m2 = new Member();
        m2.setName("spring2");
        repository.save(m2);

        List<Member> result = repository.findAll();
        Assertions.assertEquals(result.size(), 2);
    }
}
