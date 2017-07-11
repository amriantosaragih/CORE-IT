package com.internship.del.jparesearch.controllers;

import com.internship.del.jparesearch.model.Barang;
import com.internship.del.jparesearch.model.Pengguna;
import com.internship.del.jparesearch.model.Transaksi;
import com.internship.del.jparesearch.services.BarangService;
import com.internship.del.jparesearch.services.PenggunaService;
import com.internship.del.jparesearch.services.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amrianto on 04/07/2017.
 */
@Controller
public class TransaksiController {

    @Autowired
    private TransaksiService transaksiService;
    @Autowired
    private PenggunaService penggunaService;
    @Autowired
    private BarangService barangService;


    @RequestMapping(value = "/allTransaksi")
    public String ListTransaksi(Model model){

        model.addAttribute("transaksi", transaksiService.getAllTransaksi());
        return "transaksi";
    }

    @RequestMapping(value = "/transaksi/create", method = RequestMethod.GET)
    public String FormCreate(Model model){
        model.addAttribute("transaksi", new Transaksi());
        return "create";
    }

    @RequestMapping(value = "/transaksi/create", method = RequestMethod.POST)
    public String Create(Model model, Transaksi transaksi){
        model.addAttribute("transaksi", transaksiService.saveTransaksi(transaksi));
        return "redirect:/allTransaksi";
    }

    @RequestMapping(value = "/transaksi/view/{id}")
    public String view(Model model, @PathVariable int id){
        model.addAttribute("transaksi", transaksiService.findOne(id));
        return "view-transaksi";
    }

    @RequestMapping(value = "/transaksi/delete/{id}")
    public String delete(@PathVariable int id){
        transaksiService.delete(id);
        return "redirect:/allTransaksi";
    }

}
