/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CatelogDAOImpl;
import DAO.ProductDAOImpl;
import DAO.ProviderDAOImpl;
import entities.Product;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
 * @author Admin
 */
@Controller
public class ProductController {

    @RequestMapping(value = "/Product", method = RequestMethod.GET)
    public String listProduct(Model model) {
        model.addAttribute("listProduct", new ProductDAOImpl().getAllProduct());
        return "Admin/product";
    }

    @RequestMapping(value = "/initNewProduct", method = RequestMethod.GET)
    public String initNewProduct(Model model) {
        Product p = new Product();
        model.addAttribute("p", p);
        model.addAttribute("listProvider", new ProviderDAOImpl().getAllProvider());
        model.addAttribute("listCatelog", new CatelogDAOImpl().getAll());
        return "Admin/InsertProduct";
    }

    @RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
    public String insertProduct(Model model, @ModelAttribute("p") Product pro, HttpServletRequest request) {
        ProductDAOImpl productDao = new ProductDAOImpl();
        String path = request.getRealPath("/jsp/Admin/images");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\jsp\\Admin\\images";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        try {
            List<FileItem> lst = uploader.parseRequest(request);
            for (FileItem fileItem : lst) {
                if (fileItem.isFormField() == false) {
                    pro.setImages(fileItem.getName());
                    fileItem.write(new File(path + "/" + fileItem.getName()));
                } else {
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString();
                    if (name.equals("productName")) {
                        pro.setProductName(new String(value.getBytes("iso-8859-1"), "UTF-8"));
                    } else if (name.equals("catelogId")) {
                        pro.setCatelogId(new CatelogDAOImpl().getCatelogById(Integer.parseInt(value)));
                    } else if (name.equals("providerId")) {
                        pro.setProviderId(new ProviderDAOImpl().getProviderById(Integer.parseInt(value)));
                    } else if (name.equals("quantity")) {
                        pro.setQuantity(Integer.parseInt(value));
                    } else if (name.equals("price")) {
                        pro.setPrice(Double.parseDouble(value));
                    } else if (name.equals("images")) {
                        pro.setImages(value);
                    } else if (name.equals("status")) {
                        pro.setStatus(Boolean.parseBoolean(value));
                    } else if (name.equals("descriptions")) {
                        pro.setDescriptions(new String(value.getBytes("iso-8859-1"), "UTF-8"));
                    }
                }
            }
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            pro.setCreateDate(date);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        boolean result = productDao.insertProduct(pro);
        if (result) {
            return "redirect:Product.htm";
        } else {
            return "redirect:initNewProduct.htm";
        }
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
    public String initUpdateProduct(@RequestParam("productId") int id, Model model) {
        Product proDao = new ProductDAOImpl().getProductById(id);
        model.addAttribute("upProduct", proDao);
        model.addAttribute("listCatelog", new CatelogDAOImpl().getAll());
        model.addAttribute("listProvider", new ProviderDAOImpl().getAllProvider());
        return "Admin/UpdateProduct";
    }

    @RequestMapping(value = "/saveUpdateProduct", method = RequestMethod.POST)
    public String saveUpdateProduct(Model model, @ModelAttribute("upProduct") Product pro, HttpServletRequest request) {
        ProductDAOImpl productDao = new ProductDAOImpl();
        String path = request.getRealPath("/jsp/Admin/images");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\jsp\\Admin\\images";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        try {
            List<FileItem> lst = uploader.parseRequest(request);
            for (FileItem fileItem : lst) {
                if (fileItem.isFormField() == false) {
                    pro.setImages(fileItem.getName());
                    fileItem.write(new File(path + "/" + fileItem.getName()));
                } else {
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString();
                    if (name.equals("productName")) {
                        pro.setProductName(new String(value.getBytes("iso-8859-1"), "UTF-8"));
                    } else if (name.equals("catelogId")) {
                        pro.setCatelogId(new CatelogDAOImpl().getCatelogById(Integer.parseInt(value)));
                    } else if (name.equals("providerId")) {
                        pro.setProviderId(new ProviderDAOImpl().getProviderById(Integer.parseInt(value)));
                    } else if (name.equals("quantity")) {
                        pro.setQuantity(Integer.parseInt(value));
                    } else if (name.equals("price")) {
                        pro.setPrice(Double.parseDouble(value));
                    } else if (name.equals("images")) {
                        pro.setImages(value);
                    } else if (name.equals("status")) {
                        pro.setStatus(Boolean.parseBoolean(value));
                    } else if (name.equals("descriptions")) {
                        pro.setDescriptions(new String(value.getBytes("iso-8859-1"), "UTF-8"));
                    }
                }
            }
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            pro.setCreateDate(date);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        boolean result = productDao.updateProduct(pro);
        if (result) {
            return "redirect:Product.htm";
        } else {
            return "redirect:updateProduct.htm";
        }
    }

    @RequestMapping(value = "/detailProduct")
    public String detailProduct(@RequestParam("productId") int id, Model model) {
        Product proDao = new ProductDAOImpl().getProductById(id);
        model.addAttribute("pro", proDao);
        model.addAttribute("listCatelog", new CatelogDAOImpl().getAll());
        model.addAttribute("listProvider", new ProviderDAOImpl().getAllProvider());
        return "Admin/DetailProduct";
    }
}
