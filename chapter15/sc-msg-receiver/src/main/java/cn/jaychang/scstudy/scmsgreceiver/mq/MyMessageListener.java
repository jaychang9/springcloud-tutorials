package cn.jaychang.scstudy.scmsgreceiver.mq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

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
@EnableBinding({Sink.class, OrderSink.class})
public class MyMessageListener {

	@StreamListener(Sink.INPUT)
	public void input(String message) {
		System.out.println("Demo收到消息：" + message);
	}

	@StreamListener(OrderSink.INPUT_ORDER)
	public void inputOrder(OrderDTO orderDTO) {
		System.out.println("收到新建完订单的消息");
		System.out.println(orderDTO);
	}
}