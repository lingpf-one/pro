package com.etc.ticket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/myjump")
    public String myjump(){
        System.out.println("执行了myjump方法");
        return "index"; //转发index.jsp页面
    }
}
