package springcore.core;

import springcore.core.member.Grade;
import springcore.core.member.Member;
import springcore.core.member.MemberService;
import springcore.core.order.Order;
import springcore.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl(memberRepository);
//        OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
