package com.sam.demo.dao;

import com.sam.demo.entity.Mahasiswa;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MahasiswaImpl implements MahasiswaDao {

    // session -> ibarat interface connection pada jdbc
    private final Session session;
    public MahasiswaImpl(Session session) {
        this.session = session;
    }

    @Override
    public boolean insert(Mahasiswa m) {
       try {
           session.beginTransaction();
           String nim = (String) session.save(m);
           session.getTransaction().commit();
           return nim != null;
       } catch (Exception e) {
           Logger.getLogger(MahasiswaImpl.class.getName()).log(Level.SEVERE, null, e);
           session.getTransaction().rollback();
       } finally {
           session.close();
       }
       return false;
    }

    @Override
    public boolean update(Mahasiswa m) {
        try {
            session.beginTransaction();
            session.update(m);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(MahasiswaImpl.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Mahasiswa m) {
        try {
            session.beginTransaction();
            session.delete(m);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(MahasiswaImpl.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public Mahasiswa getMahasiswaByNim(String nim) {
        try {
            Query query = session.createQuery("FROM Mahasiswa m WHERE m.nim=:nim");
            query.setParameter("nim", nim);
            return (Mahasiswa) ((org.hibernate.query.Query) query).uniqueResult();
        } catch (Exception e) {
            Logger.getLogger(MahasiswaImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Mahasiswa> getAllMahasiswa() {
        try {
            return session.createQuery("FROM Mahasiswa", Mahasiswa.class).list();
        } catch (Exception e) {
            Logger.getLogger(MahasiswaImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            session.close();
        }
        return null;
    }
}
