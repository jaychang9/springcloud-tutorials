package cn.jaychang.scstudy.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhangjie
 */
@MapperScan("cn.jaychang.scstudy.account.dao")
@EnableEurekaClient
@EnableTransactionManagement
@SpringBootApplication
public class MythDemoAccountMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MythDemoAccountMsApplication.class, args);
	}
}
