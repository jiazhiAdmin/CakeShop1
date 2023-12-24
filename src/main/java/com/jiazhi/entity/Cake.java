package com.jiazhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cake {
    private Integer cakeId;
    private Integer typeId;
    private String cakeName;
    private Integer cakeInventory;
    private String cakeDescription;
    private BigDecimal cakePrice;
    private String cakeCoverImage;
    private String cakeDetailedPhoto1;
    private String cakeDetailedPhoto2;
}
