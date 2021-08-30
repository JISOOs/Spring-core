package com.spring.core.discount;

import com.spring.core.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인대상금액
     */
    int discount(Member member, int price);
}
