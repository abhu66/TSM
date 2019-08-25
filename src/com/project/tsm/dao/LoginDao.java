/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.tsm.dao;

import com.project.tsm.model.Login;

/**
 *
 * @author Osvaldo Erens
 */
public interface LoginDao{
    
    public Login login(String username, String password);
}
