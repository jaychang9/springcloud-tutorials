package cn.jaychang.scstudy.scmsgreceiver.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * <p>
 *  TODO 类作用描述
 * </p>
 *
 * @author zhangjie
 * @since 2018-11-01
 */
public class OrderDTO implements Serializable{
    private String sn;

    private String productName;

    private int quantity;

    private BigDecimal price;

    private Date createDate;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "sn='" + sn + '\'' + ", productName='" + productName + '\'' + ", quantity=" + quantity
                + ", price=" + price + ", createDate=" + createDate + '}';
    }
}
