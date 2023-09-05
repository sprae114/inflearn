package corespring.corespring;

import corespring.corespring.member.*;
import corespring.corespring.order.OrderService;
import corespring.corespring.order.OrderServiceImpl;
import corespring.corespring.member.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
public class AppConfig {
//      psvm 안들어감!! -> 이거는 실행시킬때만
        @Bean
        public MemberRepository memberRepository(){
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberService memberService() {
            return new MemberServiceImpl(memberRepository());
        }

        @Bean
        public DiscountPolicy discountPolicy(){return new FixDiscountPolicy();}

        @Bean
        public OrderService orderService() {
            return new OrderServiceImpl(memberRepository(), discountPolicy());
        }
}
