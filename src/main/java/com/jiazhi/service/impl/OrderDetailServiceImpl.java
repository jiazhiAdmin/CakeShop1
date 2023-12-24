package com.jiazhi.service.impl;

import com.jiazhi.entity.OrderDetail;

import com.jiazhi.mapper.OrderDetailMapper;
import com.jiazhi.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public Boolean addOrderDetail(OrderDetail orderDetail) {
        return orderDetailMapper.addOrderDetail(orderDetail);
    }


    @Override
    public Integer getOrderDetailByCakeId(Integer cakeId,Integer userId) {
        return orderDetailMapper.getOrderDetailByCakeId(cakeId,userId);
    }

    @Override
    public Boolean updateCakeQuantityByCakeId(Integer cakeId) {
         return orderDetailMapper.updateCakeQuantityByCakeId(cakeId);
    }

    @Override
    public List<OrderDetail> getOrderDetailsByUserId(Integer userId) {
        return orderDetailMapper.getOrderDetailsByUserId(userId);
    }
    @Transactional
    @Override
    public boolean increaseQuantity(Integer orderDetailId) {
        OrderDetail orderDetail = orderDetailMapper.getOrderDetailById(orderDetailId);
        if(orderDetail!=null && orderDetail.getCakeQuantity()<99){
            return orderDetailMapper.increaseCakeQuantityByOrderDetailId(orderDetailId);
        }
       return false;
    }
    @Transactional
    @Override
    public boolean decreaseQuantity(Integer orderDetailId) {
        OrderDetail orderDetail = orderDetailMapper.getOrderDetailById(orderDetailId);
        if(orderDetail!=null && orderDetail.getCakeQuantity()>1){
            return orderDetailMapper.decreaseCakeQuantityByOrderDetailId(orderDetailId);
        }
        return false;
    }

    @Override
    public boolean deleteOrderDetail(Integer orderDetailId) {
        return orderDetailMapper.deleteOrderDetailById(orderDetailId);
    }
}