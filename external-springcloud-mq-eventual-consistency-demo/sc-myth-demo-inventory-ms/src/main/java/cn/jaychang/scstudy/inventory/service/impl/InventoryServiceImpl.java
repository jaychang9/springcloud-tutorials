package cn.jaychang.scstudy.inventory.service.impl;

import cn.jaychang.scstudy.inventory.dao.InventoryMapper;
import cn.jaychang.scstudy.inventory.dto.InventoryDTO;
import cn.jaychang.scstudy.inventory.entity.Inventory;
import cn.jaychang.scstudy.inventory.service.InventoryService;
import com.baomidou.mybatisplus.core.conditions.Condition;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hmily.tcc.annotation.Tcc;
import com.hmily.tcc.common.exception.TccRuntimeException;
import lombok.extern.slf4j.Slf4j;
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
    @Tcc(confirmMethod = "confirmDecrease",cancelMethod = "cancelDecrease")
    @Transactional
    @Override
    public Boolean decrease(InventoryDTO inventoryDTO) {
        log.debug("==============进入到inventory扣减库存=============={}",inventoryDTO);
        QueryWrapper<Inventory> queryWrapper = Condition.<Inventory>create().eq("product_id", inventoryDTO.getProductId());
        Inventory inventory = inventoryMapper.selectOne(queryWrapper);
        if(inventory.getTotalInventory().compareTo(inventoryDTO.getQuantity()) < 0){
            throw new TccRuntimeException("库存不足");
        }
        inventory.setTotalInventory(inventory.getTotalInventory()-inventoryDTO.getQuantity());
        inventory.setLockInventory(inventory.getLockInventory()+inventoryDTO.getQuantity());
        final int update = inventoryMapper.updateById(inventory);
        return update >= 1;
    }

    /**
     * <p>tcc扣减库存确认</p>
     *
     * @param inventoryDTO 库存DTO
     * @return Boolean
     */
    public Boolean confirmDecrease(InventoryDTO inventoryDTO){
        log.debug("调用扣减库存tcc确认方法");
        QueryWrapper<Inventory> queryWrapper = Condition.<Inventory>create().eq("product_id", inventoryDTO.getProductId());
        Inventory inventory = inventoryMapper.selectOne(queryWrapper);
        inventory.setLockInventory(inventory.getLockInventory()-inventoryDTO.getQuantity());
        final int update = inventoryMapper.updateById(inventory);
        return update >= 1;
    }

    /**
     * <p>tcc扣减库存取消</p>
     *
     * @param inventoryDTO 库存DTO
     * @return Boolean
     */
    public Boolean cancelDecrease(InventoryDTO inventoryDTO){
        log.debug("==========Springcloud调用扣减库存tcc取消方法===========");
        QueryWrapper<Inventory> queryWrapper = Condition.<Inventory>create().eq("product_id", inventoryDTO.getProductId());
        Inventory inventory = inventoryMapper.selectOne(queryWrapper);
        inventory.setTotalInventory(inventory.getTotalInventory()+inventoryDTO.getQuantity());
        inventory.setLockInventory(inventory.getLockInventory()-inventoryDTO.getQuantity());
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

    /**
     * <p>模拟try阶段异常</p>
     *
     * @param inventoryDTO dto
     * @return Boolean
     */
    @Tcc(confirmMethod = "confirmDecrease",cancelMethod = "cancelDecrease")
    @Transactional
    @Override
    public Boolean mockWithTryException(InventoryDTO inventoryDTO) {
        log.info("==========Springcloud调用扣减库存mockWithTryException===========");
        //这里是模拟异常所以就直接抛出异常了
        throw new TccRuntimeException("库存扣减异常！");
    }

    /**
     * <p>模拟try阶段超时</p>
     *
     * @param inventoryDTO dto
     * @return Boolean
     */
    @Tcc(confirmMethod = "confirmDecrease",cancelMethod = "cancelDecrease")
    @Transactional
    @Override
    public Boolean mockWithTryTimeout(InventoryDTO inventoryDTO) {
        try {
            //模拟延迟 当前线程暂停10秒
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("==========Springcloud调用扣减库存mockWithTryTimeout===========");
        QueryWrapper<Inventory> queryWrapper = Condition.<Inventory>create().eq("product_id", inventoryDTO.getProductId());
        final Inventory inventory = inventoryMapper.selectOne(queryWrapper);
        if(inventory.getTotalInventory().compareTo(inventoryDTO.getQuantity()) < 0){
            throw new TccRuntimeException("库存不足");
        }
        inventory.setTotalInventory(inventory.getTotalInventory() - inventoryDTO.getQuantity());
        inventory.setLockInventory(inventory.getLockInventory() + inventoryDTO.getQuantity());
        final int update = inventoryMapper.updateById(inventory);
        return update >= 1;
    }


    /**
     * 确认方法超时
     * @param inventoryDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean confirmDecreaseTimeout(InventoryDTO inventoryDTO) {
        try {
            //模拟延迟 当前线程暂停11秒
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("==========Springcloud调用扣减库存确认方法===========");
        QueryWrapper<Inventory> queryWrapper = Condition.<Inventory>create().eq("product_id", inventoryDTO.getProductId());
        final Inventory inventory = inventoryMapper.selectOne(queryWrapper);
        inventory.setLockInventory(inventory.getLockInventory() - inventoryDTO.getQuantity());
        final int update = inventoryMapper.updateById(inventory);
        return update >= 1;
    }

    /**
     * 确认方法发生异常
     * @param inventoryDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean confirmDecreaseException(InventoryDTO inventoryDTO) {
        log.info("==========Springcloud调用扣减库存确认方法===========");

        throw new TccRuntimeException("库存扣减确认异常！");
    }
}
