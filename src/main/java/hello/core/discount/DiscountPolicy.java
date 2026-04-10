package hello.core.discount;

import hello.core.domain.Member;

public interface DiscountPolicy {

    public double discount(Member member, double price);
}
