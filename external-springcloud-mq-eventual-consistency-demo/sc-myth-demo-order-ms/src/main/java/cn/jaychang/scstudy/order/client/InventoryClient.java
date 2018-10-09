package cn.jaychang.scstudy.order.client;

import cn.jaychang.scstudy.inventory.service.InventoryService;
import cn.jaychang.scstudy.order.config.FeignConfig;
import cn.jaychang.scstudy.order.dto.InventoryDTO;
import com.github.myth.annotation.MessageTypeEnum;
import com.github.myth.annotation.Myth;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.order.client
 * @description 库存FeignClient
 * @create 2018-10-07 14:39
 */
@FeignClient(value = "sc-myth-demo-inventory-ms",configuration = FeignConfig.class)
@RequestMapping("/inventory")
public interface InventoryClient {
    @Myth(destination = "inventory",target = InventoryService.class,pattern = MessageTypeEnum.TOPIC)
    @PutMapping("/decrease")
    Boolean decrease(@RequestBody InventoryDTO inventoryDTO);

    @GetMapping("/{productId}")
    InventoryDTO findByProductId(@PathVariable("productId") String productId);
}
