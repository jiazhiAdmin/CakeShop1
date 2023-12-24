package com.jiazhi.service.impl;

import com.jiazhi.entity.Order;
import com.jiazhi.mapper.OrderMapper;
import com.jiazhi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public boolean addOrder(Order order) {
        return  orderMapper.addOrder(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderMapper.getAllOrders();
    }
}
