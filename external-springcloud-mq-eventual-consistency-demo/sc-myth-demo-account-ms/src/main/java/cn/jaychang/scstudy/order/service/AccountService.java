package cn.jaychang.scstudy.order.service;

import cn.jaychang.scstudy.order.dto.AccountPaymentDTO;
import cn.jaychang.scstudy.order.entity.Account;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.order.service
 * @description 账户服务
 * @create 2018-10-07 09:53
 */
public interface AccountService {
    /**
     * <P>扣款支付.</P>
     *
     * @param accountPaymentDTO 账户扣款dto
     * @return boolean
     */
    boolean payment(AccountPaymentDTO accountPaymentDTO);

    /**
     * <P>获取用户账户信息.</P>
     *
     * @param userId 账号
     * @return Account
     */
    Account findByUserId(String userId);
}
