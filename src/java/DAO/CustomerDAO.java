/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Customer;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CustomerDAO {
    public List<Customer> getAllCustomer();
    public boolean insertCus(Customer customer);
    public boolean updateCus(Customer customer);
    public boolean deleteCus(int id);
    public Customer getCusById(int id);
    public Customer login(String userName);
}
