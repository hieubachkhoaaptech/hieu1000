/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Admin;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface AdminDAO {

    public List<Admin> getAll();

    public Admin login(String userName);

    public boolean updateInforAdmin(Admin admin);

    public Admin getAdminById(int id);
}
