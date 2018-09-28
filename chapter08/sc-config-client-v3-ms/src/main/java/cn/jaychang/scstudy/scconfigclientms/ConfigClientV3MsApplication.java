package cn.jaychang.scstudy.scconfigclientms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
public class ConfigClientV3MsApplication {
	@Value("${foo}")
	String foo;

	@GetMapping("/hello")
	public String hello(){
		return "hello "+foo;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientV3MsApplication.class, args);
	}
}
