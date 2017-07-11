package com.internship.del.jparesearch.servicesImpl;

import com.internship.del.jparesearch.Repositories.BarangRepository;
import com.internship.del.jparesearch.model.Barang;
import com.internship.del.jparesearch.services.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amrianto on 21/06/2017.
 */

@Service
public class BarangServiceImpl implements BarangService{

    @Autowired
    private BarangRepository barangRepository;

    @Override
    @Transactional
    public Barang saveBarang(Barang barang) {
        if(barangRepository.findOne(barang.getId())==null){
            return barangRepository.save(barang);
        }else{
            return null;
        }
    }

    @Override
    @Transactional
    public Barang deleteBarang(int id) {
        Barang barang = barangRepository.findOne(id);
        if(barang!=null) {
            barangRepository.delete(barang);
            return barang;
        }else {
            return null;
        }
    }

    @Override
    public List<Barang> getAllBarang() {
        List<Barang> listBarang = barangRepository.findAll();
        List<Barang> barangs = new ArrayList<>();
        int i=0;
        for (Barang barang:listBarang) {
            i++;
            if(i<100){
                barangs.add(barang);
            }
        }
        return barangs;
    }

    @Override
    public Barang findOne(int id) {
        return barangRepository.findOne(id);
    }

    @Override
    @Transactional
    public Barang updateBarang(Barang barang) {
        Barang barang1 = findOne(barang.getId());
        barang1.setNama(barang.getNama());
        barang1.setJenis(barang.getJenis());
        barang1.setHarga(barang.getHarga());
        barang1.setStok(barang.getStok());
        return barangRepository.saveAndFlush(barang1);
    }
}
