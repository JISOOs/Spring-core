package com.spring.core.beanfind;

import com.spring.core.AppConfig;
import com.spring.core.member.MemberService;
import com.spring.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanName(){
        MemberService memberService = ac.getBean("memberService",MemberService.class);
        System.out.println("memberService : "+memberService);
        System.out.println("memberService.getClass() : "+memberService.getClass());
        //instance 맞는지 확인
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("타입으로 조회")
    void findBeanType(){
        MemberService memberService = ac.getBean(MemberService.class);
        System.out.println("memberService : "+memberService);
        //instance 맞는지 확인
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("구체 타입으로 조")
    void findBeanName2(){
        MemberServiceImpl memberService = ac.getBean("memberService",MemberServiceImpl.class);
        //instance 맞는지 확인
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    //실패했을 때 터질 코드 생성
    @Test
    @DisplayName("빈 이름으로 조회x")
    void findBeanNameX(){
        //예외 코드가 터져야함
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("noName", MemberService.class));
    }
}
