package corespring.corespring.member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 0;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            discountPercent = 10;
        }

        return discountPercent;
    }
}
