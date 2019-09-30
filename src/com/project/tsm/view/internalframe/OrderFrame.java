/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.tsm.view.internalframe;

import com.project.tsm.base.GlobalConst;
import com.project.tsm.base.daoImpl.ClientDaoImpl;
import com.project.tsm.base.daoImpl.LanguagesDaoImpl;
import com.project.tsm.base.daoImpl.OrderClientDaoImpl;
import com.project.tsm.base.daoImpl.TranslatorDaoImpl;
import com.project.tsm.model.Client;
import com.project.tsm.model.Languages;
import com.project.tsm.model.OrderClient;
import com.project.tsm.model.Translator;
import com.project.tsm.view.dialogform.NewOrderDialogForm;
import com.project.tsm.view.dialogform.ViewOrderDialogForm;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Osvaldo Erens
 */
public final class OrderFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form OrderFrame
     * 
     */
    
    public DefaultTableModel tableModel;
    public OrderClientDaoImpl orderClientDaoImpl    = new OrderClientDaoImpl();
    public ClientDaoImpl clientDaoImpl              = new ClientDaoImpl();
    public LanguagesDaoImpl languagesDaoImpl        = new LanguagesDaoImpl();
    public TranslatorDaoImpl translatorDaoImpl      = new TranslatorDaoImpl();

    
    public HashMap<String,Client>    mapClientById      = new HashMap<>();
    public HashMap<String,Languages> mapLanguagesById   = new HashMap<>();
    public HashMap<String,Translator> mapTranslatorById = new HashMap<>();
    
    public OrderFrame() {
        initComponents();
        initMapClient();
        initMapLanguages();
        initMapTranslator();
        initFilter();
        tableOrderClient();
    }

     public void tableOrderClient(){
         
        String [] header = {"NO","ID","PROJECT NUMBER","DATE ORDER","CLIENT","CP","ORDER",
            "LANGUAGE","FILE NAME","PAGE | WORD","QTY","RATE","RATE VALUE","DEADLINE CLIENT",
            "DEADLINE CLIENT VALUE","TRANSLATOR","DEADLINE TYPE","DEADLINE VALUE","STATUS"};
        tableModel = new DefaultTableModel(null, header);
        jTable1.setModel(tableModel);
        List<OrderClient> listOrderClients = orderClientDaoImpl.getAllOrderClient(jComboBox1.getSelectedItem().toString(),jTextField1.getText());
        
        if(listOrderClients != null){
            int number = 1;
            for(OrderClient orderClient : listOrderClients){
                tableModel.addRow(new Object[]{
                    number++,
                    orderClient.getId(),
                    orderClient.getProject_number(),
                    new SimpleDateFormat("dd-MMMM-yyyy").format(orderClient.getDate_order()),
                    mapClientById.get(String.valueOf(orderClient.getClient_id())).getName(),
                    mapClientById.get(String.valueOf(orderClient.getClient_id())).getPic(),
                    orderClient.getOrder_type(),
                    mapLanguagesById.get(String.valueOf(orderClient.getLanguange())).getName(),
                    orderClient.getFile_name(),
                    orderClient.getQty_type(),
                    orderClient.getQty_value(),
                    orderClient.getRate_type(),
                    orderClient.getRate_value(),
                    orderClient.getDeadline_client_type(),
                    orderClient.getDeadline_client_value(),
                    mapTranslatorById.get(String.valueOf(orderClient.getTranslator_id())).getName(),
                    orderClient.getTranslator_deadline_type(),
                    orderClient.getTranslator_deadline_value(),
                    orderClient.getStatus()
                });
                
                jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
                jTable1.getColumnModel().getColumn(1).setPreferredWidth(40);
                jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
                jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
                jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
                jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
                jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
                jTable1.getColumnModel().getColumn(7).setPreferredWidth(150);
                jTable1.getColumnModel().getColumn(8).setPreferredWidth(150);
                jTable1.getColumnModel().getColumn(9).setPreferredWidth(150);
                jTable1.getColumnModel().getColumn(10).setPreferredWidth(50);
                jTable1.getColumnModel().getColumn(11).setPreferredWidth(150);
                jTable1.getColumnModel().getColumn(12).setPreferredWidth(250);
                jTable1.getColumnModel().getColumn(13).setPreferredWidth(250);
                jTable1.getColumnModel().getColumn(14).setPreferredWidth(250);
                jTable1.getColumnModel().getColumn(15).setPreferredWidth(250);
                jTable1.getColumnModel().getColumn(16).setPreferredWidth(250);
                jTable1.getColumnModel().getColumn(17).setPreferredWidth(250);
                 jTable1.getColumnModel().getColumn(18).setPreferredWidth(250);
    
            }
        }
        
        
    }
     
    public void initMapClient(){
        List<Client> listClient = clientDaoImpl.getAllClient(null);
        if(listClient != null){
            listClient.forEach((client) -> {
                int id = client.getId();
                if(!mapClientById.containsKey(String.valueOf(id))){
                    mapClientById.put(String.valueOf(id), client);
                }
                else {
                    mapClientById.get(String.valueOf(id));
                }
            });
        }
    }
    
    public void initMapLanguages(){
        List<Languages> listLanguages = languagesDaoImpl.getAllLanguages(null);
        if(listLanguages != null){
            listLanguages.forEach((language) -> {
                int id = language.getId();
                if(!mapLanguagesById.containsKey(String.valueOf(id))){
                    mapLanguagesById.put(String.valueOf(id), language);
                }
                else {
                    mapLanguagesById.get(String.valueOf(id));
                }
            });
        }
    }
    
    public void initMapTranslator(){
        List<Translator> listTranslators = translatorDaoImpl.getAllTranslator(null);
        if(listTranslators != null){
            listTranslators.forEach((tranlator) -> {
                int id = tranlator.getId();
                if(!mapTranslatorById.containsKey(String.valueOf(id))){
                    mapTranslatorById.put(String.valueOf(id), tranlator);
                }
                else {
                    mapTranslatorById.get(String.valueOf(id));
                }
            });
        }
    }
    
    public void initFilter(){
        if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Date Order")){
            jDateChooser1.setEnabled(true);
            jDateChooser2.setEnabled(true);
            jTextField1.setEnabled(false);
            jTextField1.setText(null);
        }
        else {
           jDateChooser1.setEnabled(false);
           jDateChooser2.setEnabled(false); 
           jTextField1.setEnabled(true);
        }
    }
     
    
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Order Frame");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("New Order");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("View");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Edit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Delete");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Project Number", "Date Order", "Client", "File Name", "Translator", "Status" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Date Order"));

        jLabel1.setText("Start Date");

        jLabel2.setText("End Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      NewOrderDialogForm newOrderDialogForm = new NewOrderDialogForm(null, rootPaneCheckingEnabled);
      newOrderDialogForm.orderFrame = this;
      newOrderDialogForm.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       tableOrderClient();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        tableOrderClient();
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int row = jTable1.getSelectedRow();
       if(row == -1 ){
           GlobalConst.notifAlert("Please choose data !");
       }
       else {
           ViewOrderDialogForm viewOrderDialogForm = new ViewOrderDialogForm(null, rootPaneCheckingEnabled);
           viewOrderDialogForm.orderFrame = this;
           viewOrderDialogForm.populateViewOrderClient(jTable1.getValueAt(row, 1).toString());
           viewOrderDialogForm.setVisible(rootPaneCheckingEnabled);
       }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         int row = jTable1.getSelectedRow();
       if(row == -1 ){
           GlobalConst.notifAlert("Please choose data !");
       }
       else {
           NewOrderDialogForm newOrderDialogForm = new NewOrderDialogForm(null, rootPaneCheckingEnabled);
           newOrderDialogForm.orderFrame = this;
           newOrderDialogForm.populateEditOrderClient(jTable1.getValueAt(row, 1).toString(),true);
           newOrderDialogForm.setVisible(rootPaneCheckingEnabled);
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
       initFilter();
    }//GEN-LAST:event_jComboBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
