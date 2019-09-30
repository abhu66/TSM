/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.tsm.base.daoImpl;

import com.project.tsm.base.ConnectionMYSQL;
import com.project.tsm.base.GlobalConst;
import com.project.tsm.dao.LanguagesDao;
import com.project.tsm.model.Languages;
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
public class LanguagesDaoImpl implements LanguagesDao{

    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private final Connection connection = ConnectionMYSQL.getConnection();
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    public void saveLanguages(Languages languages) {
        try {
            String saveLanguages = "INSERT INTO Languages values (null,?,?,?,?,?,?)";
            ps = connection.prepareStatement(saveLanguages);
            ps.setString(1, languages.getName().toUpperCase());
            ps.setString(2, languages.getDescrption().toUpperCase());
            ps.setString(3,  sdf.format(languages.getCreatedDate()));
            ps.setString(4,  sdf.format(languages.getUpdatedDate()));
            ps.setString(5, languages.getCreatedBy());
            ps.setString(6, languages.getUpdatedBy());
            ps.executeUpdate();
            
            GlobalConst.succesAlert("Save Languages ! ");
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Save Languages ! ");
            Logger.getLogger(LanguagesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

    @Override
    public List<Languages> getAllLanguages(String param) {
        List<Languages> listLanguages = new ArrayList<>();
        try {
            String selectLanguages = "SELECT * FROM Languages";
            StringBuilder sb = new StringBuilder();
            if(param == null || param.isEmpty()){
                sb.append(selectLanguages);
            }
            else {
                sb.append(selectLanguages).append(" where name like '%").append(param).append("%'").append(" or description = '").append(param).append("'");
            }
            st = connection.createStatement();
            rs = st.executeQuery(sb.toString());
            Languages languages;
            while(rs.next()){
                languages = new Languages();
                languages.setId(rs.getInt("id"));
                languages.setName(rs.getString("name"));
                languages.setDescrption(rs.getString("description"));
                languages.setCreatedDate(rs.getDate("created_date"));
                languages.setUpdatedDate(rs.getDate("updated_date"));
                languages.setCreatedBy(rs.getString("created_by"));
                languages.setUpdatedBy(rs.getString("updated_by"));
                listLanguages.add(languages);
            }
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Load data Languages "+ex.getMessage());
            Logger.getLogger(LanguagesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLanguages;
    }

    @Override
    public Languages findLanguagesById(String id) {
       Languages languages = null;
        try {
        String retriveLanguagesById = "SELECT * FROM Languages where id = '"+id+"'";
        st = connection.createStatement();
        rs = st.executeQuery(retriveLanguagesById);
            if(rs.next()){
                languages = new Languages();
                    languages.setId(rs.getInt("id"));
                    languages.setName(rs.getString("name"));
                    languages.setDescrption(rs.getString("description"));
                    languages.setCreatedDate(rs.getDate("created_date"));
                    languages.setUpdatedDate(rs.getDate("updated_date"));
                    languages.setCreatedBy(rs.getString("created_by"));
                    languages.setUpdatedBy(rs.getString("updated_by"));
            }
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Load data languages "+ex.getMessage());
            Logger.getLogger(LanguagesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return languages;
    }

    @Override
    public void updateLanguages(Languages languages) {
        try {
            String saveUpdateLanguages= "UPDATE Languages SET name = ?, description = ?, updated_date = ?, updated_by = ? where id = ?";
            ps = connection.prepareStatement(saveUpdateLanguages);
            ps.setString(1, languages.getName().toUpperCase());
            ps.setString(2, languages.getDescrption().toUpperCase());
            ps.setString(3, sdf.format(new Date()));
            ps.setString(4, GlobalConst.USER_NAME); // updated_by
            ps.setInt(5,languages.getId());
            ps.executeUpdate();
            GlobalConst.succesAlert("Update Languages");
            
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Update Languages "+ex.getMessage());
            Logger.getLogger(LanguagesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteLanguages(Languages languages) {
        try {
            String deleteClient = "DELETE FROM Languages where id = ?";
            ps = connection.prepareStatement(deleteClient);
            ps.setInt(1, languages.getId());
            ps.executeUpdate();
            GlobalConst.succesAlert("Delete Languages");
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Delete Languages "+ex.getMessage());
            Logger.getLogger(LanguagesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String checkId() {
       String lastId = null;
        try{
       String getLastId = "select id from languages order by id desc limit 1";
        st = connection.createStatement();
        rs = st.executeQuery(getLastId);
            if(rs.next()){
                lastId = String.valueOf(rs.getInt("id"));
            }
            else {
                lastId = "0";
            }
        } catch (SQLException ex) {
            GlobalConst.failedAlert("Load data languages "+ex.getMessage());
            Logger.getLogger(LanguagesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastId;
    }
    
}
