package cn.jaychang.scstudy.order.service;

import cn.jaychang.scstudy.order.entity.Order;

import java.math.BigDecimal;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.order.service
 * @description 订单服务
 * @create 2018-10-07 09:53
 */
public interface OrderService {

    /**
     * 创建订单并且进行扣除账户余额支付，并进行库存扣减操作.
     *
     * @param quantity  购买数量
     * @param amount 支付金额
     * @return string
     */
    String orderPay(Integer quantity, BigDecimal amount);

    /**
     * 更新订单状态.
     *
     * @param order 订单实体类
     */
    void updateOrderStatus(Order order);
}
