package com.sam.demo.entity;

import org.hibernate.annotations.Columns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mahasiswa")
public class Mahasiswa {

    public Mahasiswa() {
    }

    public Mahasiswa(String nim, String nama, float ipk, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.ipk = ipk;
        this.jurusan = jurusan;
    }

    @Id
    @Column(name = "NIM", nullable = false, length = 12, unique = true)
    private String nim;

    @Column(name = "NAMA", nullable = false, length = 50)
    private String nama;

    @Column(name = "IPK", nullable = false, length = 4)
    private float ipk;

    @Column(name = "JURUSAN", nullable = false, length = 50)
    private String jurusan;


    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public float getIpk() {
        return ipk;
    }

    public void setIpk(float ipk) {
        this.ipk = ipk;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "nim='" + nim + '\'' +
                ", nama='" + nama + '\'' +
                ", ipk=" + ipk +
                ", jurusan='" + jurusan + '\'' +
                '}';
    }
}
