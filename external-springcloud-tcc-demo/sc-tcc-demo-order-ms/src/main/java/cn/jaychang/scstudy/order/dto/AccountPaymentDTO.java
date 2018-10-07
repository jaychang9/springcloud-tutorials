package cn.jaychang.scstudy.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.order.dto
 * @description 账户扣款DTO
 * @create 2018-10-07 10:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountPaymentDTO implements Serializable{
    private static final long serialVersionUID = 7415972711464324819L;

    /**
     * 账号
     */
    private String userId;

    /**
     * 扣款金额
     */
    private BigDecimal amount;
}
