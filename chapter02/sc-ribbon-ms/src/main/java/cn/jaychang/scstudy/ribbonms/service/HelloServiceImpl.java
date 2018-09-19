package cn.jaychang.scstudy.ribbonms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jay Chang
 * @date 2018/9/19
 */
@Service
public class HelloServiceImpl implements HelloService{

    private RestTemplate restTemplate;

    @Autowired
    public HelloServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public String hello(String name){
        Map<String,String> params = new HashMap<>();
        params.put("name",name);
        // 调用注册注册中心，服务实例名为SC-HELLO-MS的服务的/hello接口
        return restTemplate.getForObject("http://SC-HELLO-MS/hello?name="+name,String.class);
    }
}
