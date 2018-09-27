package cn.jaychang.scstudy.scfeignms.feign.fallback;

import cn.jaychang.scstudy.scfeignms.feign.HelloFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.scfeignms.feign
 * @description TODO
 * @create 2018-09-27 08:35
 */
@Component
public class HelloFallback implements HelloFeignClient {
    @Override
    public String sayHello(String name) {
        return "sorry "+name+",an error has occurred";
    }
}
