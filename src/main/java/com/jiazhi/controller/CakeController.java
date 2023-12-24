package com.jiazhi.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiazhi.entity.Cake;
import com.jiazhi.entity.Type;
import com.jiazhi.service.CakeService;
import com.jiazhi.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class CakeController {

    @Autowired
    private CakeService cakeService;
    @Autowired
    private TypeService typeService;

    @RequestMapping ("/index")
    public String getAllCakes(Model model, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize) {

                List<Type> types = typeService.getTypes();
                model.addAttribute("types", types);


            PageHelper.startPage(pageNum,pageSize);
            List<Cake> cakes = cakeService.getAllCakes();
            if(cakes!=null){
            PageInfo<Cake> pageInfo = new PageInfo<>(cakes);

            model.addAttribute("cakes", pageInfo.getList());
            model.addAttribute("pageNum", pageInfo.getPageNum());

            model.addAttribute("pageSize", pageSize);

            int total= (int) (pageInfo.getTotal()/pageSize);
            model.addAttribute("total",total);}
            return "index";
        }
/*    @RequestMapping ("/typecake")
    public String getTypecake(Model model, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize,String typeName) {

        List<Cake> typecakes = cakeService.getTypecakes(typeName);
        model.addAttribute("cakes",typecakes);
        return "index";
    }*/
   @RequestMapping ("/typecake")
   public ModelAndView getTypecake(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize,String typeName) {

       ModelAndView modelAndView = new ModelAndView("index");
       List<Cake> typecakes = cakeService.getTypecakes(typeName);
       if (typecakes!=null){
           modelAndView.addObject("cakes", typecakes);
       }

       return modelAndView;

   }
    @GetMapping("/searchCakes")
    public ModelAndView searchCakesByName(@RequestParam("keyword") String keyword,
                                      @RequestParam(value = "page", defaultValue = "1") int page,
                                      @RequestParam(value = "pageSize", defaultValue = "8") int pageSize) {
    ModelAndView modelAndView = new ModelAndView("cakes");
    List<Cake> cakes = cakeService.searchCakesByName(keyword, page, pageSize);
    if(cakes!=null){
        modelAndView.addObject("cakes", cakes);
    }

    return modelAndView;
    }

    @GetMapping("/fenye")
    public ModelAndView fenye(@RequestParam("keyword") String keyword,@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize){
  /*      model.addAttribute("cakes", pageInfo.getList());
        model.addAttribute("pageNum", pageInfo.getPageNum());

        model.addAttribute("pageSize", pageSize);

        int total= (int) (pageInfo.getTotal()/pageSize);
        model.addAttribute("total",total);*/
        ModelAndView modelAndView = new ModelAndView("footer");
        modelAndView.addObject("pageNum", pageNum);
        modelAndView.addObject("pageSize", pageSize);

        int totalCakes = cakeService.getTotalCakes(keyword);
        if(totalCakes!=0){
            int total= (int) (totalCakes/pageSize);
            modelAndView.addObject("total",total);
        }

        return modelAndView;
    }


    @GetMapping("/cake/{cakeId}")
    public String getCakeById(@PathVariable Integer cakeId, Model model) {
        Cake cake = cakeService.getCakeById(cakeId);
        if (cake!=null){
            model.addAttribute("cake", cake);

        }
        return "cake";
    }
    @RequestMapping ("/cakelist")
    public String getCakeList(Model model, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize) {


        List<Cake> cakes = cakeService.getAllCakes();

        if (cakes!=null){
            model.addAttribute("cakelist", cakes);
        }

        return "cakestable";
    }
}






