package cn.jaychang.scstudy.account.service.impl;

import cn.jaychang.scstudy.account.dao.AccountMapper;
import cn.jaychang.scstudy.account.dto.AccountPaymentDTO;
import cn.jaychang.scstudy.account.entity.Account;
import cn.jaychang.scstudy.account.service.AccountService;
import com.baomidou.mybatisplus.core.conditions.Condition;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.account.service.impl
 * @description 账户服务实现类
 * @create 2018-10-07 09:54
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean payment(AccountPaymentDTO accountPaymentDTO) {
        Account account = accountMapper.selectOne(Condition.<Account>create().eq("user_id", accountPaymentDTO.getUserId()));
        if(account.getBalance().compareTo(accountPaymentDTO.getAmount()) < 0){
            throw new RuntimeException("余额不足");
        }
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
}