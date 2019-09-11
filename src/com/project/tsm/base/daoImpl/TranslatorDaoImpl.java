/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.tsm.base.daoImpl;

import com.project.tsm.base.ConnectionMYSQL;
import com.project.tsm.base.GlobalConst;
import com.project.tsm.dao.TranslatorDao;
import com.project.tsm.model.Client;
import com.project.tsm.model.Translator;
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
public class TranslatorDaoImpl implements TranslatorDao {
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private final Connection connection = ConnectionMYSQL.getConnection();
    private final SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    public void saveTranslator(Translator translator) {
       //To change body of generated methods, choose Tools | Templates.
         try {
            String saveClient = "INSERT INTO Translator values (null,?,?,?,?,?,?)";
            ps = connection.prepareStatement(saveClient);
            ps.setString(1, translator.getName());
            ps.setString(2, translator.getContact());
            ps.setString(3, sdf.format(new Date())); // created_date
            ps.setString(4, sdf.format(new Date())); // updated_date
            ps.setString(5, GlobalConst.USER_NAME); // created_by
            ps.setString(6, GlobalConst.USER_NAME); // updated_by
            ps.executeUpdate();
            GlobalConst.succesAlert("Save Translator");
            
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Save Translator "+ex.getMessage());
            Logger.getLogger(TranslatorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Translator> getAllTranslator(String param) {
         List<Translator> listTranslator = new ArrayList<>();
        try {
            String selectClient = "SELECT * FROM Translator";
            StringBuilder sb = new StringBuilder();
            if(param == null || param.isEmpty()){
                sb.append(selectClient);
            }
            else {
                sb.append(selectClient).append(" where name like '%").append(param).append("%'").append(" or contact = '").append(param).append("'");
            }
            st = connection.createStatement();
            rs = st.executeQuery(sb.toString());
            Translator translator;
            while(rs.next()){
                translator = new Translator();
                translator.setId(rs.getInt("id"));
                translator.setName(rs.getString("name"));
                translator.setContact(rs.getString("contact"));
                translator.setCreatedDate(rs.getDate("created_date"));
                translator.setUpdatedDate(rs.getDate("updated_date"));
                translator.setCreatedBy(rs.getString("created_by"));
                translator.setUpdatedBy(rs.getString("updated_by"));
                listTranslator.add(translator);
            }
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Load data Translator "+ex.getMessage());
            Logger.getLogger(TranslatorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTranslator;
    }

    @Override
    public Translator findTranslatorById(String id) {
        Translator translator = null;
        try {
        String retriveTranslatorById = "SELECT * FROM Translator where id = '"+id+"'";
        st = connection.createStatement();
        rs = st.executeQuery(retriveTranslatorById);
            if(rs.next()){
                translator = new Translator();
                    translator.setId(rs.getInt("id"));
                    translator.setName(rs.getString("name"));
                    translator.setContact(rs.getString("contact"));
                    translator.setCreatedDate(rs.getDate("created_date"));
                    translator.setUpdatedDate(rs.getDate("updated_date"));
                    translator.setCreatedBy(rs.getString("created_by"));
                    translator.setUpdatedBy(rs.getString("updated_by"));
            }
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Load data translator "+ex.getMessage());
            Logger.getLogger(TranslatorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return translator;
    }

    @Override
    public void updateTranslator(Translator translator) {
         try {
            String saveUpdateTranlator = "UPDATE Translator SET name = ?, contact = ?, updated_date = ?, updated_by = ? where id = ?";
            ps = connection.prepareStatement(saveUpdateTranlator);
            ps.setString(1, translator.getName());
            ps.setString(2, translator.getContact());
      
            ps.setString(3, sdf.format(new Date())); // updated_date
            ps.setString(4, GlobalConst.USER_NAME); // updated_by
            ps.setInt(5,translator.getId());
            ps.executeUpdate();
            GlobalConst.succesAlert("Update Translator");
            
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Update Translator "+ex.getMessage());
            Logger.getLogger(TranslatorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteTranslator(Translator translator) {
         try {
            String deleteClient = "DELETE FROM Translator where id = ?";
            ps = connection.prepareStatement(deleteClient);
            ps.setInt(1, translator.getId());
            ps.executeUpdate();
            GlobalConst.succesAlert("Delete Translator");
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Delete Translator "+ex.getMessage());
            Logger.getLogger(TranslatorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String checkId() {
        String lastId = null;
        try{
       String getLastId = "select id from translator order by id desc limit 1";
        st = connection.createStatement();
        rs = st.executeQuery(getLastId);
            if(rs.next()){
                lastId = String.valueOf(rs.getInt("id"));
            }
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Load data translator "+ex.getMessage());
            Logger.getLogger(TranslatorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastId;
    }
    
}
