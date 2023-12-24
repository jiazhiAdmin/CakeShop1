package com.jiazhi.controller;

import com.jiazhi.entity.Cake;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class HOUTAIController {
    @GetMapping("/houtai")
    public String getCakeById() {

        return "houtai";
    }
}
