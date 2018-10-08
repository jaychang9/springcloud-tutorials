package cn.jaychang.scstudy.inventory.service;

import cn.jaychang.scstudy.inventory.dto.InventoryDTO;
import cn.jaychang.scstudy.inventory.entity.Inventory;
import com.hmily.tcc.annotation.Tcc;

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
    @Tcc
    Boolean decrease(InventoryDTO inventoryDTO);

    /**
     * 获取商品库存信息.
     * @param productId 商品id
     * @return Inventory
     */
    Inventory findByProductId(String productId);

    /**
     * mock 库存扣减try阶段异常.
     *
     * @param inventoryDTO dto
     * @return true
     */
    @Tcc
    Boolean mockWithTryException(InventoryDTO inventoryDTO);

    /**
     * mock 库存扣减try阶段超时.
     *
     * @param inventoryDTO dto
     * @return true
     */
    @Tcc
    Boolean mockWithTryTimeout(InventoryDTO inventoryDTO);

}
