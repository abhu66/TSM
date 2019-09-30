/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.tsm.model;

import com.project.tsm.base.BaseModel;
import java.util.Date;

/**
 *
 * @author Ahmad Dudayef
 */
public class OrderClient extends BaseModel{
    
    private int project_number;
    private Date date_order;
    private int client_id;
    private String order_type;
    private int languange;
    private String file_name;
    private String qty_type;
    private String qty_value;
    private String rate_type;
    private String rate_value;
    private String deadline_client_type;
    private String deadline_client_value;
    private int translator_id;
    private String translator_deadline_type;
    private String translator_deadline_value;
    private String status;

    public int getProject_number() {
        return project_number;
    }

    public void setProject_number(int project_number) {
        this.project_number = project_number;
    }

    public Date getDate_order() {
        return date_order;
    }

    public void setDate_order(Date date_order) {
        this.date_order = date_order;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public Integer getLanguange() {
        return languange;
    }

    public void setLanguange(Integer languange) {
        this.languange = languange;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getQty_type() {
        return qty_type;
    }

    public void setQty_type(String qty_type) {
        this.qty_type = qty_type;
    }

    public String getQty_value() {
        return qty_value;
    }

    public void setQty_value(String qty_value) {
        this.qty_value = qty_value;
    }

    public String getRate_type() {
        return rate_type;
    }

    public void setRate_type(String rate_type) {
        this.rate_type = rate_type;
    }

    public String getRate_value() {
        return rate_value;
    }

    public void setRate_value(String rate_value) {
        this.rate_value = rate_value;
    }

    public String getDeadline_client_type() {
        return deadline_client_type;
    }

    public void setDeadline_client_type(String deadline_client_type) {
        this.deadline_client_type = deadline_client_type;
    }

    public String getDeadline_client_value() {
        return deadline_client_value;
    }

    public void setDeadline_client_value(String deadline_client_value) {
        this.deadline_client_value = deadline_client_value;
    }

    public int getTranslator_id() {
        return translator_id;
    }

    public void setTranslator_id(int translator_id) {
        this.translator_id = translator_id;
    }

    public String getTranslator_deadline_type() {
        return translator_deadline_type;
    }

    public void setTranslator_deadline_type(String translator_deadline_type) {
        this.translator_deadline_type = translator_deadline_type;
    }

    public String getTranslator_deadline_value() {
        return translator_deadline_value;
    }

    public void setTranslator_deadline_value(String translator_deadline_value) {
        this.translator_deadline_value = translator_deadline_value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
