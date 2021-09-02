package com.spring.core.order;

import com.spring.core.AppConfig;
import com.spring.core.member.Grade;
import com.spring.core.member.Member;
import com.spring.core.member.MemberService;
import com.spring.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void  beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


    @Test
    void createOrder(){
        Long id = 1L;
        Member member = new Member(id, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(id, "iceCream", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
