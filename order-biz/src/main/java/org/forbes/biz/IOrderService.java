package org.forbes.biz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.forbes.comm.model.OrderPageDto;
import org.forbes.comm.model.SysUserDto;
import org.forbes.comm.vo.OrderVo;
import org.forbes.comm.vo.UserVo;
import org.forbes.dal.entity.Order;

/**
 * @author lzw
 * @date 2019/12/17 9:37
 */
public interface IOrderService extends IService<Order> {

    /***
     * pageUsers方法概述:分页查询订单信息
     * @param
     * @return
     * @创建人 Tom
     * @创建时间 2019/12/20 8:33
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    IPage<OrderVo> pageUsers(IPage<OrderVo> page, OrderPageDto orderPageDto);

}
