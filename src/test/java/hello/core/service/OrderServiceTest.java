package hello.core.service;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.domain.Grade;
import hello.core.domain.Member;
import hello.core.domain.Orders;
import hello.core.domain.Product;
import hello.core.repository.MemoryOrderRepository;
import hello.core.repository.OrderRepository;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    DiscountPolicy discountPolicy = new FixDiscountPolicy();
    OrderRepository orderrepository = new MemoryOrderRepository();
    OrderService orderservice = new OrderService(discountPolicy, orderrepository);

    @Test
    public void 주문테스트() {
        //Gvien
        Member member = new Member(0L,"앵그리", Grade.VIP);
        Product product = new Product(0L,"휴지",500);
        Orders result = orderservice.createOrders(member, product);

        System.out.println(result.getProductPrice());
        System.out.println(result.getDiscountPrice());
    }
}
