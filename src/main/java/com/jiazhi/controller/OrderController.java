package com.jiazhi.controller;


import com.jiazhi.R.ApiResponse;
import com.jiazhi.entity.Order;
import com.jiazhi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<ApiResponse<String>> addOrder(@RequestBody Order order) {
        boolean addedOrder = orderService.addOrder(order);
        if (addedOrder) {
            ApiResponse<String> response = ApiResponse.success(null);
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<String> response = ApiResponse.error("添加失败");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/orderlist")
    public String getAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        if(orders!=null){
            model.addAttribute("orderlist", orders);
        }

        return "orderstable";
    }
}


