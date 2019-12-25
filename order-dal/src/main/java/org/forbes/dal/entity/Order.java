package org.forbes.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Table: f_order
 */
@Data
@ApiModel(description="订单信息")
@EqualsAndHashCode(callSuper = false)
@TableName("f_order")
public class Order extends BaseEntity {

    private static final long serialVersionUID = 4471537549913649217L;

    /**
     * 总金额
     * Table:     f_order
     * Column:    amount
     * Nullable:  true
     */
    private BigDecimal amount;

    /**
     * 支付金额
     * Table:     f_order
     * Column:    pay_amount
     * Nullable:  true
     */
    private BigDecimal payAmount;

    /**
     * Table:     f_order
     * Column:    expire
     * Nullable:  true
     */
    private Date expire;

    /**
     * 折扣金额
     * Table:     f_order
     * Column:    coupon_discount
     * Nullable:  true
     */
    private Long couponDiscount;

    /**
     * 发票内容
     * Table:     f_order
     * Column:    invoice_content
     * Nullable:  true
     */
    private String invoiceContent;

    /**
     * 发票号码
     * Table:     f_order
     * Column:    invoice_tax_number
     * Nullable:  true
     */
    private String invoiceTaxNumber;

    /**
     * 发票抬头
     * Table:     f_order
     * Column:    invoice_title
     * Nullable:  true
     */
    private String invoiceTitle;

    /**
     * 促销折扣
     * Table:     f_order
     * Column:    promotion_discount
     * Nullable:  true
     */
    private BigDecimal promotionDiscount;

    /**
     * Table:     f_order
     * Column:    promotion_names
     * Nullable:  true
     */
    private BigDecimal promotionNames;

    /**
     * 总数量
     * Table:     f_order
     * Column:    total_quantity
     * Nullable:  true
     */
    private Integer totalQuantity;

    /**
     * 退货金额
     * Table:     f_order
     * Column:    refund_amount
     * Nullable:  true
     */
    private BigDecimal refundAmount;

    /**
     * Table:     f_order
     * Column:    returned_quantity
     * Nullable:  true
     */
    private String returnedQuantity;

    /**
     * 发货数量
     * Table:     f_order
     * Column:    shipped_quantity
     * Nullable:  true
     */
    private Integer shippedQuantity;

    /**
     * 发货名称
     * Table:     f_order
     * Column:    shipping_method_name
     * Nullable:  true
     */
    private String shippingMethodName;

    /**
     * 订单编码
     * Table:     f_order
     * Column:    sn
     * Nullable:  true
     */
    private String sn;

    /**
     * 订单状态
     * Table:     f_order
     * Column:    status
     * Nullable:  true
     */
    private String status;

    /**
     * 邮编
     * Table:     f_order
     * Column:    zip_code
     * Nullable:  true
     */
    private String zipCode;

    /**
     * 收货人
     * Table:     f_order
     * Column:    consignee
     * Nullable:  true
     */
    private String consignee;

    /**
     * 省份
     * Table:     f_order
     * Column:    province
     * Nullable:  true
     */
    private String province;

    /**
     * Table:     f_order
     * Column:    city
     * Nullable:  true
     */
    private String city;

    /**
     * Table:     f_order
     * Column:    area
     * Nullable:  true
     */
    private String area;

    /**
     * 详细地址
     * Table:     f_order
     * Column:    address
     * Nullable:  true
     */
    private String address;

    /**
     * 电话
     * Table:     f_order
     * Column:    phone
     * Nullable:  true
     */
    private String phone;

    /**
     * 会员ID
     * Table:     f_order
     * Column:    member_id
     * Nullable:  true
     */
    private Long memberId;

    /**
     * 店铺ID
     * Table:     f_order
     * Column:    store_id
     * Nullable:  true
     */
    private Long storeId;

    /**
     * 支付单号
     * Table:     f_order
     * Column:    pay_sn
     * Nullable:  true
     */
    private String paySn;
}