/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.tsm.dao;

import com.project.tsm.model.Translator;
import java.util.List;

/**
 *
 * @author Ahmad Dudayef
 */
public interface TranslatorDao {
    public void saveTranslator(Translator translator);
    public List<Translator> getAllTranslator(String param);
    public Translator findTranslatorById(String id);
    public void updateTranslator(Translator translator);
    public void deleteTranslator(Translator translator);
    public String checkId();
}
