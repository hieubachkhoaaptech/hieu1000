/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Orders;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface OrderDAO {

    public List<Orders> getAllOrder();

    public boolean updateOrder(Orders order);

    public boolean insertOrder(Orders order);

    public boolean deleteOrder(int id);

    public Orders getOrderById(int id);
}
