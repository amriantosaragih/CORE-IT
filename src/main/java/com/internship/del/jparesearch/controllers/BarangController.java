package com.internship.del.jparesearch.controllers;

import com.internship.del.jparesearch.model.Barang;
import com.internship.del.jparesearch.services.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

/**
 * Created by amrianto on 21/06/2017.
 */
@Controller
public class BarangController {
    @Autowired
    private BarangService barangService;

    Logger logger;

    @RequestMapping(value = "/allBarang")
    public String listBarang(Model model){
        model.addAttribute("barang",barangService.getAllBarang());
        return "barang";
    }

    @RequestMapping(value = "/barang/create", method = RequestMethod.GET)
    public String TambahBarangForm(Model model){
        model.addAttribute("barang", new Barang());
        return "form-barang";
    }

    @RequestMapping(value = "/barang/create", method = RequestMethod.POST)
    public String TambahBarang(Model model, Barang barang){
        model.addAttribute("barang", barangService.saveBarang(barang));
        return "redirect:/barang/view/"+barang.getId();
    }

    @RequestMapping(value = "/barang/view/{id}", method = RequestMethod.GET)
    public String viewBarang(Model model, @PathVariable int id){
        model.addAttribute("barang", barangService.findOne(id));
        return "view-barang";
    }

    @RequestMapping(value = "/barang/edit/{id}", method = RequestMethod.GET)
    public String editBarangForm(Model model, @PathVariable int id){
        long startTime = System.currentTimeMillis();
        model.addAttribute("barang", barangService.findOne(id));
        long endStartTime = System.currentTimeMillis();
        return "form-update-barang";
    }

    @RequestMapping(value = "/barang/edit/{id}", method = RequestMethod.POST)
    public String editBarang(Barang barang, Model model, @PathVariable String id){
        model.addAttribute("barang",barangService.updateBarang(barang));
        return "redirect:/barang/view/"+barang.getId();
    }

    @RequestMapping(value = "/barang/delete/{id}", method = RequestMethod.GET)
    public String deleteBarang(@PathVariable int id){
        barangService.deleteBarang(id);
        return "redirect:/allBarang";
    }


}
