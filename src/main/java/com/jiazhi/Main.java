package com.jiazhi;

import com.jiazhi.mapper.CakeMapper;
import com.jiazhi.mapper.TypeMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Map<String, TypeMapper> mappers = context.getBeansOfType(TypeMapper.class);
        if (mappers.isEmpty()) {
            System.out.println("容器中没有Mapper接口的实例");
        } else {
            System.out.println("容器中存在Mapper接口的实例");
            // 遍历所有的Mapper实例
            for (TypeMapper mapper : mappers.values()) {
                System.out.println(mapper.getClass().getName());
            }
        }

    }
}
