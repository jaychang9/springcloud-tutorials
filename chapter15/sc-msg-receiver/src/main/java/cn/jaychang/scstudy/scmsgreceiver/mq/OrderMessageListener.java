package cn.jaychang.scstudy.scmsgreceiver.mq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import cn.jaychang.scstudy.scmsgreceiver.model.dto.OrderDTO;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.Date;

/**
 *
 * <p>
 *  TODO 类作用描述
 * </p>
 *
 * @author zhangjie
 * @since 2018-11-01
 */
@EnableBinding(OrderSink.class)
public class OrderMessageListener {
	@StreamListener(value = OrderSink.INPUT_ORDER)
    @SendTo(Source.OUTPUT)
	public String inputOrder(OrderDTO orderDTO) {
		System.out.println("收到新建完订单的消息: " + orderDTO);
		return "创建消息成功："+new Date();
	}
}