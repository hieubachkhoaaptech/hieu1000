/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CatelogDAOImpl;
import DAO.ColorDAOImpl;
import DAO.CustomerDAOImpl;
import DAO.OrderDetailDAOImpl;
import DAO.ProductDAOImpl;
import DAO.ProviderDAOImpl;
import DAO.SizeDAOImpl;
import entities.Customer;
import entities.OrderDetail;
import entities.Product;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import javax.ws.rs.QueryParam;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Guest
 */
@Controller
@RequestMapping(value = "/client")
public class FrontendController {

    @RequestMapping(value = "/home")
    public String homeClient(Model model) {

        model.addAttribute("listProduct", new ProductDAOImpl().getAllProduct());
        model.addAttribute("listCatelog", new CatelogDAOImpl().getAll());
        model.addAttribute("listProvider", new ProviderDAOImpl().getAllProvider());
        return "Frontend/home";
    }

    @RequestMapping(value = "/About")
    public String About() {
        return "Frontend/about";
    }

    @RequestMapping(value = "/cusDetail")
    public String cusDetail(Model m, @RequestParam("cusId") int id) {
        Customer c = new CustomerDAOImpl().getCusById(id);
        m.addAttribute("c", c);
        return "Frontend/CusDetail";
    }

    @RequestMapping(value = "/Contact")
    public String Contact() {
        return "Frontend/contact";
    }

    @RequestMapping(value = "/Register")
    public String Register(Model m) {
        m.addAttribute("c", new Customer());
        return "Frontend/register";
    }

    @RequestMapping(value = "/initupdateCustomer")
    public String initupdateCustomer(@RequestParam("cusId") int id, Model m) {
        Customer c = new CustomerDAOImpl().getCusById(id);
        m.addAttribute("upCus", c);
        return "Frontend/updateCus";
    }

    @RequestMapping(value = "/saveUpdateCus")
    public String saveupdateCus(@ModelAttribute("upCus") Customer c) {
        CustomerDAOImpl cusDao = new CustomerDAOImpl();
        boolean result = cusDao.updateCus(c);
        if (result) {
            return "redirect:cusDetail.htm";
        } else {
            return "redirect:initupdateCustomer.htm";
        }
    }

    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public String registry(@ModelAttribute("c") Customer cus, Model m) {
        List<Customer> list = new CustomerDAOImpl().getAllCustomer();
        for (Customer list1 : list) {
            if (cus.getUserName().equals(list1.getUserName())) {
                m.addAttribute("check", "Tên đăng nhập bị trùng");
                return "Frontend/register";
            }
        }
        boolean bl = new CustomerDAOImpl().insertCus(cus);
        if (bl) {
            return "redirect:Login.htm";
        } else {
            m.addAttribute("status", "đăng ký không thành công");
            return "redirect:Register.htm";
        }
    }

    @RequestMapping(value = "/Carts")
    public String orderDetail(Model model) {
        model.addAttribute("listOrderDetail", new OrderDetailDAOImpl().getAllOrderDetail());
        return "Frontend/carts";
    }

    @RequestMapping(value = "/Checkout")
    public String Checkout(Model model) {
        return "Frontend/checkout";
    }

    @RequestMapping(value = "/ShowPro")
    public String ShowPro(Model model) {
        model.addAttribute("listProduct", new ProductDAOImpl().getAllProduct());
        model.addAttribute("listCatelog", new CatelogDAOImpl().getAll());
        model.addAttribute("listProvider", new ProviderDAOImpl().getAllProvider());
        return "Frontend/showProduct";
    }

    @RequestMapping(value = "/loginClient", method = RequestMethod.POST)
    public String clientHome(@RequestParam("username") String userName, @RequestParam("password") String passWord, HttpSession session, Model m) {
        Customer cus = new CustomerDAOImpl().login(userName);
        if (cus != null && cus.getPassword().equals(passWord)) {
            session.setAttribute("frontend", cus);
            session.setAttribute("idCus", cus.getCustomerId());
            session.setAttribute("nameCus", cus.getCustomerName());
            return "redirect:home.htm";
        } else {
            m.addAttribute("status", "Tài khoản hoặc mật khẩu không đúng");
            return "redirect:home.htm";
        }
    }

    @RequestMapping(value = "/Logout", method = RequestMethod.GET)
    public String logout(Model m, HttpSession session) {
        session.removeAttribute("frontend");
        session.removeAttribute("idCus");
        session.removeAttribute("nameCus");
        session.removeAttribute("cart");
        return "redirect:home.htm";
    }

    @RequestMapping(value = "/catelog")
    public String getProByCatelogId(Model model, @RequestParam("catelogId") int id) {
        model.addAttribute("listCatelog", new CatelogDAOImpl().getAll());
        model.addAttribute("listProduct", new ProductDAOImpl().getProductByCatelog(id));
        return "Frontend/showProduct";
    }

    @RequestMapping(value = "/provider")
    public String getProByProviderId(Model model, @RequestParam("providerId") int id) {
        model.addAttribute("listProvider", new ProviderDAOImpl().getAllProvider());
        model.addAttribute("listProduct", new ProductDAOImpl().getProductByCatelog(id));
        return "Frontend/showProduct";
    }

    @RequestMapping(value = "/searchPro")
    public String getProByName(Model model, @RequestParam("productName") String name) {
        model.addAttribute("listProduct", new ProductDAOImpl().getProductByName(name));
        model.addAttribute("listCatelog", new CatelogDAOImpl().getAll());
        model.addAttribute("listProvider", new ProviderDAOImpl().getAllProvider());
        return "Frontend/showProduct";
    }

    @RequestMapping(value = "/detailPro")
    public String detailPro(@RequestParam("productId") int id, Model m, HttpSession session) {
        Product p = new ProductDAOImpl().getProductById(id);
        m.addAttribute("p", p);
        m.addAttribute("s", new SizeDAOImpl().getAllSize());
        m.addAttribute("c", new ColorDAOImpl().getAllColor());
        return "Frontend/productDetail";
    }

    @RequestMapping(value = "/Login")
    public String Login(HttpSession session) {
        if (session == null || session.getAttribute("frontend") == null) {
            return "Frontend/login";
        }
        return "Frontend/login";
    }

    @RequestMapping(value = "/addCart")
    public String cartPage(@RequestParam("productId") int id, @RequestParam("quantity") int quantity, Model m, HttpSession session) {
//        if (session == null || session.getAttribute("frontend") == null) {
//            return "redirect:Login.htm";
//        } else {
        if (session.getAttribute("cart") == null) {
            List cart = new ArrayList();
            cart.add(new OrderDetail(quantity, new ProductDAOImpl().getProductById(id)));
            session.setAttribute("cart", cart);
        } else {
            List<OrderDetail> cart = (List) session.getAttribute("cart");
            int index = isExisting(id, session);
            if (index == -1) {
                cart.add(new OrderDetail(1, new ProductDAOImpl().getProductById(id)));
            } else {
                int quantitys = cart.get(index).getQuantity() + quantity;
                cart.get(index).setQuantity(quantitys);
            }
            session.setAttribute("cart", cart);
        }
        return "Frontend/carts";
//        }

    }

    private int isExisting(int id, HttpSession session) {
        List<OrderDetail> cart = (List) session.getAttribute("cart");
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProductId().getProductId() == id) {
                return i;
            }
        }
        return -1;
    }

    @RequestMapping(value = "/deleteCart")
    public String deletecart(@RequestParam("id") int id, Model m, HttpSession session) {
        List<OrderDetail> cart = (List) session.getAttribute("cart");
        int index = isExisting(id, session);
        cart.remove(index);
        session.setAttribute("cart", cart);
        return "Frontend/carts";
    }

    @RequestMapping(value = "/updateCart")
    public String updateCart(HttpSession session, HttpServletRequest request) {
        List<OrderDetail> lstCart = (List<OrderDetail>) session.getAttribute("cart");
        String[] arrQuantity = request.getParameterValues("quantity");
        for (int i = 0; i < lstCart.size(); i++) {
            lstCart.get(i).setQuantity(Integer.parseInt(arrQuantity[i]));
            if (Integer.parseInt(arrQuantity[i]) < 1) {
                lstCart.get(i).setQuantity(1);
            }
        }
        session.setAttribute("cart", lstCart);
        return "Frontend/carts";
    }
}
