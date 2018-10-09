package cn.jaychang.scstudy.account.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.account.entity
 * @description 账户
 * @create 2018-10-07 09:47
 */
@TableName("t_account")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable{
    private static final long serialVersionUID = -6537408005535999301L;

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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后更新时间
     */
    private Date updateTime;
}
