/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Size1;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface SizeDAO {

    public List<Size1> getAllSize();

    public boolean insertSize(Size1 size);

    public boolean updateSize(Size1 size);

    public Size1 getSizeById(int id);
}
