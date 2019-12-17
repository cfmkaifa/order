package org.forbes.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Table: f_order_item
 */
@Data
@ApiModel(description="订单项目信息")
@EqualsAndHashCode(callSuper = false)
@TableName("f_order_item")
public class OrderItem extends BaseEntity {

    private static final long serialVersionUID = -7939944594947152239L;
    /**
     * 主键
     * Table:     f_order_item
     * Column:    id
     * Nullable:  false
     */
    private Long id;

    /**
     * Table:     f_order_item
     * Column:    create_by
     * Nullable:  true
     */
    private String createBy;

    /**
     * 创建时间
     * Table:     f_order_item
     * Column:    create_time
     * Nullable:  true
     */
    private Date createTime;

    /**
     * 更新人
     * Table:     f_order_item
     * Column:    update_by
     * Nullable:  true
     */
    private String updateBy;

    /**
     * 更新时间
     * Table:     f_order_item
     * Column:    update_time
     * Nullable:  true
     */
    private Date updateTime;

    /**
     * 订单ID
     * Table:     f_order_item
     * Column:    order_id
     * Nullable:  true
     */
    private Long orderId;

    /**
     * 规格ID
     * Table:     f_order_item
     * Column:    spec_id
     * Nullable:  true
     */
    private Long specId;

    /**
     * 商品ID
     * Table:     f_order_item
     * Column:    pro_id
     * Nullable:  true
     */
    private Long proId;

    /**
     * 商品编码
     * Table:     f_order_item
     * Column:    sn
     * Nullable:  true
     */
    private String sn;

    /**
     * 商品名称
     * Table:     f_order_item
     * Column:    name
     * Nullable:  true
     */
    private String name;

    /**
     * 单价
     * Table:     f_order_item
     * Column:    price
     * Nullable:  true
     */
    private BigDecimal price;

    /**
     * 数量
     * Table:     f_order_item
     * Column:    quantity
     * Nullable:  true
     */
    private Integer quantity;

    /**
     * 退货数量
     * Table:     f_order_item
     * Column:    returned_quantity
     * Nullable:  true
     */
    private Integer returnedQuantity;

    /**
     * 发货数量
     * Table:     f_order_item
     * Column:    shipped_quantity
     * Nullable:  true
     */
    private Integer shippedQuantity;

    /**
     * 规格值
     * Table:     f_order_item
     * Column:    specifications
     * Nullable:  true
     */
    private String specifications;
}