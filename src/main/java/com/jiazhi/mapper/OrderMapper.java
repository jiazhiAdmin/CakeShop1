package com.jiazhi.mapper;

import com.jiazhi.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    boolean addOrder(Order order);
    List<Order> getAllOrders();
}
