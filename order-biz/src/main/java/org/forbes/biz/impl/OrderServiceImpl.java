package org.forbes.biz.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.forbes.biz.IOrderService;
import org.forbes.comm.model.OrderPageDto;
import org.forbes.comm.vo.OrderVo;
import org.forbes.dal.entity.Order;
import org.forbes.dal.mapper.OrderMapper;
import org.forbes.dal.mapper.ext.OrderExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lzw
 * @date 2019/12/17 9:37
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    OrderExtMapper orderExtMapper;

    /***
     * 分页查询用户
     */
    @Override
    public IPage<OrderVo> pageUsers(IPage<OrderVo> page, OrderPageDto orderPageDto){
        return orderExtMapper.pageUsers(page, orderPageDto);
    }
}
