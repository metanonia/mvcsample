package com.metanonia.mvcsample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/feed")
public class FeedController {
    @GetMapping("/order")
    public String orderPage(@AuthenticationPrincipal UserDetails user) {
        log.info(user.toString());
        return "/feed/order";
    }
}
