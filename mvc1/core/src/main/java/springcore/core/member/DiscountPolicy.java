package springcore.core.member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}