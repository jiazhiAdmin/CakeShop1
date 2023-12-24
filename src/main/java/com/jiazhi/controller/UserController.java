package com.jiazhi.controller;

import com.jiazhi.entity.User;
import com.jiazhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {

        return "login"; // 返回登录页面的视图名
    }

    @RequestMapping("/register")
    public String register() {
        return "register"; // 返回注册页面的视图名
    }


    @RequestMapping("/doLogin")
    public String doLogin(String username, String password, Model model, HttpSession session) {
        // 处理登录请求
        User user = userService.login(username, password);


        if (user != null) {
            Integer userId = user.getId();
            String receiver = user.getReceiver();
            String receiverPhone = user.getReceiverPhone();
            String receiverAddress = user.getReceiverAddress();
            System.out.println(receiverPhone);
            System.out.println(receiverAddress);
            session.setAttribute("user", user);
            session.setAttribute("userId",userId);
            session.setAttribute("receiverPhone",receiverPhone);
            session.setAttribute("receiver",receiver);
            session.setAttribute("receiverAddress",receiverAddress);

            // 判断是否是通过拦截器登录
            Boolean isInterceptorLogin = (Boolean) session.getAttribute("isInterceptorLogin");
            if (isInterceptorLogin != null && isInterceptorLogin) {
                return "redirect:/all";
                //TODO 修改重定向地址
                // 通过拦截器登录，重定向到/orderDetail/add页面
            } else {
                return "redirect:/all"; // 正常登录，重定向到/all页面
            }
        } else {
            model.addAttribute("error", "用户名或密码错误");
            return "login"; // 登录失败返回登录页面，并显示错误信息
        }
    }

    @RequestMapping("/doRegister")
    public String doRegister(User user, RedirectAttributes redirectAttributes) {
        // 检查用户是否存在
        boolean userExists = userService.checkUserExists(user.getUsername());
        if (userExists) {
            redirectAttributes.addFlashAttribute("error", "用户已存在");
            return "register"; // 用户已存在，返回注册页面，并显示错误信息
        }
        // 处理注册请求
        boolean result = userService.register(user);
        System.out.println(user);
        if (result) {
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/all"; // 重定向到登录页面
        } else {
            redirectAttributes.addFlashAttribute("error", "注册失败");
            return "register"; // 注册失败返回注册页面，并显示错误信息
        }
    }




    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user"); // 清除会话中的用户数据
        return "redirect:/all"; // 重定向到登录页面
    }

    @GetMapping("/alluser")
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "userstable";
    }

    @PostMapping("adduser")
    public boolean adduser(@RequestBody User user){
        return userService.register(user);
    }

}