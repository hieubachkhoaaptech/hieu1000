/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProviderDAOImpl;
import entities.Provider;
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
public class ProviderController {

    @RequestMapping(value = "/Provider", method = RequestMethod.GET)
    public String listProvider(Model model) {
        model.addAttribute("listProvider", new ProviderDAOImpl().getAllProvider());
        return "Admin/provider";
    }

    @RequestMapping(value = "/initNewProvider")
    public String initNewProvider(Model model) {
        Provider provi = new Provider();
        model.addAttribute("provider", provi);
        return "Admin/InsertProvider";
    }

    //thêm với phương thức post
    @RequestMapping(value = "/insertProvider", method = RequestMethod.POST)
    public String insertProvider(Model model, @ModelAttribute("provider") Provider provider) {
        ProviderDAOImpl proviDao = new ProviderDAOImpl();
        boolean result = proviDao.insertProvider(provider);
        if (result) {
            return "redirect:Provider.htm";
        } else {
            return "redirect:initNewProvider.htm";
        }
    }

    //thêm với phương thức get
    @RequestMapping(value = "/updateProvider", method = RequestMethod.GET)
    public String initUpdateProvider(@RequestParam("providerId") int id, Model model) {
        Provider proviDao = new ProviderDAOImpl().getProviderById(id);
        model.addAttribute("upProvider", proviDao);
        return "Admin/UpdateProvider";
    }

    //thêm với phương thức get
    @RequestMapping(value = "/saveUpdateProvider", method = RequestMethod.POST)
    public String saveUpdateProvider(@ModelAttribute("upProvider") Provider provider, Model model) {
        ProviderDAOImpl providerDao = new ProviderDAOImpl();
        boolean result = providerDao.updateProvider(provider);
        if (result) {
            return "redirect:Provider.htm";
        } else {
            return "redirect:updateProvider.htm";

        }
    }

    @RequestMapping(value = "detailProvider")
    public String detailProvider(@RequestParam("providerId") int id, Model model) {
        Provider provi = new ProviderDAOImpl().getProviderById(id);
        model.addAttribute("prov", provi);
        return "Admin/DetailProvider";
    }
}
