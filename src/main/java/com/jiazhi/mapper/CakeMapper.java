package com.jiazhi.mapper;

import com.jiazhi.entity.Cake;
import com.jiazhi.entity.Type;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CakeMapper {

    List<Cake> getAllCakes();

    List<Cake> getTypecakes(String typeName);

    Cake getCakeById(Integer cakeId);

    List<Cake> searchCakesByName(@Param("keyword") String keyword);
    List<Cake> searchCakesByName(@Param("keyword") String keyword, @Param("offset") int offset, @Param("pageSize") int pageSize);
    int getTotalCakes(String keyword);


}
