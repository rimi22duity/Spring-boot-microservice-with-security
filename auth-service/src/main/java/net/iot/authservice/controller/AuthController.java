package net.iot.authservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author duity
 * @since 9/4/23
 */

@Controller
public class AuthController {

    @GetMapping("/login")
    public String getLogin() {
        System.out.println("Hello There!");
        return "login";
    }

    @GetMapping("/auth")
    public String auth() {
        System.out.println("Hello There from Auth!");
        return "auth";
    }
}
