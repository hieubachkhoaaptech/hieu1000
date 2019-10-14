/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Product;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ProductDAO {

    public List<Product> getAllProduct();

    public boolean insertProduct(Product pro);

    public boolean updateProduct(Product pro);

    public boolean deleteProduct(int idPro);

    public Product getProductById(int idPro);

    public List getProductByCatelog(int id);

    public List getProductByName(String name);
}
