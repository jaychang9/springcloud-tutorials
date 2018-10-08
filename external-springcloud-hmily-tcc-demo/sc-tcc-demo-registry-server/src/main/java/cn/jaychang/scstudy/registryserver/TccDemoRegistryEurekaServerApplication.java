package cn.jaychang.scstudy.registryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Jay Chang
 */
@EnableEurekaServer
@SpringBootApplication
public class TccDemoRegistryEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TccDemoRegistryEurekaServerApplication.class, args);
	}
}
