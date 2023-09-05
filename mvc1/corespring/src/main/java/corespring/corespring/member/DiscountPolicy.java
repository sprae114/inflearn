package corespring.corespring.member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
