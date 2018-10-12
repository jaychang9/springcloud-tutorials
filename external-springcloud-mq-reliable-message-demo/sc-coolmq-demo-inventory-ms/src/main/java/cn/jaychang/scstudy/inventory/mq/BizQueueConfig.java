package cn.jaychang.scstudy.inventory.mq;//package com.coolmq.amqp.config;

import com.coolmq.amqp.listener.AbstractMessageListener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * <p><b>Description:</b> RabbitMQ交换机、队列的配置类.定义交换机、key、queue并做好绑定。
 * <p><b>Company:</b>
 *
 * @author created by fw at 21:54 on 2017-12-23
 * @version V0.1
 */
@Configuration
public class BizQueueConfig {


	// ========================== 声明交换机 ==========================
	/**
	 * 交换机
	 */
	@Bean
	public DirectExchange transExchange() {
		return new DirectExchange("exchange.transmsg");
	}


	// ========================== 声明队列 ===========================
	/**
	 * 死信队列
	 */
	@Bean
	public Queue transQueue() {
		return new Queue("queue.transmsg", true, false, false);
	}

	/**
	 * 通过死信路由key绑定死信交换机和死信队列
	 */
	@Bean
	public Binding transBinding() {
		return BindingBuilder.bind(transQueue()).to(transExchange()).with("key.transmsg");
	}

	/**
	 * 死信队列的监听
	 * @param connectionFactory RabbitMQ连接工厂
	 * @param transMessageListener  队列监听器
	 * @return 监听容器对象
	 */
	@Bean
	public SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory,
			AbstractMessageListener transMessageListener) {

		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
		container.setQueues(transQueue());
		container.setExposeListenerChannel(true);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		container.setMessageListener(transMessageListener);
		return container;
	}

	// ====================== 一个例子，用来说明如何声明队列与交换机绑定 =======================

}
