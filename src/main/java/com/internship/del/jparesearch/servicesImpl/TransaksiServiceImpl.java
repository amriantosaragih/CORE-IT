package com.internship.del.jparesearch.servicesImpl;

import com.internship.del.jparesearch.model.Pengguna;
import com.internship.del.jparesearch.model.Transaksi;
import com.internship.del.jparesearch.services.PenggunaService;
import com.internship.del.jparesearch.services.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by amrianto on 03/07/2017.
 */
@Service
public class TransaksiServiceImpl implements TransaksiService {

    @Autowired
    private TransaksiService transaksiService;
    @Autowired
    private PenggunaService penggunaService;


    @Override
    @Transactional
    public Transaksi saveTransaksi(Transaksi transaksi) {

        return transaksiService.saveTransaksi(transaksi);
    }

    @Override
    @Transactional
    public Transaksi delete(int id) {
        Transaksi transaksi = findOne(id);
        if(transaksi!=null){
            transaksiService.delete(id);
            return transaksi;
        }else {
            return null;
        }
    }

    @Override
    public List<Transaksi> getAllTransaksi() {

        return transaksiService.getAllTransaksi();
    }

    @Override
    public Transaksi findOne(int id) {

        return transaksiService.findOne(id);
    }
}
