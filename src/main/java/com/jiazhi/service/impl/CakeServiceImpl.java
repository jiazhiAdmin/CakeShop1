package com.jiazhi.service.impl;

import com.jiazhi.entity.Cake;
import com.jiazhi.entity.Type;
import com.jiazhi.mapper.CakeMapper;
import com.jiazhi.mapper.TypeMapper;
import com.jiazhi.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.List;

@Service
public class CakeServiceImpl implements CakeService {
   @Resource
   private CakeMapper cakeMapper;
    @Resource
    private TypeMapper typeMapper;
    @Transactional
    @Override
    public List<Cake> getAllCakes() {

        List<Cake> allCakes = cakeMapper.getAllCakes();
        System.out.println(allCakes);
        return allCakes;
    }

    @Override
    public List<Cake> getTypecakes(String typeName) {
        List<Cake> typecakelist = cakeMapper.getTypecakes(typeName);
        return typecakelist;
    }

   /* @Override
    public List<Cake> searchCakesByName(String keyword) {
        return cakeMapper.searchCakesByName(keyword);
    }*/
   @Override
   public List<Cake> searchCakesByName(String keyword, int page, int pageSize) {
       int offset = (page - 1) * pageSize;
       return cakeMapper.searchCakesByName(keyword, offset, pageSize);
   }

    @Override
    public int getTotalCakes(String keyword) {
        return cakeMapper.getTotalCakes(keyword);
    }


    @Override
    public Cake getCakeById(Integer cakeId) {
        return cakeMapper.getCakeById(cakeId);
    }



}
