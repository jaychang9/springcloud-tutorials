package cn.jaychang.scstudy.scmsgsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author zhangjie
 */
@SpringBootApplication
public class ScMsgSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScMsgSenderApplication.class, args);
	}


}
