package cn.jaychang.scstudy.inventory.controller;

import cn.jaychang.scstudy.inventory.dto.InventoryDTO;
import cn.jaychang.scstudy.inventory.entity.Inventory;
import cn.jaychang.scstudy.inventory.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.inventory.controller
 * @description 库存控制器
 * @create 2018-10-07 13:05
 */
@Slf4j
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PutMapping("/decrease")
    public Boolean decrease(@RequestBody InventoryDTO inventoryDTO){
        log.debug("=============进入InventoryController的decrease===================={}",inventoryDTO);
        return inventoryService.decrease(inventoryDTO);
    }


    @GetMapping("/{productId}")
    public InventoryDTO findByProductId(@PathVariable("productId") String productId){
        Inventory inventory = inventoryService.findByProductId(productId);
        if(Objects.isNull(inventory)){
            return null;
        }
        InventoryDTO inventoryDTO = new InventoryDTO();
        BeanUtils.copyProperties(inventory,inventoryDTO);
        return inventoryDTO;
    }

}
