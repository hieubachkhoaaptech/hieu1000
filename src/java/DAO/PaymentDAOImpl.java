/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Payment;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class PaymentDAOImpl implements PaymentDAO {

    private Session session;

    @Override
    public List<Payment> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("from Payment").list();
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
    public boolean insertPay(Payment pay) {
        boolean bl = false;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.save(pay);
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
    public boolean updatePay(Payment pay) {
        boolean bl = false;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.merge(pay);
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
    public boolean deletePay(int id) {
        boolean bl = false;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Payment pa = getPaymentById(id);
            if (pa != null) {
                bl = true;
                session.delete(pa);
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
    public Payment getPaymentById(int id) {
        Payment paym = new Payment();
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Payment where PaymentId=:paymentId").setParameter("paymentId", id);
            paym = (Payment) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return paym;
    }

}
