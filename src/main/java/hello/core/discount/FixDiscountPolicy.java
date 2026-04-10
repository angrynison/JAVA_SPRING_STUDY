package hello.core.discount;

import hello.core.domain.Grade;
import hello.core.domain.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    @Override
    public double discount(Member member, double price) {
        if(member.getGrade() == Grade.VIP) {
            return price - 1000;
        }
        return price;
    }
}
