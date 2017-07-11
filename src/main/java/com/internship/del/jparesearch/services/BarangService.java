package com.internship.del.jparesearch.services;

import com.internship.del.jparesearch.model.Barang;

import java.util.List;

/**
 * Created by amrianto on 21/06/2017.
 */
public interface BarangService {
    public Barang saveBarang(Barang barang);
    public Barang deleteBarang(int id);
    public List<Barang> getAllBarang();
    public Barang findOne(int id);
    public Barang updateBarang(Barang barang);
}
