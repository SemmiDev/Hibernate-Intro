package com.sam.demo.service;

import com.sam.demo.entity.Mahasiswa;

import java.util.List;

public interface MahasiswaService {

    public boolean insert(Mahasiswa m);

    public boolean update(Mahasiswa m);

    public boolean delete(Mahasiswa m);

    public Mahasiswa getMahasiswaByNim(String nim);

    public List<Mahasiswa> getAllMahasiswa();
}

