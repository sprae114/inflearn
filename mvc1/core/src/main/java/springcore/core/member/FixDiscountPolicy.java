package springcore.core.member;

public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 0;   //private임 why? 내부적으로만 바꾸기 위함

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){   //Member에서 꺼내와야함, enum은 ==와 equals와 동일일
           discountFixAmount = 1000;
        }

        return discountFixAmount;
    }
}
