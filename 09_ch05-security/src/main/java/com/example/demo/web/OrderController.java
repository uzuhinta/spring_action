package com.example.demo.web;

import com.example.demo.TacoOrder;
import com.example.demo.User;
import com.example.demo.data.OrderRepository;
import com.example.demo.data.UserRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepository;

    private UserRepository userRepository;

    public OrderController(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus, Principal principal) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        User user = (User) userRepository.findByUsername(principal.getName());
        order.setUser(user);
        log.info("Order submitted: {}", order);
        orderRepository.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
