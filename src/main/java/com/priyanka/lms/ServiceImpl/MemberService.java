package com.priyanka.lms.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.lms.Entity.Member;
import com.priyanka.lms.Repository.MemberRepository;


@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }
}