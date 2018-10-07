package cn.jaychang.scstudy.order.client;

import cn.jaychang.scstudy.order.config.FeignConfig;
import cn.jaychang.scstudy.order.dto.AccountDTO;
import cn.jaychang.scstudy.order.dto.AccountPaymentDTO;
import com.hmily.tcc.annotation.Tcc;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.order.client
 * @description 账户FeignClient
 * @create 2018-10-07 14:39
 */
@FeignClient(value = "sc-tcc-demo-account-ms", configuration = FeignConfig.class)
@RequestMapping("/account")
public interface AccountClient {
    @Tcc
    @PostMapping("/payment")
    Boolean payment(@RequestBody AccountPaymentDTO accountPaymentDTO);


    @GetMapping("/{userId}")
    AccountDTO findByUserId(@PathVariable("userId") String userId);
}
