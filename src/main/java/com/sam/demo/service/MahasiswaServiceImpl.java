package com.sam.demo.service;

import com.sam.demo.dao.MahasiswaDao;
import com.sam.demo.entity.Mahasiswa;

import java.util.List;

public class MahasiswaServiceImpl implements MahasiswaService {

    private final MahasiswaDao dao;
    public MahasiswaServiceImpl(MahasiswaDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean insert(Mahasiswa m) {
        return dao.insert(m);
    }

    @Override
    public boolean update(Mahasiswa m) {
        return dao.update(m);
    }

    @Override
    public boolean delete(Mahasiswa m) {
        return dao.delete(m);
    }

    @Override
    public Mahasiswa getMahasiswaByNim(String nim) {
        return dao.getMahasiswaByNim(nim);
    }

    @Override
    public List<Mahasiswa> getAllMahasiswa() {
        return dao.getAllMahasiswa();
    }
}
