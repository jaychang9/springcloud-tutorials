package cn.jaychang.scstudy.scmsgsender.controller;

import cn.jaychang.scstudy.scmsgsender.model.dto.OrderDTO;
import cn.jaychang.scstudy.scmsgsender.mq.OrderSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 *
 * <p>
 *  TODO 类作用描述
 * </p>
 *
 * @author zhangjie
 * @since 2018-11-01
 */
@SuppressWarnings("AlibabaRemoveCommentedCode")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderSource orderSource;

//    @Autowired
//    @Qualifier(OrderSource.OUTPUT_ORDER)
//    private MessageChannel orderMessageChannel;

    @GetMapping("/create")
    public String createOrder(){
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setPrice(BigDecimal.valueOf(new Random().nextDouble()));

        orderDTO.setCreateDate(new Date());

        orderDTO.setQuantity(new Random().nextInt(10));

        orderDTO.setSn(String.valueOf(System.currentTimeMillis()));

        orderDTO.setProductName("商品名称"+System.currentTimeMillis());

        boolean send = orderSource.outputOrder().send(MessageBuilder.withPayload(orderDTO).build());

        String result  = send ? "发送成功":"发送失败";
        System.out.println(result);
        return result;
    }

}
