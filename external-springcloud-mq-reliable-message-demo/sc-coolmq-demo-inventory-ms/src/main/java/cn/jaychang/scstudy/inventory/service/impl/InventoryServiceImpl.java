package cn.jaychang.scstudy.inventory.service.impl;

import cn.jaychang.scstudy.inventory.dao.InventoryMapper;
import cn.jaychang.scstudy.inventory.dto.InventoryDTO;
import cn.jaychang.scstudy.inventory.entity.Inventory;
import cn.jaychang.scstudy.inventory.service.InventoryService;
import com.baomidou.mybatisplus.core.conditions.Condition;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 库存服务实现类
 *
 * @author zhangjie
 * @date 2018-10-07
 */
@Slf4j
@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;


    /**
     * <p>扣减库存</p>
     *
     * <b>confirmDecrease为TCC的确认方法 cancelDecrease为TCC的取消方法</b>
     *
     * @param inventoryDTO 库存DTO对象
     *
     * @return Boolean
     */
    @Transactional
    @Override
    public Boolean decrease(InventoryDTO inventoryDTO) {
        log.debug("==============进入到inventory扣减库存=============={}",inventoryDTO);
        QueryWrapper<Inventory> queryWrapper = Condition.<Inventory>create().eq("product_id", inventoryDTO.getProductId());
        Inventory inventory = inventoryMapper.selectOne(queryWrapper);
        if(RandomUtils.nextBoolean()){
            throw new RuntimeException("随机异常，测试");
        }
        if(inventory.getTotalInventory().compareTo(inventoryDTO.getQuantity()) < 0){
            throw new RuntimeException("库存不足");
        }
        inventory.setTotalInventory(inventory.getTotalInventory()-inventoryDTO.getQuantity());
        final int update = inventoryMapper.updateById(inventory);
        return update >= 1;
    }

    /**
     * <p>查询某个商品编号的库存数量</p>
     * @param productId 商品id
     * @return Inventory
     */
    @Override
    public Inventory findByProductId(String productId) {
        QueryWrapper<Inventory> queryWrapper = Condition.<Inventory>create().eq("product_id", productId);
        Inventory inventory = inventoryMapper.selectOne(queryWrapper);
        return inventory;
    }
}
