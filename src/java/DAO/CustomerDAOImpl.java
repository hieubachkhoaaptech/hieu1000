/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Customer;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class CustomerDAOImpl implements CustomerDAO {

    private Session session;

    public CustomerDAOImpl() {
        session = DAO.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    @Override
    public List<Customer> getAllCustomer() {
        session = DAO.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            List<Customer> list = session.createQuery("from Customer").list();
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
    public boolean insertCus(Customer customer) {
        boolean bl = false;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.save(customer);
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
    public boolean updateCus(Customer customer) {
        boolean bl = false;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.merge(customer);
            session.getTransaction().commit();
            bl = true;
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return bl;

    }

    @Override
    public boolean deleteCus(int id) {
        boolean bl = false;

        try {
            int i = session.createQuery("delete from Customer where cusId = :cusId")
                    .setParameter("cusId", id).executeUpdate();
            session.getTransaction().commit();
            if (i > 0) {
                bl = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return bl;

    }

    @Override
    public Customer getCusById(int id) {
        Customer pro = null;

        try {
            pro = (Customer) session.createQuery("from Customer where CustomerId = :customerId")
                    .setParameter("customerId", id).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return pro;
    }

    @Override
    public Customer login(String username) {
        Customer cus = new Customer();

        try {
            Query query = session.createQuery("from Customer where UserName=:username").setParameter("username", username);
            cus = (Customer) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cus;
    }
}
