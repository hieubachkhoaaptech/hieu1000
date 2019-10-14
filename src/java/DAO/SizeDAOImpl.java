/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Size1;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */ 
public class SizeDAOImpl implements SizeDAO {

    private Session session;

    @Override
    public List<Size1> getAllSize() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("from Size1").list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }

    @Override
    public boolean insertSize(Size1 size) {
        boolean bl = false;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.save(size);
            session.getTransaction().commit();
            session.close();
            return bl = true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return bl;
    }

    @Override
    public boolean updateSize(Size1 size) {
        boolean bl = false;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.merge(size);
            session.getTransaction().commit();
            session.close();
            return bl = true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return bl;
    }

    @Override
    public Size1 getSizeById(int id) {
        Size1 si = new Size1();
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Size1 where SizeId=:sizeId").setParameter("sizeId", id);
            si = (Size1) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return si;
    }

}
