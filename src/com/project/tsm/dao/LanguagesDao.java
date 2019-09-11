/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.tsm.dao;

import com.project.tsm.model.Languages;
import java.util.List;

/**
 *
 * @author Ahmad Dudayef
 */
public interface LanguagesDao {
    
    public void saveLanguages(Languages languages);
    public List<Languages> getAllLanguages(String param);
    public Languages findLanguagesById(String id);
    public void updateLanguages(Languages languages);
    public void deleteLanguages(Languages languages);
    public String checkId();
    
}
