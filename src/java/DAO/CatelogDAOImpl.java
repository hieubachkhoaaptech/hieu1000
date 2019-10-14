/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Catelog;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class CatelogDAOImpl implements CatelogDAO {

    private Session session;

    @Override
    public List<Catelog> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("from Catelog").list();
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
    public boolean insertCatelog(Catelog cate) {
        boolean bl = false;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.save(cate);
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
    public boolean updateCatelog(Catelog cate) {
        boolean bl = false;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.merge(cate);
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
    public boolean deleteCatelog(int id) {
        boolean bl = false;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Catelog c = getCatelogById(id);
            if (c != null) {
                bl = true;
                session.delete(c);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return bl;
    }

    @Override
    public Catelog getCatelogById(int idCatelog) {
        Catelog c = new Catelog();
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Catelog where CatelogId=:catelogId").setParameter("catelogId", idCatelog);
            c = (Catelog) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return c;
    }

}
