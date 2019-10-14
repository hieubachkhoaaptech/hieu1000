/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Provider;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ProviderDAO {

    public List<Provider> getAllProvider();

    public boolean insertProvider(Provider pro);

    public boolean updateProvider(Provider pro);

//    public boolean deleteProvider(int id);
    public Provider getProviderById(int id);
}
