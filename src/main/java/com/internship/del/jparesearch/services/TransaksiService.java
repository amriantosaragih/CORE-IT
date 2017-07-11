package com.internship.del.jparesearch.services;

import com.internship.del.jparesearch.model.Transaksi;

import java.util.List;

/**
 * Created by amrianto on 03/07/2017.
 */
public interface TransaksiService {
    public Transaksi saveTransaksi(Transaksi transaksi);
    public Transaksi delete(int id);
    public List<Transaksi> getAllTransaksi();
    public Transaksi findOne(int id);
}
