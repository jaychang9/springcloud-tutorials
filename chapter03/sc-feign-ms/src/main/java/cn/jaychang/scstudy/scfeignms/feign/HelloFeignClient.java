package cn.jaychang.scstudy.scfeignms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Jay Chang
 * @date 2018/9/20
 */
@FeignClient("sc-hello-ms")
public interface HelloFeignClient {
    /**
     * 调用名为sc-hello-ms服务实例名的/hello接口
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHelloFromClient(@RequestParam(value = "name") String name);
}
