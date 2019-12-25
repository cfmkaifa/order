package org.forbes.dal.mapper.ext;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.forbes.comm.model.OrderPageDto;
import org.forbes.comm.vo.OrderVo;
import org.forbes.dal.entity.Order;

/**
 * @author lzw
 * @date 2019/12/17 9:26
 */
public interface OrderExtMapper extends BaseMapper<Order>{

    /***
     * pageUsers方法概述:分页查询订单信息
     * @param
     * @return
     * @创建人 Tom
     * @创建时间 2019/12/20 8:33
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    IPage<OrderVo> pageUsers(IPage<OrderVo> page, @Param("orderPageDto") OrderPageDto orderPageDto);
}
