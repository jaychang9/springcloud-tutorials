package cn.jaychang.scstudy.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhangjie
 */
@ImportResource(locations = {"classpath:spring/spring-rabbitmq.xml"})
@MapperScan("cn.jaychang.scstudy.order.dao")
@EnableFeignClients
//@EnableDiscoveryClient 用于发现其他服务
@EnableDiscoveryClient
@EnableEurekaClient
@EnableTransactionManagement
@SpringBootApplication
public class MythDemoOrderMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MythDemoOrderMsApplication.class, args);
	}
}
