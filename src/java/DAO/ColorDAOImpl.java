/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Admin;
import entities.Color;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class ColorDAOImpl implements ColorDAO {

    private Session session;

    @Override
    public List<Color> getAllColor() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("from Color").list();
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
    public boolean insertColor(Color color) {
        boolean bl = false;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.save(color);
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

//    public Color checkColor(Color color) {
//        Color co = new Color();
//        session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        try {
//            Query query = session.createQuery("from Color where ColorName=:colorName and Natation=:natation").setParameter("username", color.getColorName()).setParameter("pass", color.getNatation());
//            co = (Color) query.uniqueResult();
//            session.close();
//            return co;
//        } catch (Exception e) {
//            e.printStackTrace();
//            session.getTransaction().rollback();
//            session.close();
//            return null;
//        }
//
//    }

    @Override
    public boolean updateColor(Color color) {
        boolean bl = false;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.merge(color);
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
    public Color getColorById(int idColor) {
        Color c = new Color();
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Color where ColorId=:colorId").setParameter("colorId", idColor);
            c = (Color) query.uniqueResult();
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
