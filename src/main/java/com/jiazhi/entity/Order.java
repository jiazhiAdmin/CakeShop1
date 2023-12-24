package com.jiazhi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Integer orderId;
    private Integer userId;
    private String  orderName;
    private Date    orderDate;
    private Integer orderQuantity;
    private double  orderTotalAmount;
    private String    paymentStatus;
    private String  paymentMethod;
    private String  receiver;
    private String  receiverPhone;
    private String  deliveryAddress;
}