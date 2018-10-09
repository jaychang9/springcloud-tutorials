package cn.jaychang.scstudy.order.service.impl;

import cn.jaychang.scstudy.order.client.AccountClient;
import cn.jaychang.scstudy.order.client.InventoryClient;
import cn.jaychang.scstudy.order.dao.OrderMapper;
import cn.jaychang.scstudy.order.dto.AccountDTO;
import cn.jaychang.scstudy.order.dto.AccountPaymentDTO;
import cn.jaychang.scstudy.order.dto.InventoryDTO;
import cn.jaychang.scstudy.order.entity.Order;
import cn.jaychang.scstudy.order.enums.OrderStatusEnum;
import cn.jaychang.scstudy.order.service.PaymentService;
import com.github.myth.annotation.Myth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private InventoryClient inventoryClient;

    @Myth(destination = "")
    @Transactional
    @Override
    public void makePayment(Order order) {
        // 只是demo而已
        // 订单状态修改
        order.setStatus(OrderStatusEnum.PAY_SUCCESS.getCode());
        orderMapper.updateById(order);
        // 扣减账户余额
        AccountPaymentDTO accountPaymentDTO = AccountPaymentDTO.builder()
                .userId(order.getUserId()).amount(order.getTotalAmount()).build();
        accountClient.payment(accountPaymentDTO);
        // 扣减商品库存
        InventoryDTO inventoryDTO = InventoryDTO.builder().productId(order.getProductId())
                .quantity(order.getQuantity()).build();
        inventoryClient.decrease(inventoryDTO);
    }

}
