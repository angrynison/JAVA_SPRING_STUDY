package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicyImpl;
import hello.core.repository.*;

import hello.core.service.MemberService;
import hello.core.service.OrderService;
import hello.core.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

     public SpringConfig(MemberRepository memberRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.memberRepository = memberRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
     }

/*
    스프링 데이터 jpa를 쓰면 구현체를 만들필요가 없음 자동으로 구현체를 만들어서 주입하기때문에,
    그러므로 따로 repository에 구현체를 빈으로 주입할 필요가 없음 SpringConfig 생성자를 만들어
    그냥 우리 이런 repository가 있다를 알려주면됨

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderRepository orderRepository() {
        return new MemoryOrderRepository();
    }
    @Bean
    public MemoryProductRepository productRepository() {
        return new MemoryProductRepository();
    }
*/
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    @Bean
    public OrderService orderService() {
        return new OrderService(discountPolicy(), orderRepository);
    }

    @Bean
    public ProductService productService() {
        return new ProductService(productRepository);
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicyImpl();
    }
}
