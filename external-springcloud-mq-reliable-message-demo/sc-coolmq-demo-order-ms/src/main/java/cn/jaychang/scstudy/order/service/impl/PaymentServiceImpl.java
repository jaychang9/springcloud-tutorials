package cn.jaychang.scstudy.order.service.impl;

import cn.jaychang.scstudy.order.dto.OrderDTO;
import com.coolmq.amqp.annotation.TransMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jaychang.scstudy.order.dao.OrderMapper;
import cn.jaychang.scstudy.order.entity.Order;
import cn.jaychang.scstudy.order.enums.OrderStatusEnum;
import cn.jaychang.scstudy.order.service.PaymentService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.order.service.impl
 * @description PaymentServiceImpl(发起方，也有try,confirm,cancel)
 * @create 2018-10-07 15:59
 */
@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private OrderMapper orderMapper;

	@TransMessage(exchange = "exchange.transmsg", bindingKey = "key.transmsg", bizName = "order_pay_success", dbCoordinator = "DBRedisCoordinator")
	@Transactional(rollbackFor = Exception.class)
	@Override
	public OrderDTO makePayment(Order order) {
		// 只是demo而已
		// 订单状态修改
		order.setStatus(OrderStatusEnum.PAY_SUCCESS.getCode());
		orderMapper.updateById(order);

		OrderDTO orderDTO = OrderDTO.builder().id(order.getId()).number(order.getNumber())
				.productId(order.getProductId()).userId(order.getUserId()).quantity(order.getQuantity())
				.totalAmount(order.getTotalAmount()).build();
		// orderDTO返回值在解析@TransMessage注解的切面逻辑里，会作为消息体发送到@TransMessage注解指定的交换机绑定的队列内
        return orderDTO;
	}

}
