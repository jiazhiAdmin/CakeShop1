package com.jiazhi.service.impl;

import com.jiazhi.entity.Type;
import com.jiazhi.mapper.TypeMapper;
import com.jiazhi.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public List<Type> getTypes() {
        return typeMapper.getTypes();
    }
}