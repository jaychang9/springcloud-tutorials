package cn.jaychang.scstudy.scfeignms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("sc-hello-ms")
public interface HelloFeignClient{
    @GetMapping("/hello")
    String sayHello(@RequestParam("name") String name);
}