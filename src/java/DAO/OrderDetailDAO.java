/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.OrderDetail;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface OrderDetailDAO {
    public List<OrderDetail> getAllOrderDetail();

    public boolean updateOrderD(OrderDetail orderD);

    public boolean insertOrderD(OrderDetail orderD);

    public boolean deleteOrderD(int id);

    public OrderDetail getOrderDetailById(int id);
}
