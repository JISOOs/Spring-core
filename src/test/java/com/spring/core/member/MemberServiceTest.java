package com.spring.core.member;

import com.spring.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    void  beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {

        //given
        Member newMember = new Member(1L, "member1", Grade.VIP);
        //when
        memberService.join(newMember);
        Member findMember = memberService.findMember(1l);
        //then
        Assertions.assertThat(newMember).isEqualTo(findMember);
    }

}
