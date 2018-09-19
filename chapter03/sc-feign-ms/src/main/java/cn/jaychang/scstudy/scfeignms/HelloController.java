package cn.jaychang.scstudy.scfeignms;

import cn.jaychang.scstudy.scfeignms.feign.HelloFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jay Chang
 * @date 2018/9/20
 */
@RestController
public class HelloController {

    @Autowired
    private HelloFeignClient helloFeignClient;

    public HelloController(HelloFeignClient helloFeignClient){
        this.helloFeignClient = helloFeignClient;
    }

    @GetMapping("hello")
    public String hello(@RequestParam("name") String name){
        return helloFeignClient.sayHelloFromClient(name);
    }
}
