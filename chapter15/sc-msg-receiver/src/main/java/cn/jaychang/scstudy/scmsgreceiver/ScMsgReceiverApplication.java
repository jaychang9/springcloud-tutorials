package cn.jaychang.scstudy.scmsgreceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * @author zhangjie
 */
//@Import(cn.jaychang.scstudy.scmsgreceiver.mq.DemoMessageListener.class)
@SpringBootApplication
public class ScMsgReceiverApplication {
	public static void main(String[] args) {
		SpringApplication.run(ScMsgReceiverApplication.class, args);
	}

}
