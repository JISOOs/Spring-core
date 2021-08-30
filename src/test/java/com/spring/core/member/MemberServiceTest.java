package com.spring.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    @Test
    void join() {
        MemberService memberService = new MemberServiceImpl();
        //given
        Member newMember = new Member(1L, "member1", Grade.VIP);
        //when
        memberService.join(newMember);
        Member findMember = memberService.findMember(1l);
        //then
        Assertions.assertThat(newMember).isEqualTo(findMember);
    }

}
