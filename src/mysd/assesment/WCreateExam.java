/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WCreateExam.java
 *
 * Created on Mar 4, 2010, 7:21:49 PM
 */

package mysd.assesment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import mysd.DBSystem;
import mysd.GeneralDB;
import mysd.Utils;
import mysd.dbo.TBLExam;
import mysd.dbo.TBLExamType;



/**
 *
 * @author salamk
 */
public class WCreateExam extends javax.swing.JFrame {

    /** Creates new form WCreateExam */
    public WCreateExam() {
        initComponents();
        setLocationRelativeTo(null);
        this.setExamID();
        this.updateTable();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfExamID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jdtYear = new com.toedter.calendar.JYearChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbMonth = new mysd.C_CMBMonth();
        cmbType = new mysd.C_CMBExamType();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExams = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfStartDate = new acr.component.CDateField();
        tfEndDate = new acr.component.CDateField();
        jLabel6 = new javax.swing.JLabel();
        tfExamIDED = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Exam ID");

        tfExamID.setFont(new java.awt.Font("Tahoma", 1, 18));
        tfExamID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfExamID.setEnabled(false);

        jLabel2.setText("Exam Type");

        jdtYear.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdtYearPropertyChange(evt);
            }
        });

        jLabel3.setText("Exam Month");

        jLabel4.setText("Exam Year");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfExamID, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(jdtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbType, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(cmbMonth, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfExamID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tblExams.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Exam ID", "Exam Type", "Month", "Year", "Start Date", "End Date"
            }
        ));
        tblExams.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblExamsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblExams);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel5.setText("Start Date");

        jLabel6.setText("End Date");

        tfExamIDED.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfExamIDED, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(451, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(tfExamIDED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTypeItemStateChanged
        // TODO add your handling code here:
        setExamID();
}//GEN-LAST:event_cmbTypeItemStateChanged

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        boolean saved = saveRecord();
        if(saved)
        {
             Utils.msg("Record saved successfully");
             updateTable();
        }
        else{
            Utils.msg("Record could not be saved");
        }
            
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cmbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMonthItemStateChanged
        // TODO add your handling code here:
        setExamID();
    }//GEN-LAST:event_cmbMonthItemStateChanged

    private void jdtYearPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdtYearPropertyChange
        // TODO add your handling code here:
        setExamID();
    }//GEN-LAST:event_jdtYearPropertyChange

    private void tblExamsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExamsMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_tblExamsMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int row = tblExams.getSelectedRow();
        String eid = (String)tblExams.getValueAt(row,0);
        tfExamIDED.setText(eid);
        fetchRecord(eid);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        boolean updated = this.updateRecord();
        if(updated){
            Utils.msg("Record updated successfully");
            updateTable();
        }
        else
        {
            Utils.msg("Record could not be updated");
        }

    }//GEN-LAST:event_btnUpdateActionPerformed


    public void fetchRecord(String e_id){

        String query = "SELECT * FROM "+TBLExam.TABLE_NAME+" WHERE " +
                ""+TBLExam.EXAM_ID+" like '"+e_id+"'";
        DBSystem dbs = new DBSystem();
        
        Connection con = dbs.getConnection();

        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            

            while(rs.next())
            {
                
                this.tfExamID.setText(rs.getString(TBLExam.EXAM_ID));
                this.cmbType.setSelectedExamCode(rs.getString(TBLExam.EXAM_TYPE_CODE));
                this.cmbMonth.setSelectedMonth(rs.getString(TBLExam.EXAM_MONTH));
                this.jdtYear.setYear(Integer.parseInt(rs.getString(TBLExam.EXAM_YEAR)));
                this.tfStartDate.setNormalDate(rs.getString(TBLExam.START_DATE));
                this.tfEndDate.setNormalDate(rs.getString(TBLExam.END_DATE));
            }

            dbs.closeConnection(con);
        }
        catch(SQLException se)
        {
            Utils.msg(se.getMessage());
            dbs.closeConnection(con);
        }


    }


    
    public void setExamID(){
        String type = cmbType.getExamCode();
        String mn = cmbMonth.getMonthCode();
        String yr = Integer.toString(jdtYear.getYear());
        String exam_id = type+mn+yr;
        tfExamID.setText(exam_id);
    }


    public boolean saveRecord(){

        boolean saved = true;

        String month = cmbMonth.getMonthCode();
        String year = Integer.toString(this.jdtYear.getYear());
        String time_code = month+year;

        DBSystem dbs = new DBSystem();
        
        
        String query = "INSERT INTO "+TBLExam.TABLE_NAME+"(" +
                ""+TBLExam.EXAM_ID+"," +
                ""+TBLExam.EXAM_TYPE_CODE+"," +
                ""+TBLExam.EXAM_MONTH+"," +
                ""+TBLExam.EXAM_YEAR+"," +
                ""+TBLExam.TIME_CODE+"," +
                ""+TBLExam.START_DATE+"," +
                ""+TBLExam.END_DATE+"," +
                ""+TBLExam.USER_ID+"," +
                ""+TBLExam.TRANSACTION_TIME+")VALUES(" +
                "'"+this.tfExamID.getText()+"'," +
                "'"+this.cmbType.getExamCode()+"'," +
                "'"+month+"'," +
                "'"+year+"'," +
                "'"+time_code+"'," +
                "'"+tfStartDate.getSQLDate()+"'," +
                "'"+tfEndDate.getSQLDate()+"'," +
                "'"+dbs.getLoginUser()+"'," +
                "'"+dbs.getTransactionTime()+"')";

        System.out.println(query);

        Connection con = dbs.getConnection();
        try
        {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            dbs.closeConnection(con);
        }
        catch(SQLException e)
        {
            saved = false;
            dbs.closeConnection(con);
            Utils.msg(e.getMessage());
        }

        return saved;
    }


  public boolean updateRecord(){

        boolean saved = true;

        String month = cmbMonth.getMonthCode();
        String year = Integer.toString(this.jdtYear.getYear());
        String time_code = month+year;

        DBSystem dbs = new DBSystem();

        String eid = this.tfExamID.getText();
        String oeid = this.tfExamIDED.getText();
        String qq = "DELETE FROM "+TBLExam.TABLE_NAME+" WHERE " +
                ""+TBLExam.EXAM_ID+" like '"+oeid+"'";

        String query = "REPLACE INTO "+TBLExam.TABLE_NAME+"(" +
                ""+TBLExam.EXAM_ID+"," +
                ""+TBLExam.EXAM_TYPE_CODE+"," +
                ""+TBLExam.EXAM_MONTH+"," +
                ""+TBLExam.EXAM_YEAR+"," +
                ""+TBLExam.TIME_CODE+"," +
                ""+TBLExam.START_DATE+"," +
                ""+TBLExam.END_DATE+"," +
                ""+TBLExam.USER_ID+"," +
                ""+TBLExam.TRANSACTION_TIME+")VALUES(" +
                "'"+this.tfExamID.getText()+"'," +
                "'"+this.cmbType.getExamCode()+"'," +
                "'"+month+"'," +
                "'"+year+"'," +
                "'"+time_code+"'," +
                "'"+tfStartDate.getSQLDate()+"'," +
                "'"+tfEndDate.getSQLDate()+"'," +
                "'"+dbs.getLoginUser()+"'," +
                "'"+dbs.getTransactionTime()+"')";

        System.out.println(query);

        Connection con = dbs.getConnection();

        try
        {
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(qq);
            stmt.executeUpdate(query);
            con.commit();
            con.setAutoCommit(true);
            dbs.closeConnection(con);
        }
        catch(SQLException e)
        {
            saved = false;
            try{
                con.rollback();
            }
            catch(SQLException se){
                Utils.msg(se.getMessage());
            }

                    
            dbs.closeConnection(con);
            Utils.msg(e.getMessage());
        }

        return saved;
    }



    public void updateTable(){
        
        String query = "SELECT * FROM "+TBLExam.TABLE_NAME;
        DefaultTableModel model = (DefaultTableModel)this.tblExams.getModel();
        model.setRowCount(0);

        DBSystem dbs = new DBSystem();
        GeneralDB gdb = new GeneralDB();
        Connection con = dbs.getConnection();
        
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next())
            {
                Vector<String> v = new Vector<String>();
                v.add(rs.getString(TBLExam.EXAM_ID));
                String type_c = rs.getString(TBLExam.EXAM_TYPE_CODE);
                String q = "SELECT "+TBLExamType.EXAM_NAME+" FROM " +TBLExamType.TABLE_NAME+"" +
                        " WHERE " +
                        ""+TBLExamType.EXAM_CODE+" like '"+type_c+"'";
                String n = gdb.getSingleColumnData(q);
                String ec = type_c + " - "+n;
                
                v.add(ec);
                v.add(rs.getString(TBLExam.EXAM_MONTH));
                v.add(rs.getString(TBLExam.EXAM_YEAR));
                v.add(rs.getString(TBLExam.START_DATE));
                v.add(rs.getString(TBLExam.END_DATE));

                model.addRow(v);
            }
        }
        catch(SQLException se)
        {
            Utils.msg(se.getMessage());
        }
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WCreateExam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private mysd.C_CMBMonth cmbMonth;
    private mysd.C_CMBExamType cmbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JYearChooser jdtYear;
    private javax.swing.JTable tblExams;
    private acr.component.CDateField tfEndDate;
    private javax.swing.JTextField tfExamID;
    private javax.swing.JTextField tfExamIDED;
    private acr.component.CDateField tfStartDate;
    // End of variables declaration//GEN-END:variables

}
