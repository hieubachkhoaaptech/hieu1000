/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Provider;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class ProviderDAOImpl implements ProviderDAO {

    private Session session;

    @Override
    public List<Provider> getAllProvider() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("from Provider").list();
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
    public boolean insertProvider(Provider pro) {
        boolean bl = false;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.save(pro);
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
    public boolean updateProvider(Provider pro) {
        boolean bl = false;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.merge(pro);
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
    public Provider getProviderById(int idProvider) {
        Provider p = new Provider();
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Provider where ProviderId=:providerId").setParameter("providerId", idProvider);
            p = (Provider) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return p;
    }

}
