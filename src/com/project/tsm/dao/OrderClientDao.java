/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.tsm.dao;

import com.project.tsm.model.OrderClient;
import java.util.List;

/**
 *
 * @author Ahmad Dudayef
 */
public interface OrderClientDao {
    
    public void saveNewOrder(OrderClient orderClient);
    public List<OrderClient> getAllOrderClient(String param1, String param2);
    public OrderClient findOrderClientById(String id);
    public void updateOrderClient(OrderClient orderClient);
    public void deleteOrderClient(OrderClient orderClient);
    public String checProjectNumber();
}
