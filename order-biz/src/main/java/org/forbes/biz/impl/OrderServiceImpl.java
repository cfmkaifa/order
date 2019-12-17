package org.forbes.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.forbes.biz.IOrderService;
import org.forbes.dal.entity.Order;
import org.forbes.dal.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
 * @author lzw
 * @date 2019/12/17 9:37
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
}
