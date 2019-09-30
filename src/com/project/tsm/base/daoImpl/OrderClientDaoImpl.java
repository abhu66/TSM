/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.tsm.base.daoImpl;

import com.project.tsm.base.ConnectionMYSQL;
import com.project.tsm.base.GlobalConst;
import com.project.tsm.dao.OrderClientDao;
import com.project.tsm.model.OrderClient;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
            String sqlSaveNewOrder = "INSERT INTO Order_Client values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(sqlSaveNewOrder);
            ps.setInt(1, orderClient.getProject_number());
            ps.setString(2, sdf.format(orderClient.getDate_order()));
            ps.setInt(3, orderClient.getClient_id());
            ps.setString(4, orderClient.getOrder_type());
            ps.setInt(5, orderClient.getLanguange());
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
            ps.setString(17, sdf.format(orderClient.getCreatedDate()));
            ps.setString(18, sdf.format(orderClient.getUpdatedDate()));
            ps.setString(19, orderClient.getCreatedBy());
            ps.setString(20, orderClient.getUpdatedBy());
            ps.executeUpdate();
            GlobalConst.succesAlert("Save Order ! ");
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Save Order ! ");
            Logger.getLogger(OrderClientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<OrderClient> getAllOrderClient(String param1,String param2) {
        List<OrderClient> listOrderClients = new ArrayList<>();
        try {
            String selectOrderClient = "SELECT * FROM Order_Client";
            StringBuilder sb = new StringBuilder();
            
            if(!param1.equalsIgnoreCase("Date Order")){
                if(param2 == null || param2.isEmpty()){
                    sb.append(selectOrderClient);
                    }
                    else {
                        sb.append(selectOrderClient).append(" where project_number like '%").append(param2).append("%'");
                    }
            }
            else {
                
            }
            
            st = connection.createStatement();
            rs = st.executeQuery(sb.toString());
            OrderClient orderClient;
            while(rs.next()){
                orderClient = new OrderClient();
                orderClient.setId(rs.getInt("id"));
                orderClient.setProject_number(rs.getInt("project_number"));
                orderClient.setDate_order(rs.getDate("date_order"));
                orderClient.setClient_id(rs.getInt("client_id"));
                
                orderClient.setOrder_type(rs.getString("order_type"));
                orderClient.setLanguange(rs.getInt("language"));
                orderClient.setFile_name(rs.getString("file_name"));
                orderClient.setQty_type(rs.getString("qty"));
                orderClient.setQty_value(rs.getString("qty_value"));
                orderClient.setRate_type(rs.getString("rate"));
                orderClient.setRate_value(rs.getString("rate_value"));
                orderClient.setDeadline_client_type(rs.getString("deadline_client"));
                orderClient.setDeadline_client_value(rs.getString("deadline_client_value"));
                orderClient.setTranslator_id(rs.getInt("translator_id"));
                orderClient.setTranslator_deadline_type(rs.getString("translator_deadline"));
                orderClient.setTranslator_deadline_value(rs.getString("translator_deadline_value"));
                orderClient.setStatus(rs.getString("status"));
                orderClient.setCreatedDate(rs.getDate("created_date"));
                orderClient.setUpdatedDate(rs.getDate("updated_date"));
                orderClient.setCreatedBy(rs.getString("created_by"));
                orderClient.setUpdatedBy(rs.getString("updated_by"));

                listOrderClients.add(orderClient);
            }
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Load data Order Client "+ex.getMessage());
            Logger.getLogger(OrderClientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOrderClients;
    }

    @Override
    public OrderClient findOrderClientById(String id) {
         OrderClient orderClient = null;
        try {
        String retriveLanguagesById = "SELECT * FROM Order_Client where id = '"+id+"'";
        st = connection.createStatement();
        rs = st.executeQuery(retriveLanguagesById);
            if(rs.next()){
                orderClient = new OrderClient();
                orderClient.setId(rs.getInt("id"));
                orderClient.setProject_number(rs.getInt("project_number"));
                orderClient.setDate_order(rs.getDate("date_order"));
                orderClient.setClient_id(rs.getInt("client_id"));
                
                orderClient.setOrder_type(rs.getString("order_type"));
                orderClient.setLanguange(rs.getInt("language"));
                orderClient.setFile_name(rs.getString("file_name"));
                orderClient.setQty_type(rs.getString("qty"));
                orderClient.setQty_value(rs.getString("qty_value"));
                orderClient.setRate_type(rs.getString("rate"));
                orderClient.setRate_value(rs.getString("rate_value"));
                orderClient.setDeadline_client_type(rs.getString("deadline_client"));
                orderClient.setDeadline_client_value(rs.getString("deadline_client_value"));
                orderClient.setTranslator_id(rs.getInt("translator_id"));
                orderClient.setTranslator_deadline_type(rs.getString("translator_deadline"));
                orderClient.setTranslator_deadline_value(rs.getString("translator_deadline_value"));
                orderClient.setStatus(rs.getString("status"));
                orderClient.setCreatedDate(rs.getDate("created_date"));
                orderClient.setUpdatedDate(rs.getDate("updated_date"));
                orderClient.setCreatedBy(rs.getString("created_by"));
                orderClient.setUpdatedBy(rs.getString("updated_by"));
            }
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Load data languages "+ex.getMessage());
            Logger.getLogger(LanguagesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderClient;
    }

    @Override
    public void updateOrderClient(OrderClient orderClient) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            
            String sqlSaveUpdateOrder = "UPDATE Order_Client SET project_number = ?,"
                    + " date_order = ?, client_id = ?, order_type = ?, language = ?, file_name = ?,"
                    + " qty = ?, qty_value = ?, rate = ?, rate_value = ?, deadline_client = ?,"
                    + " deadline_client_value = ?, translator_id = ?, translator_deadline = ?,"
                    + " translator_deadline_value = ?, status = ?,"
                    + " updated_date = ?, updated_by = ? where id = ? ";
            ps = connection.prepareStatement(sqlSaveUpdateOrder);
            
            ps.setInt(1, orderClient.getProject_number());
            ps.setString(2, sdf.format(orderClient.getDate_order()));
            ps.setInt(3, orderClient.getClient_id());
            ps.setString(4, orderClient.getOrder_type());
            ps.setInt(5, orderClient.getLanguange());
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
            ps.setString(17, sdf.format(orderClient.getUpdatedDate()));
            ps.setString(18, orderClient.getUpdatedBy());
            ps.setInt(19, orderClient.getId());
            ps.executeUpdate();
            GlobalConst.succesAlert("Update Order ! ");
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Update Order ! ");
            Logger.getLogger(OrderClientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteOrderClient(OrderClient orderClient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String checProjectNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
