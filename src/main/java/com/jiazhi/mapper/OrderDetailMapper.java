package com.jiazhi.mapper;

import com.jiazhi.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface OrderDetailMapper {
    Boolean addOrderDetail(OrderDetail orderDetail);
    Integer getOrderDetailByCakeId(@Param("cakeId") Integer cakeId, @Param("userId") Integer userId);
    Boolean updateCakeQuantityByCakeId(Integer cakeId);

    List<OrderDetail> getOrderDetailsByUserId(Integer userId);

    boolean increaseCakeQuantityByOrderDetailId(Integer orderDetailId);
    boolean decreaseCakeQuantityByOrderDetailId(Integer orderDetailId);
    boolean deleteOrderDetailById(Integer orderDetailId);
    OrderDetail getOrderDetailById(Integer orderDetailId);

}