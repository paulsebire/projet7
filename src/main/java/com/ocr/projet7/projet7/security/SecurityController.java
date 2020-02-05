package com.ocr.projet7.projet7.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SecurityController {



    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/")
    public String homeShort(){
        return "redirect:/home";
    }

    @RequestMapping(value = "/403")
    public String accessDenied(){
        return "403";
    }

    //@GetMapping(value = "/**/{path:[^\\.]*}")
    //public String redirect404() {
    //    return "redirect:/home";
    //}



}
