package cn.jaychang.scstudy.order.service.impl;

import cn.jaychang.scstudy.order.dao.OrderMapper;
import cn.jaychang.scstudy.order.entity.Order;
import cn.jaychang.scstudy.order.enums.OrderStatusEnum;
import cn.jaychang.scstudy.order.service.OrderService;
import cn.jaychang.scstudy.order.service.PaymentService;
import com.hmily.tcc.common.utils.IdWorkerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.order.service.impl
 * @description 订单服务实现类
 * @create 2018-10-07 14:36
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private PaymentService paymentService;

    @Override
    public String orderPay(Integer quantity, BigDecimal amount) {
        final Order order = buildOrder(quantity, amount);
        final int rows = orderMapper.insert(order);

        if (rows > 0) {
            paymentService.makePayment(order);
        }
        return "success";
    }

    /**
     * 模拟在订单支付操作中，库存在try阶段中的库存异常
     *
     * @param quantity  购买数量
     * @param amount 支付金额
     * @return string
     */
    @Override
    public String mockInventoryWithTryException(Integer quantity, BigDecimal amount) {
        final Order order = buildOrder(quantity, amount);
        final int rows = orderMapper.insert(order);

        if (rows > 0) {
            paymentService.mockPaymentInventoryWithTryException(order);
        }


        return "success";
    }

    /**
     * 模拟在订单支付操作中，库存在try阶段中的timeout
     *
     * @param quantity  购买数量
     * @param amount 支付金额
     * @return string
     */
    @Override
    public String mockInventoryWithTryTimeout(Integer quantity, BigDecimal amount) {
        final Order order = buildOrder(quantity, amount);
        final int rows = orderMapper.insert(order);

        if (rows > 0) {
            paymentService.mockPaymentInventoryWithTryTimeout(order);
        }


        return "success";
    }


    @Override
    public void updateOrderStatus(Order order) {
        orderMapper.updateById(order);
    }

    private Order buildOrder(Integer quantity, BigDecimal amount) {
        log.debug("构建订单对象");
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setNumber(IdWorkerUtils.getInstance().buildPartNumber());
        //demo中的表里只有商品id为 10000的数据
        order.setProductId("10000");
        order.setStatus(OrderStatusEnum.NOT_PAY.getCode());
        order.setTotalAmount(amount);
        order.setQuantity(quantity);
        //demo中 表里面存的用户id为10000
        order.setUserId("10000");
        return order;
    }
}
