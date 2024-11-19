package com.twohdcd.Laptopshop.controller;

import org.springframework.web.bind.annotation.*;


@RestController
public class TestController {
    @GetMapping("/")
    public String index() {
        return "Vạn sự khởi đầu nan";
    }
}
