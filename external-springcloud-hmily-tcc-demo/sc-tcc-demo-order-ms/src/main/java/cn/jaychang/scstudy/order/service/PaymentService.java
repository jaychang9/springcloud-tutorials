package cn.jaychang.scstudy.order.service;

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
     */
    void makePayment(Order order);

    /**
     * mock订单支付的时候库存异常.
     *
     * @param order 订单实体
     */
    void mockPaymentInventoryWithTryException(Order order);

    /**
     * mock订单支付的时候库存超时.
     *
     * @param order 订单实体
     */
    void mockPaymentInventoryWithTryTimeout(Order order);
}
