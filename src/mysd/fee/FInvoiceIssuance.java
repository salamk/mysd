/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FInvoiceApproval.java
 *
 * Created on Feb 13, 2011, 3:25:54 PM
 */
package mysd.fee;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import mysd.DBSystem;
import mysd.GeneralDB;

/**
 *
 * @author salam
 */
public class FInvoiceIssuance extends javax.swing.JFrame {

    private GeneralDB gdb;
    private DefaultTableModel modelTBLInvoice;
    private Color lavendar, aquaMarine, lightYellow, lightSalmon, slateGray;

    /** Creates new form FInvoiceApproval */
    public FInvoiceIssuance() {
        initComponents();
        gdb = new GeneralDB();
        modelTBLInvoice = (DefaultTableModel) tblInvoice.getModel();
        cmbGrade.setSelectedItem("All");
        lavendar = new Color(230, 230, 250);
        aquaMarine = new Color(102, 205, 170);
        lightYellow = new Color(255, 255, 224);
        lightSalmon = new Color(255, 160, 122);
        slateGray = new Color(240, 255, 255);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblInvoice = new JTable(){
            public Component prepareRenderer
            (TableCellRenderer renderer,int Index_row, int Index_col) {
                Component comp = super.prepareRenderer(renderer, Index_row, Index_col);
                //Component comp = super.prepareRenderer(renderer, Index_row);
                //even index, selected or not selected
                String value = (String)tblInvoice.getValueAt(Index_row, Index_col);

                if(value == null || value.compareToIgnoreCase("")==0){
                    value = "";
                }

                if (value.compareToIgnoreCase("Issued")==0) {
                    comp.setBackground(aquaMarine);
                    //comp.setForeground(Color.green);
                } else if(value.compareToIgnoreCase("APPROVED")==0){
                    comp.setBackground(lightYellow);
                    //comp.setForeground(Color.blue);
                }else if(value.compareToIgnoreCase("CHANGED")==0){
                    comp.setBackground(lavendar);
                    //comp.setForeground(Color.red);
                }else if(value.compareToIgnoreCase("DRAFTED")==0){
                    comp.setBackground(slateGray);
                    //comp.setForeground(Color.magenta);
                }
                else {
                    comp.setBackground(Color.white);
                }
                return comp;
            }
        };
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cmbGrade = new mysd.CCMBGrade();
        cmbGrade.addItem("All");
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        taStatus = new javax.swing.JEditorPane();
        cmbTimeCode = new mysd.CCMBTimeCode();
        jButton2 = new javax.swing.JButton();
        cmbStatus = new mysd.CCMBTimeCode();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Invoice#", "Student#", "Issue Date", "Amount", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInvoice.setCellSelectionEnabled(true);
        tblInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInvoiceMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInvoice);
        tblInvoice.getColumnModel().getColumn(0).setResizable(false);
        tblInvoice.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblInvoice.getColumnModel().getColumn(1).setResizable(false);
        tblInvoice.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblInvoice.getColumnModel().getColumn(2).setResizable(false);
        tblInvoice.getColumnModel().getColumn(2).setPreferredWidth(30);
        tblInvoice.getColumnModel().getColumn(3).setResizable(false);
        tblInvoice.getColumnModel().getColumn(3).setPreferredWidth(10);
        tblInvoice.getColumnModel().getColumn(4).setResizable(false);
        tblInvoice.getColumnModel().getColumn(4).setPreferredWidth(10);

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/issueInvoice01_32.png"))); // NOI18N
        jButton3.setText("Issue Selected");
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/issueInvoice01_32.png"))); // NOI18N
        jButton4.setText("Issue All");
        jButton4.setOpaque(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/downNavigation_32.png"))); // NOI18N
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/isueInvoice05_64.png"))); // NOI18N
        jLabel1.setText("Invoice Issuance Process");

        taStatus.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        taStatus.setEditable(false);
        taStatus.setFont(new java.awt.Font("Dialog", 0, 11));
        taStatus.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        taStatus.setEnabled(false);
        jScrollPane2.setViewportView(taStatus);

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refreshicon24.png"))); // NOI18N
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DRAFTED", "APPROVED", "CHANGED", "ISSUED", "ALL" }));
        cmbStatus.setSelectedIndex(4);
        cmbStatus.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTimeCode, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbTimeCode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton4))
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.approveSelectedInvoices();
}//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        approveAllInvoices();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String item = (String) cmbGrade.getSelectedItem();
        String status = (String) cmbStatus.getSelectedItem();
        if (item.compareToIgnoreCase("all") == 0) {
            listData(status);
        } else {
            listData(status, item);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInvoiceMouseClicked
        // TODO add your handling code here:
        int clickCount = evt.getClickCount();
        if (clickCount == 2) {
            int r = this.tblInvoice.getSelectedRow();
            String invoiceID = (String) tblInvoice.getValueAt(r, 0);
            new FInvoiceSingleView(invoiceID).setVisible(true);
        }
    }//GEN-LAST:event_tblInvoiceMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String item = (String) cmbGrade.getSelectedItem();
        String status = (String) cmbStatus.getSelectedItem();
        if (item.compareToIgnoreCase("all") == 0) {
            listData(status);
        } else {
            listData(status, item);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void listData(String status) {

        modelTBLInvoice.setRowCount(0);
        String query = "";

        if (status.compareToIgnoreCase("All") == 0) {
            query = "SELECT INVOICE_ID, STUDENT_ID, ISSUE_DATE,"
                    + " INVOICE_TOTAL, INVOICE_STATUS "
                    + "FROM MONTHLYINVOICE WHERE "
                    + "TIME_CODE LIKE '" + cmbTimeCode.getTimeCode() + "'";
        } else {
            query = "SELECT INVOICE_ID, STUDENT_ID, ISSUE_DATE,"
                    + " INVOICE_TOTAL, INVOICE_STATUS "
                    + "FROM MONTHLYINVOICE WHERE INVOICE_STATUS LIKE '" + status + "' "
                    + "AND TIME_CODE LIKE '" + cmbTimeCode.getTimeCode() + "'";
        }



        ArrayList al = gdb.searchRecord(query);
        Iterator i = al.iterator();
        while (i.hasNext()) {
            Vector v = (Vector) i.next();
            modelTBLInvoice.addRow(v);
        }

        updateInfo();

    }

    public void listData(String status, String gradeID) {

        modelTBLInvoice.setRowCount(0);
        String query = "";

        if (status.compareToIgnoreCase("All") == 0) {
            query = "SELECT INVOICE_ID, STUDENT_ID, ISSUE_DATE,"
                    + " INVOICE_TOTAL, INVOICE_STATUS "
                    + "FROM MONTHLYINVOICE WHERE "
                    + "TIME_CODE LIKE '" + cmbTimeCode.getTimeCode() + "' "
                    + "AND GRADE_ID LIKE '" + gradeID + "'";
        } else {
            query = "SELECT INVOICE_ID, STUDENT_ID, ISSUE_DATE,"
                    + " INVOICE_TOTAL, INVOICE_STATUS "
                    + "FROM MONTHLYINVOICE WHERE INVOICE_STATUS LIKE '" + status + "' "
                    + "AND TIME_CODE LIKE '" + cmbTimeCode.getTimeCode() + "' "
                    + "AND GRADE_ID LIKE '" + gradeID + "'";
        }



        ArrayList al = gdb.searchRecord(query);
        Iterator i = al.iterator();
        while (i.hasNext()) {
            Vector v = (Vector) i.next();
            modelTBLInvoice.addRow(v);
        }

        updateInfo();

    }

    public void approveAllInvoices() {

        int rCount = tblInvoice.getRowCount();
        String msgs = "<HTML>";

        for (int i = 0; i <= rCount - 1; i++) {
            String invoiceNo = (String) tblInvoice.getValueAt(i, 0);
            String currentStatus = (String) tblInvoice.getValueAt(i, 4);




            if (currentStatus.compareToIgnoreCase("approved") == 0) {
                boolean issued = issueInvoice(invoiceNo);
                if (issued == true) {
                    msgs += "<FONT COLOR=GREEN>" + invoiceNo + " :ISSUED SUCCESSFULLY<BR>";
                } else {
                    msgs += "<FONT COLOR=RED>" + invoiceNo + " :ERROR CANNOT ISSUE THE INVOICE<BR>";
                }

            } else {
                msgs += "<FONT COLOR=BLUE>" + invoiceNo + " :YOU CAN ONLY ISSUE THE APPROVED INVOICES<BR>";
            }
        }

        msgs += "</HTML>";

        JOptionPane.showMessageDialog(null, msgs);
    }

    public void approveSelectedInvoices() {

        int rCount = tblInvoice.getSelectedRowCount();
        int[] selectedRows = tblInvoice.getSelectedRows();
        String msgs = "<HTML>";

        for (int i = 0; i <= rCount - 1; i++) {
            String invoiceNo = (String) tblInvoice.getValueAt(selectedRows[i], 0);
            String currentStatus = (String) tblInvoice.getValueAt(selectedRows[i], 4);




            if (currentStatus.compareToIgnoreCase("approved") == 0) {
                boolean issued = issueInvoice(invoiceNo);
                if (issued == true) {
                    msgs += "<FONT COLOR=GREEN>" + invoiceNo + " :ISSUED SUCCESSFULLY<BR>";
                } else {
                    msgs += "<FONT COLOR=RED>" + invoiceNo + " :ERROR CANNOT ISSUE THE INVOICE<BR>";
                }

            } else {
                msgs += "<FONT COLOR=BLUE>" + invoiceNo + " :YOU CAN ONLY ISSUE THE APPROVED INVOICES<BR>";
            }
        }

        msgs += "</HTML>";

        JOptionPane.showMessageDialog(null, msgs);
    }

    public boolean issueInvoice(String invoiceNo) {

        boolean issued = false;

        if (invoiceNo == null) {
            ;
        } else {
            boolean export = exportInvoice(invoiceNo);
            if (export == true) {
                String query = "UPDATE MONTHLYINVOICE SET INVOICE_STATUS = 'ISSUED' "
                        + "WHERE INVOICE_ID LIKE '" + invoiceNo + "'";
                String stats = gdb.execute(query);
                if (stats.compareToIgnoreCase("ok") == 0) {
                    issued = true;
                }else{
                    JOptionPane.showMessageDialog(null,stats);
                }
            }
        }

        return issued;
    }

    public boolean exportInvoice(String invoiceNo) {

        boolean issued = false;

        System.out.println("inside exportInvoice.....line 451");
        String query = "SELECT INVOICE_ID, STUDENT_ID, GRADE_ID, TIME_CODE,"
                + "ISSUE_DATE, DUE_DATE, INVOICE_TOTAL, INVOICE_STATUS,"
                + "USER_ID, TRANSACTION_TIME, DISCOUNT FROM MONTHLYINVOICE "
                + "WHERE INVOICE_ID LIKE '" + invoiceNo + "'";

        Vector v = gdb.getSingleRow(query);

        System.out.println("inside exportInvoice.....line 458");
        String invoiceID = (String) v.get(0);
        String studentID = (String) v.get(1);
        String gradeID = (String) v.get(2);
        String tcode = (String) v.get(3);
        String idate = (String) v.get(4);
        String ddate = (String) v.get(5);
        String itotal = (String) v.get(6);
        String istatus = (String) v.get(7);
        String userID = (String) v.get(8);
        String ttime = (String) v.get(9);
        String discount = (String) v.get(10);

        System.out.println("inside exportInvoice.....line 472");
        String exportQuery = "INSERT INTO MONTHLYINVOICEISSUED("
                + "INVOICE_ID, STUDENT_ID, GRADE_ID, TIME_CODE,"
                + "ISSUE_DATE, DUE_DATE, INVOICE_TOTAL, INVOICE_STATUS,"
                + "USER_ID, TRANSACTION_TIME, DISCOUNT)VALUES("
                + "'" + invoiceID + "',"
                + "'" + studentID + "',"
                + "'" + gradeID + "',"
                + "'" + tcode + "',"
                + "'" + idate + "',"
                + "'" + ddate + "',"
                + "" + itotal + ","
                + "'" + istatus + "',"
                + "'" + userID + "',"
                + "'" + ttime + "',"
                + "" + discount + ""
                + ")";

        System.out.println("inside exportInvoice.....line 490");

        String stats = gdb.execute(exportQuery);

        System.out.println("inside exportInvoice.....line 494");

        if (stats.compareToIgnoreCase("ok") == 0) {

            DBSystem dbs = new DBSystem();
            Connection con = dbs.getConnection();
            System.out.println("inside exportInvoice.....line 500");
            try {
                con.setAutoCommit(false);
                Statement stmt = con.createStatement();

                System.out.println("inside exportInvoice.....line 505");
                String queryD = "SELECT INVOICE_ID, STUDENT_ID,"
                        + "FEE_CATEGORY, FEE_DETAILS, FEE_AMOUNT, UIDN,"
                        + "USER_ID, TRANSACTION_TIME FROM MONTHLYINVOICEDETAILS "
                        + "WHERE INVOICE_ID LIKE '" + invoiceNo + "'";

                ArrayList al = gdb.searchRecord(queryD);

                System.out.println("inside exportInvoice.....line 513");

                Iterator i = al.iterator();

                while (i.hasNext()) {
                    Vector iv = (Vector) i.next();
                    String iid = (String) iv.get(0);
                    String stid = (String) iv.get(1);
                    String fc = (String) iv.get(2);
                    String fd = (String) iv.get(3);
                    String fa = (String) iv.get(4);
                    String uidn = (String) iv.get(5);
                    String uid = (String) iv.get(6);
                    String trtime = (String) iv.get(7);

                    System.out.println("inside exportInvoice.....line 528");

                    String exportDQuery = "INSERT INTO MONTHLYINVOICEDETAILSISSUED("
                            + "INVOICE_ID, STUDENT_ID, FEE_CATEGORY, FEE_DETAILS,"
                            + "FEE_AMOUNT, UIDN, USER_ID, TRANSACTION_TIME)VALUES("
                            + "'" + iid + "',"
                            + "'" + stid + "',"
                            + "'" + fc + "',"
                            + "'" + fd + "',"
                            + "" + fa + ","
                            + "'" + uidn + "',"
                            + "'" + uid + "',"
                            + "'" + trtime + "')";

                    stmt.executeUpdate(exportDQuery);

                    System.out.println("inside exportInvoice.....line 545");

                }

                con.commit();

                System.out.println("inside exportInvoice.....line 549");
                issued = true;
                con.setAutoCommit(true);
                con.close();

            } catch (Exception e) {
                try {
                    System.out.println(e.getMessage());
                    con.rollback();
                    con.close();
                    System.out.println("inside exportInvoice.....line 560");
                    removeInvoiceMain(invoiceNo);
                    issued = false;
                    System.out.println("inside exportInvoice.....line 562");
                } catch (Exception ei) {
                    JOptionPane.showMessageDialog(null, "System faced failure\n "
                            + "database error\n"
                            + "Cannot rollback");
                    issued = false;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,stats);
        }


        return issued;
    }

    public void removeInvoiceMain(String invoiceNo) {
        String query = "DELETE FROM MONTHLYINVOICEISSUED WHERE "
                + "INVOICE_ID LIKE '" + invoiceNo + "'";
        gdb.execute(query);
    }

    public void updateInfo() {
        String timeCode = cmbTimeCode.getTimeCode();

        String query = "SELECT COUNT(*) FROM CURRENTENROLLMENT WHERE "
                + "CSTATUS like 'ACTIVE'";
        String cenrollment = gdb.getSingleColumnData(query);

        query = "SELECT COUNT(*) FROM MONTHLYINVOICE WHERE INVOICE_STATUS "
                + " LIKE 'DRAFTED' AND TIME_CODE LIKE '" + timeCode + "'";

        String drafted = gdb.getSingleColumnData(query);

        query = "SELECT COUNT(*) FROM MONTHLYINVOICE WHERE INVOICE_STATUS "
                + " LIKE 'APPROVED' AND TIME_CODE LIKE '" + timeCode + "'";

        String approved = gdb.getSingleColumnData(query);

        query = "SELECT COUNT(*) FROM MONTHLYINVOICE WHERE INVOICE_STATUS "
                + " LIKE 'CHANGED' AND TIME_CODE LIKE '" + timeCode + "'";
        String changed = gdb.getSingleColumnData(query);

        query = "SELECT COUNT(*) FROM MONTHLYINVOICE WHERE INVOICE_STATUS "
                + " LIKE 'ISSUED' AND TIME_CODE LIKE '" + timeCode + "'";
        String issued = gdb.getSingleColumnData(query);


        if (drafted.compareToIgnoreCase("") == 0 || drafted == null) {
            drafted = "0";
        }

        if (approved.compareToIgnoreCase("") == 0 || approved == null) {
            approved = "0";
        }

        if (changed.compareToIgnoreCase("") == 0 || changed == null) {
            changed = "0";
        }

        if (issued.compareToIgnoreCase("") == 0 || issued == null) {
            issued = "0";
        }

        String msg = "Total Number of Active Enrollments: " + cenrollment + "\n";
        msg += "Total Number of Drafted Invoices: " + drafted + "\n";
        msg += "Total Number of Approved Invoices: " + approved + "\n";
        msg += "Total Number of Changed Invoices: " + changed + "\n";
        msg += "Total Number of Issued Invoices: " + issued + "\n";

        taStatus.setText(msg);

    }

    public void updateInfo(String gradeID) {

        String timeCode = cmbTimeCode.getTimeCode();
        String query = "SELECT COUNT(*) FROM CURRENTENROLLMENT WHERE "
                + "CSTATUS like 'ACTIVE' and GRADEID LIKE '" + gradeID + "'";
        String cenrollment = gdb.getSingleColumnData(query);

        query = "SELECT COUNT(*) FROM MONTHLYINVOICE WHERE INVOICE_STATUS "
                + " LIKE 'DRAFTED' AND GRADE_ID LIKE '" + gradeID + "'"
                + " AND TIME_CODE LIKE '" + timeCode + "'";

        String drafted = gdb.getSingleColumnData(query);

        query = "SELECT COUNT(*) FROM MONTHLYINVOICE WHERE INVOICE_STATUS "
                + " LIKE 'APPROVED' AND GRADE_ID LIKE '" + gradeID + "'"
                + " AND TIME_CODE LIKE '" + timeCode + "'";
        String approved = gdb.getSingleColumnData(query);

        query = "SELECT COUNT(*) FROM MONTHLYINVOICE WHERE INVOICE_STATUS "
                + " LIKE 'CHANGED' AND GRADE_ID LIKE '" + gradeID + "'"
                + " AND TIME_CODE LIKE '" + timeCode + "'";
        String changed = gdb.getSingleColumnData(query);

        query = "SELECT COUNT(*) FROM MONTHLYINVOICE WHERE INVOICE_STATUS "
                + " LIKE 'ISSUED' AND TIME_CODE LIKE '" + timeCode + "'";
        String issued = gdb.getSingleColumnData(query);


        if (drafted.compareToIgnoreCase("") == 0 || drafted == null) {
            drafted = "0";
        }

        if (approved.compareToIgnoreCase("") == 0 || approved == null) {
            approved = "0";
        }

        if (changed.compareToIgnoreCase("") == 0 || changed == null) {
            changed = "0";
        }

        if (issued.compareToIgnoreCase("") == 0 || issued == null) {
            issued = "0";
        }

        String msg = "Total Number of Active Enrollments: " + cenrollment + "\n";
        msg += "Total Number of Drafted Invoices: " + drafted + "\n";
        msg += "Total Number of Approved Invoices: " + approved + "\n";
        msg += "Total Number of Changed Invoices: " + changed + "\n";
        msg += "Total Number of Issued Invoices: " + issued + "\n";

        taStatus.setText(msg);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FInvoiceIssuance().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mysd.CCMBGrade cmbGrade;
    private mysd.CCMBTimeCode cmbStatus;
    private mysd.CCMBTimeCode cmbTimeCode;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JEditorPane taStatus;
    private javax.swing.JTable tblInvoice;
    // End of variables declaration//GEN-END:variables
}