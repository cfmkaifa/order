package org.forbes.comm.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.forbes.comm.constant.UpdateValid;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author lzw
 * @date 2019/12/20 10:29
 */
@Data
@ApiModel(description="订单分页返回参数")
public class OrderVo implements Serializable {

    private static final long serialVersionUID = 1707289253049597397L;

    /**
     * id
     */
    @ApiModelProperty("订单编号")
    private Long id;

    /**
     * 总数量
     * Table:     f_order
     * Column:    total_quantity
     * Nullable:  true
     */
    @ApiModelProperty("总数量")
    private Integer totalQuantity;

    /**
     * 总金额
     * Table:     f_order
     * Column:    amount
     * Nullable:  true
     */
    @ApiModelProperty("总金额")
    private BigDecimal amount;

    /**
     * 订单状态
     * Table:     f_order
     * Column:    status
     * Nullable:  true
     */
    @ApiModelProperty("订单状态")
    private String status;

    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 姓名
     * Table:     f_sys_user
     * Column:    realname
     * Nullable:  true
     */
    @ApiModelProperty(value = "姓名",required = true)
    private String realname;

    /**
     * 联系方式
     */
    @Pattern(regexp ="^[1][3,4,5,7,8][0-9]{9}$")
    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "用户对应角色",required = true)
    private List<String> roleNameList;
}
