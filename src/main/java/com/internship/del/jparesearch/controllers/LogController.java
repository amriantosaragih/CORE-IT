package com.internship.del.jparesearch.controllers;

import com.internship.del.jparesearch.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by amrianto on 04/07/2017.
 */
@Controller
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping(value = "/allLog")
    public String Log(Model model){
        model.addAttribute("log", logService.getAllLog());
        return "log";
    }

    @RequestMapping(value = "/log/view/{id}")
    public String view(Model model, @PathVariable int id){
        model.addAttribute("log", logService.findOne(id));
        return "view";
    }

    @RequestMapping(value = "/log/delete/{id}")
    public String delete(@PathVariable int id){
        logService.deleteLog(id);
        return "redirect:/allLog";
    }
}
