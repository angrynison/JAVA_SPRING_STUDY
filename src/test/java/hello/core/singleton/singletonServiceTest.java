package hello.core.singleton;

import hello.core.SpringConfig;
import hello.core.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// 프로젝트의 모든 빈(JPA 포함)을 다 올려줌
@SpringBootTest
public class singletonServiceTest {
    // SpringBootTest를 통해 생성한 컨테이너 그냥 가져오기
    @Autowired
    ApplicationContext ac;

    @Test
    @DisplayName("같은 객체인지 검사")
    void singletonTest() {
        // private으로 막아놨기 때문에 오류가 발생한다
        // SingletonService singletonService = new SingletonService();

        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1: " + singletonService1);
        System.out.println("singletonService2: " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);

    }

    @Test
    @DisplayName("스프링 컨테이너를 이용한 싱글톤 패턴")
    void springContainer() {
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        // 생성한 컨테이너의 service 객체 받아오기
        MemberService memberService1 = ac.getBean(MemberService.class);
        MemberService memberService2 = ac.getBean(MemberService.class);

        System.out.println("memberService1: " + memberService1);
        System.out.println("memberService2: " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }
}
