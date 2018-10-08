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
 * @description 账户DTO
 * @create 2018-10-07 10:06
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO implements Serializable{
    private static final long serialVersionUID = -3740202802087575413L;
    /**
     * 账户id
     */
    private Long id;

    /**
     * 账号
     */
    private String userId;

    /**
     * 用户余额
     */
    private BigDecimal balance;

    /**
     * 冻结金额，扣款暂存余额
     */
    private BigDecimal freezeAmount;
}
