package org.forbes.provider;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.forbes.api.service.ISysUserService;
import org.forbes.biz.IOrderService;
import org.forbes.comm.constant.PermsCommonConstant;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.enums.OrderStausEnum;
import org.forbes.comm.model.BasePageDto;
import org.forbes.comm.model.OrderPageDto;
import org.forbes.comm.model.SysUserDto;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.comm.vo.OrderVo;
import org.forbes.comm.vo.Result;
import org.forbes.comm.vo.UserVo;
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

    @Autowired
    ISysUserService sysUserService;


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

    /***
     * selectPage方法概述:分页查询订单信息
     * @param basePageDto, orderPageDto
     * @return org.forbes.comm.vo.Result<com.baomidou.mybatisplus.core.metadata.IPage<org.forbes.dal.entity.Order>>
     * @创建人 Tom
     * @创建时间 2019/12/20 8:33
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ApiOperation(value="分页查询订单信息")
    @ApiResponses(value={
            @ApiResponse(code=500,message= Result.ORDER_NOT_ERROR_MSG),
            @ApiResponse(code=200,message = Result.ORDER_MSG)
    })
    public Result<IPage<OrderVo>> selectPage(BasePageDto basePageDto, OrderPageDto orderPageDto){
        log.debug("传入参数为："+ JSON.toJSONString(basePageDto));
        Result<IPage<OrderVo>> result=new Result<IPage<OrderVo>>();
        IPage<OrderVo> page = new Page<OrderVo>(basePageDto.getPageNo(),basePageDto.getPageSize());
        IPage<OrderVo> pageUsers =  orderService.pageUsers(page, orderPageDto);
        result.setResult(pageUsers);
        return result;
    }

    /***
     * checkSn方法概述:
     * @param sn
     * @return org.forbes.comm.vo.Result<java.lang.Boolean>
     * @创建人 Tom
     * @创建时间 2019/12/20 9:18
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @ApiOperation("校验订单编码是否唯一")
    @ApiImplicitParam(name = "sn",value = "订单编码",required = true)
    @RequestMapping(value = "/check-sn", method = RequestMethod.GET)
    public Result<Boolean> checkSn(@RequestParam(value = "sn",required=true) String sn) {
        log.debug("传入参数为："+sn);
        Result<Boolean> result = new Result<Boolean>();
        int exitsCount = orderService.count(new QueryWrapper<Order>().eq(PermsCommonConstant.SN,sn));
        if (exitsCount > 0){//如果编码存在，则返回false
            result.setMessage(Result.EXISTS_ORDER_SN_MSG);
            result.setResult(false);
            return result;
        }
        result.setMessage(Result.AVAILABLE_ORDER_SN_MSG);
        return result;
    }




}
