package cn.jaychang.scstudy.inventory.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.inventory.entity
 * @description 库存
 * @create 2018-10-07 12:57
 */
@TableName("t_inventory")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory implements Serializable {
    private static final long serialVersionUID = 5947496499199769225L;

    /**
     * id
     */
    private Long id;

    /**
     * 商品编号
     */
    private String productId;

    /**
     * 总库存
     */
    private Integer totalInventory;

    /**
     * 锁定库存
     */
    private Integer lockInventory;

}
