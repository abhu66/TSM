/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.tsm.base.daoImpl;

import com.project.tsm.base.ConnectionMYSQL;
import com.project.tsm.dao.LoginDao;
import com.project.tsm.model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Osvaldo Erens
 */
public class LoginDaoImpl implements LoginDao{
    
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection connection = ConnectionMYSQL.getConnection();

    @Override
    public Login login(String username, String password) {
         Login login = null;
        try {
            st = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM Login").append(" where username = '").append(username)
                    .append("'").append(" and password = md5('")
                    .append(password).append("')");
            rs = st.executeQuery(sb.toString());
            if(rs.next()){
                login = new Login();
                login.setId(rs.getInt("id"));
                login.setName(rs.getString("name"));
                login.setUsername(rs.getString("username"));
                login.setPassword(rs.getString("password"));
                login.setRole(rs.getString("role"));
                login.setCreatedDate(rs.getDate("created_date"));
                login.setUpdatedDate(rs.getDate("updated_date"));
                login.setCreatedBy(rs.getString("created_by"));
                login.setUpdatedBy(rs.getString("updated_by")); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return login;
    }
    
}