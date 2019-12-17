package org.forbes.provider;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.forbes.biz.IOrderService;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.enums.OrderStausEnum;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.comm.vo.Result;
import org.forbes.dal.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lzw
 * @date 2019/12/17 9:45
 */
@RestController
@RequestMapping("/order")
@Api(tags={"订单管理"})
@Slf4j
public class OrderController {

    @Autowired
    IOrderService orderService;


    @RequestMapping(value = "/free-thaw-order/{id}",method = RequestMethod.PUT)
    @ApiOperation("修改订单状态")
    @ApiImplicitParam(value="status",name="订单状态",required=false)
    @ApiResponses(value = {
            @ApiResponse(code=500,message = Result.COMM_ACTION_ERROR_MSG),
            @ApiResponse(code=200,message = Result.COMM_ACTION_MSG)
    })
    public Result<Order> freeThawOrder(@PathVariable Long id,
                                       @RequestParam(value="status",required=true)String status){
        Result<Order> result=new Result<Order>();
        boolean isUserStatus = OrderStausEnum.existsOrderStausEnum(status);
        if(!isUserStatus){
            result.setBizCode(BizResultEnum.ORDER_STATUS_NO_EXISTS.getBizCode());
            result.setMessage(String.format(BizResultEnum.ORDER_STATUS_NO_EXISTS.getBizFormateMessage(), status));
            return result;
        }
        Order order = orderService.getById(id);
        if(ConvertUtils.isEmpty(order)){
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        order.setStatus(status);
        orderService.updateById(order);
        return result;
    }
}
