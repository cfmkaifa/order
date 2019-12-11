package org.forbes.dal.entity;

import java.util.Date;
import lombok.Data;

/**
 * Table: f_order_log
 */
@Data
public class OrderLog extends BaseEntity {
    /**
     * 主键
     * Table:     f_order_log
     * Column:    id
     * Nullable:  false
     */
    private Long id;

    /**
     * Table:     f_order_log
     * Column:    create_by
     * Nullable:  true
     */
    private String createBy;

    /**
     * 创建时间
     * Table:     f_order_log
     * Column:    create_time
     * Nullable:  true
     */
    private Date createTime;

    /**
     * 更新人
     * Table:     f_order_log
     * Column:    update_by
     * Nullable:  true
     */
    private String updateBy;

    /**
     * 更新时间
     * Table:     f_order_log
     * Column:    update_time
     * Nullable:  true
     */
    private Date updateTime;

    /**
     * 订单ID
     * Table:     f_order_log
     * Column:    order_id
     * Nullable:  true
     */
    private Long orderId;

    /**
     * 会员ID
     * Table:     f_order_log
     * Column:    member_id
     * Nullable:  true
     */
    private Long memberId;

    /**
     * 操作内容
     * Table:     f_order_log
     * Column:    opr_content
     * Nullable:  true
     */
    private String oprContent;
}