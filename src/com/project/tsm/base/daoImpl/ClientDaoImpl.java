/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.tsm.base.daoImpl;

import com.project.tsm.base.ConnectionMYSQL;
import com.project.tsm.base.GlobalConst;
import com.project.tsm.dao.ClientDao;
import com.project.tsm.model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmad Dudayef
 */
public class ClientDaoImpl implements ClientDao{
    
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private final Connection connection = ConnectionMYSQL.getConnection();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public void saveClient(Client client) {
        try {
            String saveClient = "INSERT INTO Client values (null,?,?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(saveClient);
            ps.setString(1, client.getName());
            ps.setString(2, client.getContact());
            ps.setString(3, client.getPic());
            ps.setString(4, client.getAddres());
            ps.setString(5, sdf.format(new Date())); // created_date
            ps.setString(6, sdf.format(new Date())); // updated_date
            ps.setString(7, GlobalConst.USER_NAME); // created_by
            ps.setString(8, GlobalConst.USER_NAME); // updated_by
            ps.executeUpdate();
            GlobalConst.succesAlert("Save Client");
            
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Save Client "+ex.getMessage());
            Logger.getLogger(ClientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Client> getAllClient(String param) {
        List<Client> listClient = new ArrayList<>();
        try {
            String selectClient = "SELECT * FROM Client";
            StringBuilder sb = new StringBuilder();
            if(param == null || param.isEmpty()){
                sb.append(selectClient);
            }
            else {
                sb.append(selectClient).append(" where name like '%").append(param).append("%'").append(" or pic = '").append(param).append("'");
            }
            st = connection.createStatement();
            rs = st.executeQuery(sb.toString());
            Client client;
            while(rs.next()){
                client = new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setContact(rs.getString("contact"));
                client.setPic(rs.getString("pic"));
                client.setAddres(rs.getString("address"));
                client.setCreatedDate(rs.getDate("created_date"));
                client.setUpdatedDate(rs.getDate("updated_date"));
                client.setCreatedBy(rs.getString("created_by"));
                client.setUpdatedBy(rs.getString("updated_by"));
                listClient.add(client);
            }
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Load data Client "+ex.getMessage());
            Logger.getLogger(ClientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listClient;
    }

    @Override
    public Client findClientById(String id) {
        Client client = null;
        try {
        String retriveClientById = "SELECT * FROM Client where id = '"+id+"'";
        st = connection.createStatement();
        rs = st.executeQuery(retriveClientById);
            if(rs.next()){
                client = new Client();
                    client.setId(rs.getInt("id"));
                    client.setName(rs.getString("name"));
                    client.setContact(rs.getString("contact"));
                    client.setPic(rs.getString("pic"));
                    client.setAddres(rs.getString("address"));
                    client.setCreatedDate(rs.getDate("created_date"));
                    client.setUpdatedDate(rs.getDate("updated_date"));
                    client.setCreatedBy(rs.getString("created_by"));
                    client.setUpdatedBy(rs.getString("updated_by"));
            }
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Load data Client "+ex.getMessage());
            Logger.getLogger(ClientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
    }

    @Override
    public void updateClient(Client client) {
         try {
            String saveUpdateClient = "UPDATE Client SET name = ?, contact = ?, pic = ?, address = ?, updated_date = ?, updated_by = ? where id = ?";
            ps = connection.prepareStatement(saveUpdateClient);
            ps.setString(1, client.getName());
            ps.setString(2, client.getContact());
            ps.setString(3, client.getPic());
            ps.setString(4, client.getAddres());
            ps.setString(5, sdf.format(new Date())); // updated_date
            ps.setString(6, GlobalConst.USER_NAME); // updated_by
            ps.setInt(7,client.getId());
            ps.executeUpdate();
            GlobalConst.succesAlert("Update Client");
            
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Update Client "+ex.getMessage());
            Logger.getLogger(ClientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteClient(Client client) {
         try {
            String deleteClient = "DELETE FROM Client where id = ?";
            ps = connection.prepareStatement(deleteClient);
            ps.setInt(1, client.getId());
            ps.executeUpdate();
            GlobalConst.succesAlert("Delete Client");
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Delete Client "+ex.getMessage());
            Logger.getLogger(ClientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
