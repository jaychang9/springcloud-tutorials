package cn.jaychang.scstudy.scmsgreceiver.mq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import cn.jaychang.scstudy.scmsgreceiver.model.dto.OrderDTO;

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
	@StreamListener(OrderSink.INPUT_ORDER)
	public void inputOrder(OrderDTO orderDTO) {
		System.out.println("收到新建完订单的消息: " + orderDTO);
	}
}