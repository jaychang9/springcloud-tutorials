package cn.jaychang.scstudy.order.client;

import cn.jaychang.scstudy.order.config.FeignConfig;
import cn.jaychang.scstudy.order.dto.InventoryDTO;
import com.hmily.tcc.annotation.Tcc;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.order.client
 * @description 库存FeignClient
 * @create 2018-10-07 14:39
 */
@FeignClient(value = "sc-tcc-demo-inventory-ms",configuration = FeignConfig.class)
@RequestMapping("/inventory")
public interface InventoryClient {
    @Tcc
    @PutMapping("/decrease")
    Boolean decrease(@RequestBody InventoryDTO inventoryDTO);

    @GetMapping("/{productId}")
    InventoryDTO findByProductId(@PathVariable("productId") String productId);

    /**
     * 模拟try阶段出现异常
     * @param inventoryDTO
     * @return
     */
    @Tcc
    @PutMapping("/mockDecreaseTryException")
    Boolean mockDecreaseTryException(InventoryDTO inventoryDTO);


    /**
     * 模拟try阶段超时
     * @param inventoryDTO
     * @return
     */
    @Tcc
    @PutMapping("/mockDecreaseTryTimeout")
    Boolean mockDecreaseTryTimeout(InventoryDTO inventoryDTO);
}
