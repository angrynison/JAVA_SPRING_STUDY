package hello.core.discount;

import hello.core.domain.Grade;
import hello.core.domain.Member;


public class RateDiscountPolicyImpl implements DiscountPolicy {

    @Override
    public double discount(Member member, double price) {
        if (member.getGrade() == Grade.VIP) {
            return price*0.9;
        }
        return price;
    }
}
