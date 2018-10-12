package cn.jaychang.scstudy.order.service;

import cn.jaychang.scstudy.order.dto.OrderDTO;
import cn.jaychang.scstudy.order.entity.Order;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.order.service
 * @description PaymentService
 * @create 2018-10-07 15:58
 */
public interface PaymentService {
    /**
     * 订单支付.
     *
     * @param order 订单实体
     * @return OrderDTO (会作为消息体发送到mq server)
     */
    OrderDTO makePayment(Order order);
}
