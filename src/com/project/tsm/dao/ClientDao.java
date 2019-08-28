/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.tsm.dao;

import com.project.tsm.model.Client;
import java.util.List;

/**
 *
 * @author Ahmad Dudayef
 */
public interface ClientDao {
    
    public void saveClient(Client client);
    public List<Client> getAllClient(String param);
    public Client findClientById(String id);
    public void updateClient(Client client);
    public void deleteClient(Client client);
}
