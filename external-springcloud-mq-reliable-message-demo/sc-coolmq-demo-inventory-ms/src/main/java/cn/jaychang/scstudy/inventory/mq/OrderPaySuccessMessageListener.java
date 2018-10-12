package cn.jaychang.scstudy.inventory.mq;

import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

import com.coolmq.amqp.listener.AbstractMessageListener;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.account.mq
 * @description 订单支付成功消息监听器
 * @create 2018-10-11 09:47
 */
@Slf4j
@Component
public class OrderPaySuccessMessageListener extends AbstractMessageListener {
	@Override
	public void receiveMessage(Message message) {
		log.debug("Iventory收到订单中心传过来的订单支付成功的消息,properties:{},messageBody:{}", message.getMessageProperties(),
				new String(message.getBody()));
	}
}
