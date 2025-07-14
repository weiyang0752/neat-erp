package com.neaterp.server.controller;

import jakarta.annotation.security.PermitAll;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zwy
 * create at:  2025/7/12  12:59
 * @description: demo
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

//    @PermitAll
    @GetMapping("/test")
    public String test() {

        return "success";
    }

}
