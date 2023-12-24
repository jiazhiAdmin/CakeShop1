package com.jiazhi.service;

import com.jiazhi.entity.Cake;
import com.jiazhi.entity.User;

import java.util.List;

public interface CakeService {
    List<Cake> getAllCakes();

    List<Cake> getTypecakes(String typeName);
//    List<Cake> searchCakesByName(String keyword);
    List<Cake> searchCakesByName(String keyword, int page, int pageSize);
    int getTotalCakes(String keyword);

    Cake getCakeById(Integer cakeId);
}
