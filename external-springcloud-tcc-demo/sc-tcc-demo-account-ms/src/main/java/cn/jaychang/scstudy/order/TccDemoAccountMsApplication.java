package cn.jaychang.scstudy.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("cn.jaychang.scstudy.order.dao")
@EnableEurekaClient
@SpringBootApplication
public class TccDemoAccountMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TccDemoAccountMsApplication.class, args);
	}
}
