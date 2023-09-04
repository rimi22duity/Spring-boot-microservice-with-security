package net.iot.authservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duity
 * @since 9/4/23
 */

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("hello")
    public ResponseEntity<String> getApi() {
        String s = "Hello World!";

        System.out.println("Inside: " + s);

        return ResponseEntity.ok(s);
    }
}
