package cn.jaychang.scstudy.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Jay Chang
 */
@EnableEurekaClient
@SpringBootApplication
public class HelloMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloMsApplication.class, args);
	}
}
