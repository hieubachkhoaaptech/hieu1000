/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PaymentDAOImpl;
import entities.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class PaymentController {

    @RequestMapping(value = "/Payment", method = RequestMethod.GET)
    public String listPayment(Model model) {
        model.addAttribute("listPayment", new PaymentDAOImpl().getAll());
        return "Admin/payment";
    }

    @RequestMapping(value = "/initNewPayment")
    public String initNewPayment(Model model) {
        Payment pa = new Payment();
        model.addAttribute("payment", pa);
        return "Admin/InsertPayment";
    }

    //thêm với phương thức post
    @RequestMapping(value = "/insertPayment", method = RequestMethod.POST)
    public String insertColor(ModelMap model, @ModelAttribute("payment") Payment payment) {
        PaymentDAOImpl payDao = new PaymentDAOImpl();
        boolean result = payDao.insertPay(payment);
        if (result) {
            return "redirect:Payment.htm";
        } else {
            model.put("message", "Error");
            return "redirect:initNewPayment.htm";
        }
    }

    @RequestMapping(value = "/updatePayment")
    public String formupdateP(@RequestParam("paymentId") int id, Model m) {
        Payment p = new PaymentDAOImpl().getPaymentById(id);
        m.addAttribute("upPayment", p);
        return "Admin/UpdatePayment";
    }

    //thêm với phương thức get
    @RequestMapping(value = "/saveUpdatePayment", method = RequestMethod.POST)
    public String saveUpdateColor(@ModelAttribute("upPayment") Payment payment, Model model) {
        PaymentDAOImpl payDao = new PaymentDAOImpl();
        boolean result = payDao.updatePay(payment);
        if (result) {
            return "redirect:Payment.htm";
        } else {
            return "redirect:updatePayment.htm";

        }
    }
    //thêm với phương thức get

    @RequestMapping(value = "/detailPayment")
    public String detailPayment(@RequestParam("paymentId") int id, Model model) {
        Payment payDao = new PaymentDAOImpl().getPaymentById(id);
        model.addAttribute("pay", payDao);
        return "Admin/DetailPayment";
    }

}
