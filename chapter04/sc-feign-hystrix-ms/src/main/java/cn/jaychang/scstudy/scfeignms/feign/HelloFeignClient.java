package cn.jaychang.scstudy.scfeignms.feign;

import cn.jaychang.scstudy.scfeignms.feign.fallback.HelloFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "sc-hello-ms",fallback = HelloFallback.class)
public interface HelloFeignClient{
    @GetMapping("/hello")
    String sayHello(@RequestParam("name") String name);
}