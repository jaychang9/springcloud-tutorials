package cn.jaychang.scstudy.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhangjie
 */
@MapperScan("cn.jaychang.scstudy.order.dao")
@EnableFeignClients
//@EnableDiscoveryClient 用于发现其他服务
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class TccDemoOrderMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TccDemoOrderMsApplication.class, args);
	}
}
