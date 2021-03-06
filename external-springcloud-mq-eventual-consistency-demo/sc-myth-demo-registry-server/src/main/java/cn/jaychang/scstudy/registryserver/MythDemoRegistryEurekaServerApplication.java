package cn.jaychang.scstudy.registryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Jay Chang
 */
@EnableEurekaServer
@SpringBootApplication
public class MythDemoRegistryEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MythDemoRegistryEurekaServerApplication.class, args);
	}
}
