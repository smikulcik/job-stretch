/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenaciouspanda.jobstretch.frontend;

import com.tenaciouspanda.jobstretch.Session;
import com.tenaciouspanda.jobstretch.database.User;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author ekustudent
 */
public class AddConnectionPanel extends CardSubpanel {

    /**
     * Creates new form AddConnection
     */
    public AddConnectionPanel(Session session, ViewManager theView) {
        super(session, theView);
        initComponents();
        addBtn.setIcon(new ImageIcon(this.getClass().getResource("/addConnectionButton.png")));
        backBtn.setIcon(new ImageIcon(this.getClass().getResource("/backButton.png")));
        searchBtn.setIcon(new ImageIcon(this.getClass().getResource("/searchButton.png")));

        registrationLabel.setFont(view.getFont(32));
        jLabel1.setFont(view.getFont(24));
        jLabel2.setFont(view.getFont(24));

    }
    
    @Override
    public void onShow(){
       User[] users = session.searchUnconnectedUser("", "");
       jList1.setListData(users);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registrationLabel = new javax.swing.JLabel();
        fnameSearch = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<User>();
        addBtn = new javax.swing.JButton();
        lnameSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setLayout(null);

        registrationLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        registrationLabel.setForeground(new java.awt.Color(255, 153, 51));
        registrationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrationLabel.setText("Add Connection");
        add(registrationLabel);
        registrationLabel.setBounds(310, 20, 260, 50);

        fnameSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(fnameSearch);
        fnameSearch.setBounds(180, 110, 150, 30);

        searchBtn.setActionCommand("searchBtn");
        searchBtn.setBorderPainted(false);
        searchBtn.setContentAreaFilled(false);
        searchBtn.setFocusPainted(false);
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        add(searchBtn);
        searchBtn.setBounds(650, 110, 150, 40);

        jList1.setBackground(new java.awt.Color(0, 0, 0));
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setSelectionBackground(new java.awt.Color(255, 153, 51));
        jScrollPane1.setViewportView(jList1);

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 160, 747, 230);

        addBtn.setToolTipText("");
        addBtn.setBorderPainted(false);
        addBtn.setContentAreaFilled(false);
        addBtn.setFocusPainted(false);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        add(addBtn);
        addBtn.setBounds(560, 410, 230, 60);

        lnameSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lnameSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameSearchActionPerformed(evt);
            }
        });
        add(lnameSearch);
        lnameSearch.setBounds(480, 110, 150, 30);

        jLabel1.setFont(new java.awt.Font("Oswald", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("First Name");
        add(jLabel1);
        jLabel1.setBounds(60, 110, 140, 30);

        jLabel2.setFont(new java.awt.Font("Oswald", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Last Name");
        add(jLabel2);
        jLabel2.setBounds(360, 110, 130, 30);

        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn);
        backBtn.setBounds(10, 10, 135, 35);

        jLabel6.setIcon(new ImageIcon(this.getClass().getResource("/bg.png")));
        jLabel6.setAlignmentY(0.0F);
        add(jLabel6);
        jLabel6.setBounds(0, 0, 870, 544);
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        User toAdd = jList1.getSelectedValue();
        if(toAdd != null){
            session.addConnection(toAdd);
            //update current user's contacts now that they've changed
            session.getCurrentUser().setContacts();
        }
        this.view.displayView("DashboardPanel");
    }//GEN-LAST:event_addBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
       String fname = fnameSearch.getText();
       String lname = lnameSearch.getText();
       User[] users = session.searchUnconnectedUser(fname, lname);
       jList1.setListData(users);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        view.displayView("DashboardPanel");
    }//GEN-LAST:event_backBtnActionPerformed

    private void lnameSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField fnameSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<User> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lnameSearch;
    private javax.swing.JLabel registrationLabel;
    private javax.swing.JButton searchBtn;
    // End of variables declaration//GEN-END:variables
}
