package cn.jaychang.scstudy.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhangjie
 */
@ComponentScan(basePackages = {"com.coolmq.amqp"})
@MapperScan("cn.jaychang.scstudy.order.dao")
@EnableTransactionManagement
@SpringBootApplication
public class ReliableMessageDemoOrderMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReliableMessageDemoOrderMsApplication.class, args);
	}
}
