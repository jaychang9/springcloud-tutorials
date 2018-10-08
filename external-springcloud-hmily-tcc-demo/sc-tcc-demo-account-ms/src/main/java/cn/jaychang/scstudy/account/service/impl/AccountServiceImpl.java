package cn.jaychang.scstudy.account.service.impl;

import cn.jaychang.scstudy.account.dao.AccountMapper;
import cn.jaychang.scstudy.account.dto.AccountPaymentDTO;
import cn.jaychang.scstudy.account.entity.Account;
import cn.jaychang.scstudy.account.service.AccountService;
import com.baomidou.mybatisplus.core.conditions.Condition;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hmily.tcc.annotation.Tcc;
import com.hmily.tcc.common.exception.TccRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.order.service.impl
 * @description 账户服务实现类
 * @create 2018-10-07 09:54
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Tcc(confirmMethod = "confirmPayment",cancelMethod = "cancelPayment")
    @Transactional
    @Override
    public boolean payment(AccountPaymentDTO accountPaymentDTO) {
        Account account = accountMapper.selectOne(Condition.<Account>create().eq("user_id", accountPaymentDTO.getUserId()));
        if(account.getBalance().compareTo(accountPaymentDTO.getAmount()) < 0){
            throw new TccRuntimeException("余额不足");
        }
        // 冻结扣款金额
        account.setFreezeAmount(account.getFreezeAmount().add(accountPaymentDTO.getAmount()));
        // 账户余额减少
        account.setBalance(account.getBalance().subtract(accountPaymentDTO.getAmount()));
        account.setUpdateTime(new Date());

        final int update = accountMapper.updateById(account);
        return update >= 1;
    }

    @Override
    public Account findByUserId(String userId) {
        QueryWrapper<Account> queryWrapper = Condition.<Account>create().eq("user_id", userId);
        return accountMapper.selectOne(queryWrapper);
    }

    /**
     * tcc支付确认(必须是public的)
     */
    @SuppressWarnings("unused")
    public boolean confirmPayment(AccountPaymentDTO accountPaymentDTO){
        Account account = accountMapper.selectOne(Condition.<Account>create().eq("user_id", accountPaymentDTO.getUserId()));
        // 扣除冻结的金额
        account.setFreezeAmount(account.getFreezeAmount().subtract(accountPaymentDTO.getAmount()));
        account.setUpdateTime(new Date());
        int update = accountMapper.updateById(account);
        return update >= 1;
    }

    /**
     * tcc支付取消(必须是public的)
     * 否则会报以下错误<p>java.lang.NoSuchMethodException: No such accessible method: paymentCancel() on object: cn.jaychang.scstudy.order.service.impl.AccountServiceImpl$$EnhancerBySpringCGLIB$$bf262ab9
     * </p>
     */
    @SuppressWarnings("unused")
    public boolean cancelPayment(AccountPaymentDTO accountPaymentDTO){
        // 将冻结的金额返还到账户余额
        Account account = accountMapper.selectOne(Condition.<Account>create().eq("user_id", accountPaymentDTO.getUserId()));
        account.setFreezeAmount(account.getFreezeAmount().subtract(accountPaymentDTO.getAmount()));
        account.setBalance(account.getBalance().add(accountPaymentDTO.getAmount()));
        account.setUpdateTime(new Date());
        int update = accountMapper.updateById(account);
        return update >= 1;
    }
}
