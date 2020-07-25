package com.sam.demo.service;

import java.util.List;

import com.sam.demo.entity.Mahasiswa;
import com.sam.demo.util.HibernateUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class MahasiswaServiceTest {

    MahasiswaService ms;

    @Before
    public void setUp() {
        ms = new MahasiswaServiceImpl(HibernateUtil.getMahasiswaDao());
    }


    @After
    public void tearDown() {
        HibernateUtil.shutdown();
    }

    @Test
    public void testInsert() {
        Mahasiswa m = new Mahasiswa("12345", "Sammidev", 4.0F, "Teknik Informatika");
        assertTrue(ms.insert(m));
    }

    @Ignore
    @Test
    public void testUpdate() {
        Mahasiswa m = new Mahasiswa("67890", "Adisti", 4.0F, "Kedokteran Gigi");
        assertTrue(ms.update(m));
    }

    @Ignore
    @Test
    public void testDelete() {
        Mahasiswa m = new Mahasiswa("67890", "Adisti", 4.0F, "TeknKedokteranik Gigi");
        assertTrue(ms.delete(m));
    }

    @Ignore
    @Test
    public void testGetMahasiswaByNim() {
        Mahasiswa mhs = ms.getMahasiswaByNim("12345");
        if (mhs != null) {
            System.out.println("" + mhs);
        }
        assertNotNull(mhs);
    }
    @Ignore
    @Test
    public void testGetAllMahasiswa() {
        List<Mahasiswa> allMahasiswa = ms.getAllMahasiswa();
        if (allMahasiswa != null) {
            allMahasiswa.forEach((mahasiswa) -> {
                System.out.println("" + mahasiswa);
            });
        }
        assertNotNull(allMahasiswa);
    }
}
