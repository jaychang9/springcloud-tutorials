package cn.jaychang.scstudy.registryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 高可用注册中心
 * @author Jay Chang
 */
@EnableEurekaServer
@SpringBootApplication
public class HaRegistryEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaRegistryEurekaServerApplication.class, args);
	}
}