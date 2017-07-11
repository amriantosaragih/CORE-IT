package com.internship.del.jparesearch.services;

import com.internship.del.jparesearch.model.Pengguna;

import java.util.List;

/**
 * Created by amrianto on 21/06/2017.
 */
public interface PenggunaService {
    public Pengguna savePengguna(Pengguna pengguna);
    public Pengguna updatePengguna(Pengguna pengguna);
    public Pengguna delete(int id);
    public List<Pengguna> getAllPengguna();
    public Pengguna findOne(int id);
}
