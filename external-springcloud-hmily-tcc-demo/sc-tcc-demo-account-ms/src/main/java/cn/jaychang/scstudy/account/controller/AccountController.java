package cn.jaychang.scstudy.account.controller;

import cn.jaychang.scstudy.account.dto.AccountDTO;
import cn.jaychang.scstudy.account.dto.AccountPaymentDTO;
import cn.jaychang.scstudy.account.entity.Account;
import cn.jaychang.scstudy.account.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.account.controller
 * @description 账户RestController
 * @create 2018-10-07 09:53
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/payment")
    public Boolean payment(@RequestBody AccountPaymentDTO accountPaymentDTO){
        return accountService.payment(accountPaymentDTO);
    }


    @GetMapping("/{userId}")
    public AccountDTO findByUserId(@PathVariable("userId") String userId){
        Account account = accountService.findByUserId(userId);
        if(Objects.isNull(account)){
            return null;
        }
        AccountDTO accountDTO = new AccountDTO();
        BeanUtils.copyProperties(account,accountDTO);
        return accountDTO;
    }
}
