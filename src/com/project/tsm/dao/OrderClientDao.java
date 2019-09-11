/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.tsm.dao;

import com.project.tsm.model.OrderClient;

/**
 *
 * @author Ahmad Dudayef
 */
public interface OrderClientDao {
    
    public void saveNewOrder(OrderClient orderClient);
}
