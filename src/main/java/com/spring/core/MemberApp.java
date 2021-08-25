package com.spring.core;

import com.spring.core.member.Grade;
import com.spring.core.member.Member;
import com.spring.core.member.MemberService;
import com.spring.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        Member newMember = new Member(1, "member1", Grade.VIP);

        memberService.join(newMember);
        Member findMember = memberService.findMember(newMember.getId());


    }
}
