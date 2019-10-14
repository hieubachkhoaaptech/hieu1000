/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Product;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class ProductDAOImpl implements ProductDAO {

    private Session session;

    @Override
    public List<Product> getAllProduct() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("from Product where Status = true").list();
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
    public boolean insertProduct(Product pro) {
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
    public boolean updateProduct(Product pro) {
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
    public boolean deleteProduct(int idPro) {
        boolean bl = false;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("update Product set Status = false where ProductId=:productId").setParameter("productId", idPro);
            Product p = (Product) query.uniqueResult();
            if (p != null) {
                bl = true;
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
    public Product getProductById(int idPro) {
        Product pro = new Product();
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Product where ProductId=:productId").setParameter("productId", idPro);
            pro = (Product) query.uniqueResult();
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
    public List getProductByCatelog(int id) {
        List list = new ArrayList();
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            list = session.createQuery("from Product where catelogId.catelogId=:catelogId").setParameter("catelogId", id).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return list;
    }

    @Override
    public List<Product> getProductByName(String name) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        

        try {
        List<Product>    list = session.createQuery("from Product where productName like '%'+ :productName +'%'")
                    .setParameter("productName", name).list();
            session.getTransaction().commit();
             return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
 return null;
       
    }

}
