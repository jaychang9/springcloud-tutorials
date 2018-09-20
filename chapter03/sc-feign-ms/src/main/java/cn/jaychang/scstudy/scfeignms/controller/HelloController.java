package cn.jaychang.scstudy.scfeignms.controller;

import cn.jaychang.scstudy.scfeignms.feign.HelloFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.scfeignms.controller
 * @description TODO
 * @create 2018-09-20 10:16
 */
@RestController
public class HelloController {

    @Autowired
    private HelloFeignClient helloFeignClient;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",required = false,defaultValue = "springcloud") String name){
        return helloFeignClient.sayHello(name);
    }
}
