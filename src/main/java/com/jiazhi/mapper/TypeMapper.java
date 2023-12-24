package com.jiazhi.mapper;

import com.jiazhi.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface TypeMapper {
    List<Type> getTypes();
    Type getByTypeNameType(String typeName);
}
