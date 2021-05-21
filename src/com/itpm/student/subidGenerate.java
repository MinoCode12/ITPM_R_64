/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.student;

import com.itpm.timetablemanagement.util.Constant;
import com.itpm.timetablemanagement.util.CreateQuery;
import com.itpm.timetablemanagement.util.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Anjelo
 */
public class subidGenerate extends javax.swing.JFrame {
    
    private Connection connection;
     PreparedStatement pstYns, pstDp, pstGno, pst, pst2;
     ResultSet rs;
    /**
     * Creates new form subidGenerate
     */
    public subidGenerate() {
        initComponents();
        
        showSubGroupIDList();
        groupIDSelection();
        subGroupNoSelection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        select_gid = new javax.swing.JComboBox();
        select_subno = new javax.swing.JComboBox();
        btn_generate = new javax.swing.JButton();
        txt_subid = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        txt_error = new javax.swing.JTextField();
        btn_save = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_subid = new javax.swing.JTable();
        txt_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 204));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 877, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));
        jPanel3.setForeground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Group ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Sub Group Number");

        select_gid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        select_subno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_generate.setText("Generate Sub Group ID");
        btn_generate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_generateMousePressed(evt);
            }
        });

        jTextField4.setText("jTextField4");

        btn_save.setText("SAVE");
        btn_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_saveMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_error, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(118, 118, 118)
                .addComponent(btn_save)
                .addGap(56, 56, 56)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(select_gid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(select_subno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_generate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_subid, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(64, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(select_gid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(66, 66, 66)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(select_subno, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_generate)
                            .addComponent(txt_subid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_save))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txt_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tbl_subid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Sub Group ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_subid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_subidMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_subid);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(895, 657));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_generateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_generateMousePressed
        
        String gid = select_gid.getSelectedItem().toString();
        String subno = select_subno.getSelectedItem().toString();
        
        if(select_gid.getSelectedIndex() == 0){
             JOptionPane.showMessageDialog(subidGenerate.this, "Group ID id cannot empty! ", "Data missing", JOptionPane.ERROR_MESSAGE);
        }
        
        if(select_subno.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(subidGenerate.this, "Sub Group ID id cannot empty! ", "Data missing", JOptionPane.ERROR_MESSAGE);
        }
        else{
            txt_subid.setText(gid + "." + subno);
        }
    }//GEN-LAST:event_btn_generateMousePressed

    private void btn_saveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMousePressed
        
        boolean error = false;
        
        try{
            DefaultTableModel model = (DefaultTableModel)tbl_subid.getModel();
            connection = DBConnection.getConnection();
            
            if(txt_subid.getText().contentEquals("")){
                JOptionPane.showMessageDialog(subidGenerate.this, "Sub Group ID cannot be empty!", "Data missing", JOptionPane.ERROR_MESSAGE);
                error = true;
            }
            else{
                 PreparedStatement statement = connection.prepareStatement(CreateQuery.getQuery(Constant.INSERT_SUB_GROUP_ID));
                 statement.setString(1, txt_subid.getText().toUpperCase());
                   statement.executeUpdate();
                 model.setRowCount(0);
                 
                 showSubGroupIDList();
                 txt_subid.setText("");
                 JOptionPane.showMessageDialog(null,"Successful Added Sub Group ID !");
            }
        }catch (SQLException | ClassNotFoundException | IOException |
                ParserConfigurationException | SAXException ex) {
                Logger.getLogger(SubGroupID.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_btn_saveMousePressed

    private void tbl_subidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_subidMouseClicked
        int i = tbl_subid.getSelectedRow();
        TableModel model = tbl_subid.getModel();
        txt_id.setText(model.getValueAt(i, 0).toString());
        txt_subid.setText(model.getValueAt(i, 1).toString());
        
        int row = tbl_subid.getSelectedRow();
        int col = tbl_subid.getSelectedColumn();
        model = tbl_subid.getModel();
        
         if(col == 3){
            int x = JOptionPane.showConfirmDialog(subidGenerate.this, "Are you sure to Delete", "Delete", JOptionPane.YES_NO_OPTION);
            if(x==0){
                deleteData(row);
            }

        }
         if(col == 2){
             updateData(row);
        }
        
        
        
        
    }//GEN-LAST:event_tbl_subidMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(subidGenerate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(subidGenerate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(subidGenerate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(subidGenerate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new subidGenerate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_generate;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JComboBox select_gid;
    private javax.swing.JComboBox select_subno;
    private javax.swing.JTable tbl_subid;
    private javax.swing.JTextField txt_error;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_subid;
    // End of variables declaration//GEN-END:variables

    private void showSubGroupIDList() {
        
         ArrayList<SubGroupID> list = getSubGroupIDList();
        DefaultTableModel model = (DefaultTableModel)tbl_subid.getModel();
        Object[] row = new Object[4];
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getSubgId();
            row[2] = "Edit";
            row[3] = "Delete";
           
            model.addRow(row);
        }
         
        
    }

    private void groupIDSelection() {
         try{  
        connection = DBConnection.getConnection();
        String query = "select * from group_id";
        pst = connection.prepareStatement(query);
        rs = pst.executeQuery();
        
        while(rs.next())
        {
            String groupID = rs.getString("gId");
            select_gid.addItem(groupID);
        }
        }
        catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e);
        } 

        
        
         
    }

    private void subGroupNoSelection() {
        try{  
        connection = DBConnection.getConnection();
        String query = "select * from subGroupNo";
        pst = connection.prepareStatement(query);
        rs = pst.executeQuery();
        
        while(rs.next())
        {
            String SubgroupID = rs.getString("sGno");
            select_subno.addItem(SubgroupID);
        }
        }
        catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e);
        } 
    }

    private ArrayList<SubGroupID> getSubGroupIDList() {
        
        ArrayList<SubGroupID> list = new ArrayList<SubGroupID>();
        try{
        connection = DBConnection.getConnection();
        String querry = "select * from sub_group_id";
        Statement st;
        ResultSet rs;
        
        st = connection.createStatement();
        rs= st.executeQuery(querry);
        SubGroupID subid;
        while(rs.next())
        {
            subid = new SubGroupID(rs.getInt("id"), rs.getString("subgId"));
            list.add(subid);
        }
        
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;

        
    }

    private void deleteData(int row) {
         
        boolean error = false;
         DefaultTableModel mod = (DefaultTableModel) tbl_subid.getModel();
        
         try {
             int id = (int) mod.getValueAt(row, 0);
            
             
            Connection connection =  DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(CreateQuery.getQuery(Constant.DELETE_SUB_GROUP_ID));
            
            statement.setInt(1, id);
            statement.execute();
            
        } catch (SQLException | ClassNotFoundException | IOException | 
                ParserConfigurationException | SAXException ex) {
            Logger.getLogger(subidGenerate.class.getName()).log(Level.SEVERE, null, ex);
            error = true;
            
             JOptionPane.showMessageDialog(subidGenerate.this, "Delete Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
         
         if(!error){
             JOptionPane.showMessageDialog(subidGenerate.this, "Delete Succes", "Succes", JOptionPane.DEFAULT_OPTION);
             mod.removeRow(row);
             
             
         }
    }

    private void updateData(int row) {
        
        String id = txt_id.getText();
       try{
            DefaultTableModel model = (DefaultTableModel)tbl_subid.getModel();
            Statement smt = connection.createStatement();
            
            if(txt_subid.getText().equals("")){
                txt_error.setText("Select SubGroup Id*");
            }
            else{
                txt_error.setText("");
            
            smt.execute("UPDATE sub_group_id SET subgId = '"+txt_subid.getText().toUpperCase()+"' WHERE id = "+id); 
            model.setRowCount(0);
            showSubGroupIDList();
            txt_subid.setText("");
            JOptionPane.showMessageDialog(this, "Record Updated!");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
       
    }
}