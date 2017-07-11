package com.internship.del.jparesearch.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by amrianto on 20/06/2017.
 */

@Entity
@Table(name = "barang")
public class Barang{
    private Integer id;
    private String nama;
    private String jenis;
    private double harga;
    private int stok;

    private List<Transaksi> transaksiList;

    public Barang() {

    }

    @Id
    @Column (name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "nama")
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Column(name = "jenis")
    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    @Column(name = "harga")
    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Column(name = "stok")
    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @OneToMany(mappedBy = "barang", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Transaksi> getTransaksiList() {
      return transaksiList;
    }

    public void setTransaksiList(List<Transaksi> transaksiList) {
        this.transaksiList = transaksiList;
    }
}
