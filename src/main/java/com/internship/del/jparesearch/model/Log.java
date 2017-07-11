package com.internship.del.jparesearch.model;

import javax.persistence.*;

/**
 * Created by amrianto on 03/07/2017.
 */
@Entity
@Table(name = "log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nama_fungsi")
    private String namaFungsi;
    @Column(name = "nama_relasi")
    private String namaRelasi;
    @Column(name = "waktu_eksekusi")
    private String waktuEksekusi;

    public Log() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaFungsi() {
        return namaFungsi;
    }

    public void setNamaFungsi(String namaFungsi) {
        this.namaFungsi = namaFungsi;
    }

    public String getNamaRelasi() {
        return namaRelasi;
    }

    public void setNamaRelasi(String namaRelasi) {
        this.namaRelasi = namaRelasi;
    }

    public String getWaktuEksekusi() {
        return waktuEksekusi;
    }

    public void setWaktuEksekusi(String waktuEksekusi) {
        this.waktuEksekusi = waktuEksekusi;
    }
}
