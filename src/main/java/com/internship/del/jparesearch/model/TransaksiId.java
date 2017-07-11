package com.internship.del.jparesearch.model;

import java.io.Serializable;

/**
 * Created by amrianto on 05/07/2017.
 */
public class TransaksiId implements Serializable{

    private int pengguna;
    private int barang;

    public int getPengguna() {
        return pengguna;
    }

    public void setPengguna(int pengguna) {
        this.pengguna = pengguna;
    }

    public int getBarang() {
        return barang;
    }

    public void setBarang(int barang) {
        this.barang = barang;
    }
}
