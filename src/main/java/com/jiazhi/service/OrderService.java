package com.jiazhi.service;

import com.jiazhi.entity.Order;

import java.util.List;

public interface OrderService {
    boolean addOrder(Order order);
    List<Order> getAllOrders();
}