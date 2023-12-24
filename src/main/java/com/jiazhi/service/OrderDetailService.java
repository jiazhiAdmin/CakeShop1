package com.jiazhi.service;

import com.jiazhi.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    Boolean addOrderDetail(OrderDetail orderDetail);
    Integer getOrderDetailByCakeId(Integer cakeId,Integer userId);
    Boolean updateCakeQuantityByCakeId(Integer cakeId);


    List<OrderDetail> getOrderDetailsByUserId(Integer userId);

    boolean increaseQuantity(Integer orderDetailId);
    boolean decreaseQuantity(Integer orderDetailId);
    boolean deleteOrderDetail(Integer orderDetailId);
}
