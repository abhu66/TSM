/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.tsm.base.daoImpl;

import com.project.tsm.base.ConnectionMYSQL;
import com.project.tsm.dao.OrderClientDao;
import com.project.tsm.model.OrderClient;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmad Dudayef
 */
public class OrderClientDaoImpl implements OrderClientDao{

    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private final Connection connection = ConnectionMYSQL.getConnection();
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    
    @Override
    public void saveNewOrder(OrderClient orderClient) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            String sqlSaveNewOrder = "INSERT INTO OrderClient values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(sqlSaveNewOrder);
            ps.setInt(1, orderClient.getProject_number());
            ps.setDate(2, (Date) orderClient.getDate_order());
            ps.setInt(3, orderClient.getClient_id());
            ps.setString(4, orderClient.getOrder_type());
            ps.setString(5, orderClient.getLanguange());
            ps.setString(6, orderClient.getFile_name());
            ps.setString(7, orderClient.getQty_type());
            ps.setString(8, orderClient.getQty_value());
            ps.setString(9, orderClient.getRate_type());
            ps.setString(10, orderClient.getRate_value());
            ps.setString(11, orderClient.getDeadline_client_type());
            ps.setString(12, orderClient.getDeadline_client_value());
            ps.setInt(13, orderClient.getTranslator_id());
            ps.setString(14, orderClient.getTranslator_deadline_type());
            ps.setString(15, orderClient.getTranslator_deadline_value());
            ps.setString(16, orderClient.getStatus());
            ps.setDate(17, (Date) orderClient.getCreatedDate());
            ps.setDate(18, (Date) orderClient.getUpdatedDate());
            ps.setString(19, orderClient.getCreatedBy());
            ps.setString(20, orderClient.getUpdatedBy());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderClientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
