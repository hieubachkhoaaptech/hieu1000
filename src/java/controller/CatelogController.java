/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CatelogDAOImpl;
import entities.Catelog;
import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
public class CatelogController {

    @RequestMapping(value = "/Catelog", method = RequestMethod.GET)
    public String listCatelog(Model model) {
        model.addAttribute("listCatelog", new CatelogDAOImpl().getAll());
        return "Admin/catelog";
    }

    @RequestMapping(value = "/initNewCatelog")
    public String initNewCatelog(Model model) {
        Catelog ca = new Catelog();
        model.addAttribute("catelog", ca);
        return "Admin/InsertCatelog";
    }

    @RequestMapping(value = "/insertCatelog", method = RequestMethod.POST)
    public String insertCatelog(ModelMap model, @ModelAttribute("catelog") Catelog cate, HttpServletRequest request) {
        CatelogDAOImpl cateDao = new CatelogDAOImpl();
        String path = request.getRealPath("/jsp/Admin/images");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\jsp\\Admin\\images";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        try {
            List<FileItem> lst = uploader.parseRequest(request);
            for (FileItem fileItem : lst) {
                if (fileItem.isFormField() == false) {
                    //path
                    cate.setImages(fileItem.getName());
                    //upload to folder
                    fileItem.write(new File(path + "/" + fileItem.getName()));
                } else {
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString();
                    if (name.equals("catelogName")) {
                        cate.setCatelogName(new String(value.getBytes("iso-8859-1"), "UTF-8"));
                    } else if (name.equals("images")) {
                        cate.setImages(value);
                    } else if (name.equals("descriptions")) {
                        cate.setDescriptions(new String(value.getBytes("iso-8859-1"), "UTF-8"));
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        boolean result = cateDao.insertCatelog(cate);
        if (result) {
            return "redirect:Catelog.htm";
        } else {
            model.put("message", "Eror");
            return "redirect:initNewCatelog.htm";
        }
    }

    @RequestMapping(value = "/updateCatelog", method = RequestMethod.GET)
    public String initUpdateCatelog(@RequestParam("catelogId") int id, Model model) {
        Catelog cateDao = new CatelogDAOImpl().getCatelogById(id);
        model.addAttribute("upCatelog", cateDao);
        return "Admin/UpdateCatelog";
    }

    @RequestMapping(value = "/saveUpdateCatelog", method = RequestMethod.POST)
    public String saveUpdateCatelog(@ModelAttribute("upCatelog") Catelog cate, Model model, HttpServletRequest request) {
        CatelogDAOImpl upcateDao = new CatelogDAOImpl();
        String path = request.getRealPath("/jsp/Admin/images");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\jsp\\Admin\\images";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        try {
            List<FileItem> lst = uploader.parseRequest(request);
            for (FileItem fileItem : lst) {
                if (fileItem.isFormField() == false) {
                    //path
                    cate.setImages(fileItem.getName());
                    //upload to folder
                    fileItem.write(new File(path + "/" + fileItem.getName()));
                } else {
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString();
                    if (name.equals("catelogName")) {
                        cate.setCatelogName(new String(value.getBytes("iso-8859-1"), "UTF-8"));
                    } else if (name.equals("images")) {
                        cate.setImages(value);
                    } else if (name.equals("descriptions")) {
                        cate.setDescriptions(new String(value.getBytes("iso-8859-1"), "UTF-8"));
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        boolean result = upcateDao.updateCatelog(cate);
        if (result) {
            return "redirect:Catelog.htm";
        } else {
            return "redirect:updateCatelog.htm";
        }
    }

    @RequestMapping(value = "/detailCatelog")
    public String detailCatelog(@RequestParam("catelogId") int id, Model model) {
        Catelog cateDao = new CatelogDAOImpl().getCatelogById(id);
        model.addAttribute("ca", cateDao);
        return "Admin/DetailCatelog";
    }
}
