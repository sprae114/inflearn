package corespring.corespring;

import corespring.corespring.member.Grade;
import corespring.corespring.member.Member;
import corespring.corespring.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {  //이거 빼먹으면 실행이 안됌
//        MemberService memberService = new MemberServiceImpl(memberRepository);  //오른쪽항에 자꾸 구현체가 아닌 인터페이스를 넣음
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); //메서드명, 해당 클래스
        Member member = new Member(1L, "member1", Grade.VIP);   //문자에 "" 빼먹음, enum에 형태
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
