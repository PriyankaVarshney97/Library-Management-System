package com.priyanka.lms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priyanka.lms.Entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {}
