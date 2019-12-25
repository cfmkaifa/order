package org.forbes.comm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * @author lzw
 * @date 2019/12/19 18:38
 */
@Data
@ApiModel(description="订单分页查询参数")
public class OrderPageDto implements Serializable {

    private static final long serialVersionUID = -4860640977554299915L;

    /**
     * 订单状态
     * Table:     f_order
     * Column:    status
     * Nullable:  true
     */
    @ApiModelProperty("订单状态")
    private String status;

    /**
     * id
     */
    @ApiModelProperty(value = "订单编号(id)",example = "0")
    private Long id;

}
