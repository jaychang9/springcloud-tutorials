package cn.jaychang.scstudy.account.service;

import cn.jaychang.scstudy.account.dto.AccountPaymentDTO;
import cn.jaychang.scstudy.account.entity.Account;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.account.service
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
