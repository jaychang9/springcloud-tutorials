package cn.jaychang.scstudy.scconfigserverms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigserverMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigserverMsApplication.class, args);
	}
}
