/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactbook.controller;

import com.mycompany.contactbook.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author rajiv
 */
@Controller
public class UserController {
    @Autowired
    private UserServiceInterface userService;
   
    @RequestMapping(value={"/","/index"})
    public String index(Model m){
        return "index";
    }
    
    @RequestMapping("/login_form")
    public String loginForm(Model m){
        m.addAttribute("command",new LoginAction());
        return "login_form";
    }
}
