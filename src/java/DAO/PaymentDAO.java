/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Payment;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface PaymentDAO {

    public List<Payment> getAll();

    public boolean insertPay(Payment pay);

    public boolean updatePay(Payment pay);

    public boolean deletePay(int id);

    public Payment getPaymentById(int id);
}
