package dev.timstanford.jwt_demo.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    //https://www.youtube.com/watch?v=KYNR5js2cXE
    //https://www.danvega.dev/blog/spring-security-jwt

    //bookmark in article, generate keypair

    @GetMapping
    public String home(Principal principal){
        return "Hello, "+principal.getName()+"!";
    }
}
