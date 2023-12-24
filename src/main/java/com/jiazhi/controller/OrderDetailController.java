package com.jiazhi.controller;

import com.jiazhi.R.ApiResponse;
import com.jiazhi.entity.Cake;
import com.jiazhi.entity.OrderDetail;
import com.jiazhi.mapper.CakeMapper;
import com.jiazhi.service.CakeService;
import com.jiazhi.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/orderDetail/add")
    @ResponseBody
    public ResponseEntity<ApiResponse<String>> addOrderDetail(@RequestBody OrderDetail orderDetail) {


        Integer i = getOrderDetailByCakeId(orderDetail.getCakeId(),orderDetail.getUserId());
        if(i<=0){
            Boolean addedOrderDetail = orderDetailService.addOrderDetail(orderDetail);

            if (addedOrderDetail) {
                ApiResponse<String> response = ApiResponse.success(null);
                return ResponseEntity.ok(response);
            } else {
                ApiResponse<String> response = ApiResponse.error("添加失败");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
        }else {
            Boolean updateCakeQuantity = updateCakeQuantity(orderDetail.getCakeId());

            if (updateCakeQuantity) {
                ApiResponse<String> response = ApiResponse.success(null);
                return ResponseEntity.ok(response);
            } else {
                ApiResponse<String> response = ApiResponse.error("更新失败");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
        }
    }


    @GetMapping
    public Integer getOrderDetailByCakeId(Integer cakeId,Integer userId) {
        return orderDetailService.getOrderDetailByCakeId(cakeId,userId);
    }

    @PutMapping
    public Boolean  updateCakeQuantity(Integer cakeId) {
        return orderDetailService.updateCakeQuantityByCakeId(cakeId);
    }


    @Autowired
    private CakeService cakeService;

    @RequestMapping("/cartlist")
    public String getOrderDetailsByUserId(@RequestParam Integer userId, Model model) {
        List<OrderDetail> orderDetails = orderDetailService.getOrderDetailsByUserId(userId);
        if (orderDetails!=null){
            List<Integer> cakeIds = new ArrayList<>();
            for (OrderDetail orderDetail : orderDetails) {
                cakeIds.add(orderDetail.getCakeId());
            }
            ArrayList<Cake> cakes = new ArrayList<>();
            for (Integer cakeId : cakeIds) {
//            Cake cake = cakeMapper.getCakeById(cakeId);
                Cake cake = cakeService.getCakeById(cakeId);
                cakes.add(cake);
            }
            model.addAttribute("cakes",cakes);
            model.addAttribute("orderDetails", orderDetails);
        }

        return "cartlist"; // 返回orderDetailList.jsp视图页面
    }







    @RequestMapping("/increaseQuantity")
    @ResponseBody
    public ResponseEntity<ApiResponse<String>> increaseQuantity(@RequestParam Integer orderDetailId) {
        boolean result = orderDetailService.increaseQuantity(orderDetailId);
        if (result) {
            ApiResponse<String> response = ApiResponse.success(null);
            return  ResponseEntity.ok(response);
        } else {
            ApiResponse<String> response = ApiResponse.error("数量+1失败");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @RequestMapping("/decreaseQuantity")
    @ResponseBody
    public ResponseEntity<ApiResponse<String>> decreaseQuantity(@RequestParam Integer orderDetailId) {
        boolean result = orderDetailService.decreaseQuantity(orderDetailId);
        if (result) {
            ApiResponse<String> response = ApiResponse.success(null);
            return  ResponseEntity.ok(response);
        } else {
            ApiResponse<String> response = ApiResponse.error("数量-1失败");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @RequestMapping("/deleteOrderDetail")
    @ResponseBody
    public ResponseEntity<ApiResponse<String>>deleteOrderDetail(@RequestParam Integer orderDetailId) {
        boolean result = orderDetailService.deleteOrderDetail(orderDetailId);
        if (result) {
            ApiResponse<String> response = ApiResponse.success(null);
            return  ResponseEntity.ok(response);
        } else {
            ApiResponse<String> response = ApiResponse.error("蛋糕删除失败");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }




}