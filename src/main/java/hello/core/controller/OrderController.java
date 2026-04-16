package hello.core.controller;

import hello.core.domain.Member;
import hello.core.domain.Product;
import hello.core.dto.OrderForm;
import hello.core.repository.MemberRepository;
import hello.core.repository.OrderRepository;
import hello.core.repository.ProductRepository;
import hello.core.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderController(OrderService orderService, MemberRepository memberRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.memberRepository = memberRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orders/createOrders")
    public String orders(Model model) {
        model.addAttribute("products",  productRepository.findAll());
        return "/orders/create0rderForm";
    }

    @GetMapping("/orderList")
    public String orderList(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "/orders/orderList";
    }

    @PostMapping("/order_create")
    public String create_order(OrderForm form) {
        Member member = memberRepository.findById(form.getMemberId()).get();
        Product product = productRepository.findById(form.getProductId()).get();
        int orderCount = form.getOrderCount();
        orderService.createOrders(member, product, orderCount);
        return "redirect:/";
    }



}
