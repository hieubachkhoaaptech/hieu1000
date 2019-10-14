/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Catelog;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CatelogDAO {

    public List<Catelog> getAll();

    public boolean insertCatelog(Catelog cate);

    public boolean updateCatelog(Catelog cate);

    public boolean deleteCatelog(int id);

    public Catelog getCatelogById(int id);
}
