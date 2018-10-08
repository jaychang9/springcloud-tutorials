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
import com.hmily.tcc.annotation.Tcc;
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

    @Tcc(confirmMethod = "confirmOrderStatus",cancelMethod = "cancelOrderStatus")
    @Override
    public void makePayment(Order order) {
        // 订单状态修改
        order.setStatus(OrderStatusEnum.PAYING.getCode());
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

    @Tcc(confirmMethod = "confirmOrderStatus",cancelMethod = "cancelOrderStatus")
    @Override
    public void mockPaymentInventoryWithTryException(Order order) {
        // 订单状态修改
        order.setStatus(OrderStatusEnum.PAYING.getCode());
        orderMapper.updateById(order);
        // 扣减账户余额
        AccountPaymentDTO accountPaymentDTO = AccountPaymentDTO.builder()
                .userId(order.getUserId()).amount(order.getTotalAmount()).build();
        accountClient.payment(accountPaymentDTO);
        // 扣减商品库存
        InventoryDTO inventoryDTO = InventoryDTO.builder().productId(order.getProductId())
                .quantity(order.getQuantity()).build();
        inventoryClient.mockDecreaseTryException(inventoryDTO);
    }

    @Tcc(confirmMethod = "confirmOrderStatus",cancelMethod = "cancelOrderStatus")
    @Override
    public void mockPaymentInventoryWithTryTimeout(Order order) {
        // 订单状态修改
        order.setStatus(OrderStatusEnum.PAYING.getCode());
        orderMapper.updateById(order);
        // 扣减账户余额
        AccountPaymentDTO accountPaymentDTO = AccountPaymentDTO.builder()
                .userId(order.getUserId()).amount(order.getTotalAmount()).build();
        accountClient.payment(accountPaymentDTO);
        // 扣减商品库存
        InventoryDTO inventoryDTO = InventoryDTO.builder().productId(order.getProductId())
                .quantity(order.getQuantity()).build();
        inventoryClient.mockDecreaseTryTimeout(inventoryDTO);
    }

    /**
     * 订单状态确认
     * @param order
     */
    public void confirmOrderStatus(Order order){
        order.setStatus(OrderStatusEnum.PAY_SUCCESS.getCode());
        orderMapper.updateById(order);
        log.info("=========进行订单confirm操作完成================");
    }

    /**
     * 订单状态取消
     * @param order
     */
    public void cancelOrderStatus(Order order){
        order.setStatus(OrderStatusEnum.PAY_FAIL.getCode());
        orderMapper.updateById(order);
        log.info("=========进行订单cancel操作完成================");
    }
}
