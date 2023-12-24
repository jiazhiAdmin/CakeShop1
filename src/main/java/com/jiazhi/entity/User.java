package com.jiazhi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer status;
    private String role;
    private String receiver;
    private String receiverPhone;
    private String receiverAddress;
}