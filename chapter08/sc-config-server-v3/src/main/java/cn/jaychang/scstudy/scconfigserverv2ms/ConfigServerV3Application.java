package cn.jaychang.scstudy.scconfigserverv2ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServerV3Application {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerV3Application.class, args);
	}
}