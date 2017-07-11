package com.internship.del.jparesearch.controllers;

import com.internship.del.jparesearch.Repositories.PenggunaRepository;
import com.internship.del.jparesearch.model.Pengguna;
import com.internship.del.jparesearch.services.PenggunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by amrianto on 22/06/2017.
 */
@Controller
public class PenggunaController {

    @Autowired
    private PenggunaService penggunaService;

    @RequestMapping(value = "/allPengguna")
    public String listPengguna(Model model){
        model.addAttribute("pengguna", penggunaService.getAllPengguna());
        return "pengguna";
    }

    @RequestMapping(value = "/pengguna/create", method = RequestMethod.GET)
    public String tambahPenggunaForm(Model model){
        model.addAttribute("pengguna", new Pengguna());
        return "form-pengguna";
    }

    @RequestMapping(value = "/pengguna/create", method = RequestMethod.POST)
    public String tambahPengguna(Model model, Pengguna pengguna){
        model.addAttribute("pengguna", penggunaService.savePengguna(pengguna));
        return "redirect:/allPengguna";
    }

    @RequestMapping(value = "/pengguna/edit/{user_id}", method = RequestMethod.GET)
    public String editPenggunaForm(Model model, @PathVariable int user_id){
        model.addAttribute("pengguna", penggunaService.findOne(user_id));
        return "form-update-pengguna";
    }

    @RequestMapping(value = "/pengguna/edit/{user_id}", method = RequestMethod.POST)
    public String editPengguna(Model model, Pengguna pengguna, @PathVariable String user_id){
        model.addAttribute("pengguna", penggunaService.updatePengguna(pengguna));
        return "redirect:/pengguna/view/"+pengguna.getUser_id();
    }

    @RequestMapping(value = "/pengguna/view/{user_id}")
    public String view(Model model, @PathVariable int user_id){
        model.addAttribute("pengguna", penggunaService.findOne(user_id));
        return "view-pengguna";
    }

    @RequestMapping(value = "/pengguna/delete/{user_id}", method = RequestMethod.GET)
    public String delete(@PathVariable int user_id){
        penggunaService.delete(user_id);
        return "redirect:/allPengguna";
    }

}
