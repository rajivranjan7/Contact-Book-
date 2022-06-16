/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactbook.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rajiv
 */
@Controller
public class TestController {

    @RequestMapping("/test/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping("/test/ajax_test")
    public String testPage() {
        return "test Page";
    }

    @RequestMapping("/test/get_time")
    @ResponseBody
    public String getServerTime() {
        System.out.println("Output of: getServerTime()");
        Date d = new Date();
        return d.toString();
    }
}
