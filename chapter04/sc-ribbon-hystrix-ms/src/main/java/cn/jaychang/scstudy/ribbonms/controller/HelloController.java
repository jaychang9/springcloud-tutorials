package cn.jaychang.scstudy.ribbonms.controller;

import cn.jaychang.scstudy.ribbonms.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jay Chang
 * @date 2018/9/19
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(String name){
        return helloService.hello(name);
    }
}
