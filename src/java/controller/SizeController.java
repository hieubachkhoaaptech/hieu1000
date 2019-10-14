/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.SizeDAOImpl;
import entities.Size1;
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
public class SizeController {

    @RequestMapping(value = "/Size")
    public String listSize(Model model) {
        model.addAttribute("listSize", new SizeDAOImpl().getAllSize());
        return "Admin/size";
    }

    @RequestMapping(value = "/initNewSize")
    public String initNewSize(Model model) {
        Size1 size = new Size1();
        model.addAttribute("size", size);
        return "Admin/InsertSize";
    }

    @RequestMapping(value = "/insertSize", method = RequestMethod.POST)
    public String insertSize(ModelMap model, @ModelAttribute("size") Size1 size) {
        SizeDAOImpl sizeDao = new SizeDAOImpl();
        boolean result = sizeDao.insertSize(size);
        if (result) {
            return "redirect:Size.htm";
        } else {
            model.put("message", "Error");
            return "redirect:initNewSize.htm";
        }
    }

    //thêm với phương thức get
    @RequestMapping(value = "/updateSize", method = RequestMethod.GET)
    public String initUpdateColor(@RequestParam("sizeId") int id, Model model) {
        Size1 sizeDao = new SizeDAOImpl().getSizeById(id);
        model.addAttribute("upSize", sizeDao);
        return "Admin/UpdateSize";
    }

    //thêm với phương thức get
    @RequestMapping(value = "/saveUpdateSize", method = RequestMethod.POST)
    public String saveUpdateColor(@ModelAttribute("upSize") Size1 size, Model model) {
        SizeDAOImpl sizeDao = new SizeDAOImpl();
        boolean result = sizeDao.updateSize(size);
        if (result) {
            return "redirect:Size.htm";
        } else {
            return "redirect:updateSize.htm";

        }
    }
    //thêm với phương thức get

    @RequestMapping(value = "/detailSize")
    public String detailSize(@RequestParam("sizeId") int id, Model model) {
        Size1 sizeDao = new SizeDAOImpl().getSizeById(id);
        model.addAttribute("si", sizeDao);
        return "Admin/DetailSize";
    }
}
