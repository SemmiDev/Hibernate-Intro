package com.sam.demo.util;

import com.sam.demo.dao.MahasiswaDao;
import com.sam.demo.dao.MahasiswaImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static MahasiswaDao mahasiswaDao;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml)
            // config file.
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception.
            Logger.getLogger(HibernateUtil.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static MahasiswaDao getMahasiswaDao() {
        if (mahasiswaDao == null) {
            mahasiswaDao = new MahasiswaImpl(getSessionFactory().openSession());
        }
        return mahasiswaDao;
    }
    private static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown(){
        try {
            sessionFactory.close();
        } catch (HibernateException e) {
            Logger.getLogger(HibernateUtil.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
