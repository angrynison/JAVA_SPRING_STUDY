package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void StatefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService service1 = ac.getBean(StatefulService.class);
        StatefulService service2 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자 10000원 주문
        //service1.order("userA", 10000);
        int userA = service1.order("userA" , 10000);

        //ThreadB : B사용자 20000원 주문
        //service2.order("userA", 20000);
        int userB = service2.order("userB" , 20000);

        //ThreadA : 사용자A 주문 금액조회
        //A가 주문했으니 기댓값은 10000원이나 결과값은 20000원이다
        //int price = service1.getPrice();
        System.out.println("price: " + userA);

        Assertions.assertThat(userA).isEqualTo(10000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }


}