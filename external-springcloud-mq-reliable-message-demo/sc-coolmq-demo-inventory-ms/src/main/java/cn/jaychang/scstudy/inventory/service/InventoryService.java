package cn.jaychang.scstudy.inventory.service;

import cn.jaychang.scstudy.inventory.dto.InventoryDTO;
import cn.jaychang.scstudy.inventory.entity.Inventory;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.inventory.service
 * @description 库存服务接口
 * @create 2018-10-07 13:00
 */
public interface InventoryService {
    /**
     * 扣减库存操作.
     * 这一个tcc接口
     *
     * @param inventoryDTO 库存DTO对象
     * @return true
     */
    Boolean decrease(InventoryDTO inventoryDTO);

    /**
     * 获取商品库存信息.
     * @param productId 商品id
     * @return Inventory
     */
    Inventory findByProductId(String productId);
}
