package cn.jaychang.scstudy.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.order.entity
 * @description 订单
 * @create 2018-10-07 09:47
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO implements Serializable{


    private static final long serialVersionUID = 101259627485895213L;
    /**
     * 订单id
     */
    private Long id;

    /**
     * 订单编号
     */
    private String number;

    /**
     * 商品编号
     */
    private String productId;

    /**
     * 账号
     */
    private String userId;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 商品总数量
     */
    private Integer quantity;

    /**
     * 总价
     */
    private BigDecimal totalAmount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后更新时间
     */
    private Date updateTime;
}
