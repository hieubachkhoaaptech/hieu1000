/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AdminDAOImpl;
import DAO.CatelogDAOImpl;
import DAO.ColorDAOImpl;
import DAO.CustomerDAOImpl;
import DAO.OrderDAOImpl;
import entities.Admin;
import entities.Catelog;
import entities.Color;
import entities.Customer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
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
public class AdminController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String login(HttpSession session, Model m) {
        if (session == null || session.getAttribute("admin") == null) {
            return "Admin/login";
        }
        return "Admin/home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String adminHome(@RequestParam("username") String userName, @RequestParam("password") String passWord, HttpSession session, Model m) {
        Admin admin = new AdminDAOImpl().login(userName);
        if (admin != null && admin.getPassword().equals(passWord)) {
            session.setAttribute("admin", admin);
            return "redirect:home.htm";
        } else {
            m.addAttribute("message", "Tài khoản hoặc mật khẩu không đúng");
            return "redirect:home.htm";
        }
    }

    @RequestMapping(value = "/Admin")
    public String listAdmin(Model model) {
        model.addAttribute("listAdmin", new AdminDAOImpl().getAll());
        return "/Admin/admin";
    }

    @RequestMapping(value = "/updateAdmin", method = RequestMethod.GET)
    public String initUpdateCatelog(@RequestParam("adminId") int id, Model model) {
        Admin adDao = new AdminDAOImpl().getAdminById(id);
        model.addAttribute("upAdmin", adDao);
        return "Admin/UpdateAdmin";
    }

    @RequestMapping(value = "/saveUpdateAdmin", method = RequestMethod.POST)
    public String saveUpdateColor(@ModelAttribute("upAdmin") Admin admin, Model model) {
        AdminDAOImpl adminDao = new AdminDAOImpl();
        boolean result = adminDao.updateInforAdmin(admin);
        if (result) {
            return "redirect:Admin.htm";
        } else {
            return "redirect:updateAdmin.htm";

        }

    }
//    @RequestMapping(value = "/home")
//    public String login(HttpSession session, Model model) {
//        if (session == null || session.getAttribute("admin") == null) {
//            return "Admin/login";
//        }
//        return "Admin/home";
//    }
//    @RequestMapping(value = "login")
//    public String loginBackend(@ModelAttribute("admin") Admin admin, ModelMap mm, HttpSession session) {
//        Admin result = new Admin();
//        result = new AdminDAOImpl().checkLogin(admin);
//        if (result != null) {
//            session.setAttribute("user", result.getUserName());
//            return "redirect:home.htm";
//        } else {
//            mm.put("message", "Sai thông tin đăng nhập.");
//            return "/Admin/login";
//        }
//    }

    @RequestMapping(value = "/detailAdmin")
    public String detailAdmin(@RequestParam("adminId") int id, Model model) {
        Admin adDao = new AdminDAOImpl().getAdminById(id);
        model.addAttribute("ad", adDao);
        return "Admin/DetailAdmin";
    }

//    @RequestMapping(value = "/Cus")
//    public String listCustomer(Model model) {
//        model.addAttribute("listCustomer", new CustomerDAOImpl().getAllCustomer());
//        return "Admin/customer";
//    }
    @RequestMapping(value = "/detailCustomer")
    public String detailCustomer(@RequestParam("customerId") int id, Model model) {
        Customer cusDao = new CustomerDAOImpl().getCusById(id);
        model.addAttribute("cus", cusDao);
        return "Admin/DetailCustomer";
    }

    @RequestMapping(value = "/Customer")
    public String customerPage(Model m, HttpSession session) {
        if (session.getAttribute("admin") == null) {
            return "redirect:/Admin/customer.htm";
        } else {
            List<Customer> list = new CustomerDAOImpl().getAllCustomer();
            m.addAttribute("listCustomer", list);
            return "Admin/customer";
        }
    }

    @RequestMapping(value = "/Order")
    public String listOrder(Model model
    ) {
        model.addAttribute("listOrder", new OrderDAOImpl().getAllOrder());
        return "Admin/order";
    }

    @RequestMapping(value = "/home")
    public String homeAdmin() {
        return "Admin/home";
    }

    @RequestMapping(value = "/logout")
    public String logout(Model model, HttpSession session
    ) {
        session.removeAttribute("admin");
        model.addAttribute("admin", new Admin());
        return "/Admin/login";
    }
}
