package com.sam.demo;

import com.sam.demo.dao.MahasiswaDao;
import com.sam.demo.entity.Mahasiswa;
import com.sam.demo.util.HibernateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		MahasiswaDao mahasiswaDao = HibernateUtil.getMahasiswaDao();
		Mahasiswa sam = new Mahasiswa("12345", "Sammidev", 4.0F," Teknik Informatika");
		Mahasiswa adis = new Mahasiswa("67890", "Adisti", 4.0F," Kedokteran Gigi");

		mahasiswaDao.insert(sam);
		mahasiswaDao.insert(adis);
	}
}
