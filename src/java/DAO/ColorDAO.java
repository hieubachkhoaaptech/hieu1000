/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Color;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ColorDAO {

    public List<Color> getAllColor();

    public boolean insertColor(Color color);

    public boolean updateColor(Color color);

    public Color getColorById(int id);
}
