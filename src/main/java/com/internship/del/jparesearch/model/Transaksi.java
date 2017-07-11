package com.internship.del.jparesearch.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amrianto on 03/07/2017.
 */

@Entity
@Table(name = "transaksi")
@IdClass(TransaksiId.class)
public class Transaksi implements Serializable{
    private Pengguna pengguna;
    private Barang barang;
    private double harga;
    private String tanggalTransaksi;
    private int jumlahBarang;
    private double totalHarga;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "barang_id", referencedColumnName = "id")
    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    @Column(name = "tanggal_transaksi")
    public String getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(String tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    @Column(name = "jumlah_barang")
    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    @Column(name = "harga")
    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Column(name = "total_harga")
    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }
}
