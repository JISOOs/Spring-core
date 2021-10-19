package com.spring.core.beanfind;

import com.spring.core.discount.DiscountPolicy;
import com.spring.core.discount.FixDiscountPolicy;
import com.spring.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상 이면, 중복 오류가 발생한다.")
    void findByParentTypeDuplicate(){

        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));

    }

    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상 이면, 빈 이름을 지정하면 된다")
    void findByParentTypeBeanName(){

        DiscountPolicy bean = ac.getBean("rateDiscountPolicy",DiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(bean).isInstanceOf(DiscountPolicy.class);

    }

    @Test
    @DisplayName("부모 타입으로 모든 빈 조회하기")
    void findAllBeanByParentType(){

        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        for(String key: beansOfType.keySet()){
            System.out.println("key: "+key+" value: "+beansOfType.get(key));
        }
        System.out.println("beansOfType :"+beansOfType);
        org.assertj.core.api.Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("부모 타입으로 모든 빈 조회하기 - Object")
    void findAllBeanByObjectType(){

        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for(String key: beansOfType.keySet()){
            System.out.println("key: "+key+" value: "+beansOfType.get(key));
        }

    }

    @Configuration
    static class TestConfig{

        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
    }
}
