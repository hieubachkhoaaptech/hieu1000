/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ColorDAOImpl;
import entities.Color;
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
public class ColorController {

    //lấy tất cả
    @RequestMapping(value = "/Color", method = RequestMethod.GET)
    public String listColor(Model model) {
        model.addAttribute("listColor", new ColorDAOImpl().getAllColor());
        return "Admin/color";
    }

    //thêm với phương thức get
    @RequestMapping(value = "/initNewColor")
    public String initNewColor(Model model) {
        Color co = new Color();
        model.addAttribute("color", co);
        return "Admin/InsertColor";
    }

    //thêm với phương thức post
    @RequestMapping(value = "/insertColor", method = RequestMethod.POST)
    public String insertColor(ModelMap model, @ModelAttribute("color") Color color) {
        ColorDAOImpl coloDao = new ColorDAOImpl();
        boolean result = coloDao.insertColor(color);
        if (result) {
            return "redirect:Color.htm";
        } else {
            model.put("message", "Error");
            return "redirect:initNewColor.htm";
        }
    }

    //thêm với phương thức get
    @RequestMapping(value = "/updateColor", method = RequestMethod.GET)
    public String initUpdateColor(@RequestParam("colorId") int id, Model model) {
        Color colorDao = new ColorDAOImpl().getColorById(id);
        model.addAttribute("upColor", colorDao);
        return "Admin/UpdateColor";
    }

    //thêm với phương thức get
    @RequestMapping(value = "/saveUpdateColor", method = RequestMethod.POST)
    public String saveUpdateColor(@ModelAttribute("upColor") Color color, Model model) {
        ColorDAOImpl colorDao = new ColorDAOImpl();
        boolean result = colorDao.updateColor(color);
        if (result) {
            return "redirect:Color.htm";
        } else {
            return "redirect:updateColor.htm";

        }
    }

    //thêm với phương thức get
    @RequestMapping(value = "/detailColor")
    public String detailColor(@RequestParam("colorId") int id, Model model) {
        Color colorDao = new ColorDAOImpl().getColorById(id);
        model.addAttribute("colo", colorDao);
        return "Admin/DetailColor";
    }

    
}
