package cn.jaychang.scstudy.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhangjie
 * @package cn.jaychang.scstudy.inventory.dto
 * @description 库存DTO
 * @create 2018-10-07 13:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTO implements Serializable {
    private static final long serialVersionUID = -6557940697277305874L;

    /**
     * 商品编号
     */
    private String productId;

    /**
     * 库存数量
     */
    private Integer quantity;
}
