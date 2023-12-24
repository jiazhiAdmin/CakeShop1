package com.jiazhi.controller;

import com.jiazhi.entity.Type;

import com.jiazhi.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String getTypes(Model model) {
        List<Type> types = typeService.getTypes();
        if (types!=null){
            model.addAttribute("types",types);
        }

        return "index";
    }
    @GetMapping("/alltype")
    public String getAllType(Model model) {
        List<Type> types = typeService.getTypes();
        if(types!=null){
            model.addAttribute("typelist",types);
        }
        return "typestable";
    }
}
