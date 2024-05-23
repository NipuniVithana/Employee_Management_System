package com.empManagement.empManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String loginPage(){
        return "auth_login";
    }

    @RequestMapping("/home")
    public String loginSubmit(){
        return "/pages/landing_page";
    }




}
