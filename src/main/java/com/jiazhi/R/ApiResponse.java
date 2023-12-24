package com.jiazhi.R;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;

    // 省略构造函数和getter/setter方法

    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatus(200);
        response.setMessage("Success");
        response.setData(data);
        return response;
    }

    public static <T> ApiResponse<T> error(String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatus(500);
        response.setMessage(message);
        return response;
    }
}
