package cn.jaychang.scstudy.hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jay Chang
 * @date 2018/9/19
 */
@RestController
public class HelloController {
    @Value("${server.port:8011}")
    private String serverPort;
    @GetMapping("/hello")
    public String hello(String name){
        return "Hello,I am "+name+",I am listening on port "+serverPort;
    }

}
