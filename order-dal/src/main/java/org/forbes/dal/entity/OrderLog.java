package org.forbes.dal.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Table: f_order_log
 */
@Data
@ApiModel(description="订单日志信息")
@EqualsAndHashCode(callSuper = false)
@TableName("f_order_item")
public class OrderLog extends BaseEntity {

    private static final long serialVersionUID = 5214564588329260328L;
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