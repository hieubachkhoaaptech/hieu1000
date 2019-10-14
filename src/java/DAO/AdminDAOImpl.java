/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Admin;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class AdminDAOImpl implements AdminDAO {

    private Session session;

    @Override
    public List<Admin> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("from Admin").list();
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
    public Admin login(String userName) {
        Admin admin = new Admin();
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            admin = (Admin) session.createQuery("from Admin where Username=:userName").setParameter("userName", userName).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return admin;
    }

    @Override
    public boolean updateInforAdmin(Admin admin) {
        boolean bl = false;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.merge(admin);
            session.getTransaction().commit();
            bl = true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return bl;
    }

    @Override
    public Admin getAdminById(int id) {
        Admin admin = new Admin();
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Admin where AdminId=:adminId").setParameter("adminId", id);
            admin = (Admin) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return admin;
    }

    public Admin checkLogin(Admin admins) {
        Admin admin = new Admin();
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Admin where UserName=:username and Password=:pass").setParameter("username", admins.getUserName()).setParameter("pass", admins.getPassword());
            admin = (Admin) query.uniqueResult();
            session.close();
            return admin;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }

}
