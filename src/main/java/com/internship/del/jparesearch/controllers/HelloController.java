package com.internship.del.jparesearch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by amrianto on 20/06/2017.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String getMessage(){
        return "Hello World";
    }

    @RequestMapping(value = "/helloworld")
    public String hello(){
        return "hello";
    }

}
