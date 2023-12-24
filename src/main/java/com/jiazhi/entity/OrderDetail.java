package com.jiazhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    private Integer orderDetailId;
    private Integer cakeId;
    private Integer cakeQuantity;
    private double cakePrice;
    private Integer orderId;
    private Integer userId;
}