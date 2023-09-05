package springcore.core;

import springcore.core.member.*;
import springcore.core.order.OrderService;
import springcore.core.order.OrderServiceImpl;

public class AppConfig {
//      psvm 안들어감!! -> 이거는 실행시킬때만
        public MemberRepository memberRepository(){
            return new MemoryMemberRepository();
        }

        public MemberService memberService() {
            return new MemberServiceImpl(memberRepository());
        }

        public DiscountPolicy discountPolicy(){return new FixDiscountPolicy();}

        public OrderService orderService() {
            return new OrderServiceImpl(memberRepository(), discountPolicy());
        }
}
