package cn.jaychang.scstudy.order.controller;

import cn.jaychang.scstudy.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.order.controller
 * @description 订单控制器
 * @create 2018-10-07 14:35
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单", description = "订单接口")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/orderPay")
    @ApiOperation(value = "订单支付接口（注意这里模拟的是创建订单并进行支付扣减库存等操作）")
    @ApiImplicitParams({@ApiImplicitParam(name = "quantity", value = "数量", dataTypeClass = Integer.class, paramType = "query", required = true, defaultValue = "1"),
            @ApiImplicitParam(name = "amount", value = "金额", dataTypeClass = BigDecimal.class, paramType = "query", required = true)})
    public String orderPay(@RequestParam(value = "quantity") Integer quantity,
                           @RequestParam(value = "amount") BigDecimal amount) {
        return orderService.orderPay(quantity, amount);

    }
}
