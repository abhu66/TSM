/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.tsm.base.daoImpl;

import com.project.tsm.base.ConnectionMYSQL;
import com.project.tsm.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.project.tsm.dao.UserDao;

/**
 *
 * @author Osvaldo Erens
 */
public class UserDaoImpl implements UserDao{
    
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private final Connection connection = ConnectionMYSQL.getConnection();

    @Override
    public User login(String username, String password) {
         User login = null;
        try {
            st = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM User").append(" where username = '").append(username)
                    .append("'").append(" and password = md5('")
                    .append(password).append("')");
            rs = st.executeQuery(sb.toString());
            if(rs.next()){
                login = new User();
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
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return login;
    }
    
}
