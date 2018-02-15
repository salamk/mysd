/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FPaymentSelection.java
 *
 * Created on Mar 3, 2011, 12:10:38 PM
 */
package mysd.fee;


import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import mysd.GeneralDB;
import mysd.Utils;

/**
 *
 * @author salam
 */
public class FInvoiceReporting extends javax.swing.JFrame {

    private GeneralDB gdb;

    /** Creates new form FPaymentSelection */
    public FInvoiceReporting() {
        initComponents();
        getContentPane().setBackground(new Color(204, 255, 204));
        gdb = new GeneralDB();
        setLocationRelativeTo(null);
    }
    
    public FInvoiceReporting(String studentID) {
        initComponents();
        getContentPane().setBackground(new Color(204, 255, 204));
        gdb = new GeneralDB();
        setLocationRelativeTo(null);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGrade = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbGrade = new mysd.CCMBGrade();
        jLabel2 = new javax.swing.JLabel();
        cmbTimeCode = new mysd.CCMBTimeCode();
        jButton2 = new javax.swing.JButton();
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

                if (value.compareToIgnoreCase("UNPAID")==0) {
                    comp.setBackground(Color.red);
                    //comp.setForeground(Color.green);
                } else if(value.compareToIgnoreCase("PARTIAL PAID")==0){
                    comp.setBackground(Color.orange);
                    //comp.setForeground(Color.blue);
                }else if(value.compareToIgnoreCase("PAID")==0){
                    comp.setBackground(Color.green);
                    //comp.setForeground(Color.red);
                }else {
                    comp.setBackground(Color.white);
                }
                return comp;
            }
        };
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tfStudentID = new acr.component.CAlphaNumericField();
        jButton3 = new javax.swing.JButton();
        tfTitle = new javax.swing.JTextField();
        pnlByDate = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSearchByDate = new javax.swing.JButton();
        tfDateFrom = new acr.component.CDateField();
        tfDateTo = new acr.component.CDateField();
        jLabel6 = new javax.swing.JLabel();
        tfTotalAmount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfTotalPaid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfTotalUnpaid = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfTotalPartPaid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporting Invoices Issued");

        pnlGrade.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setText("Grade ID");

        jLabel2.setText("Month");

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refreshicon24.png"))); // NOI18N
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGradeLayout = new javax.swing.GroupLayout(pnlGrade);
        pnlGrade.setLayout(pnlGradeLayout);
        pnlGradeLayout.setHorizontalGroup(
            pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGradeLayout.createSequentialGroup()
                .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGradeLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2))
                    .addGroup(pnlGradeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTimeCode, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(cmbGrade, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        pnlGradeLayout.setVerticalGroup(
            pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGradeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlGradeLayout.createSequentialGroup()
                        .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTimeCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tblInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Invoice#", "Student#", "Name", "Issue Date", "Amount", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInvoiceMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInvoice);
        tblInvoice.getColumnModel().getColumn(0).setResizable(false);
        tblInvoice.getColumnModel().getColumn(1).setResizable(false);
        tblInvoice.getColumnModel().getColumn(3).setResizable(false);
        tblInvoice.getColumnModel().getColumn(4).setResizable(false);
        tblInvoice.getColumnModel().getColumn(5).setResizable(false);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel3.setText("Student ID");

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refreshicon24.png"))); // NOI18N
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report01_48.png"))); // NOI18N
        jButton3.setText("Build Report");
        jButton3.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfStudentID, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addComponent(jLabel3)))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tfTitle.setBackground(new java.awt.Color(255, 255, 204));
        tfTitle.setEditable(false);
        tfTitle.setFont(new java.awt.Font("Dialog", 1, 12));
        tfTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfTitle.setBorder(null);
        tfTitle.setDisabledTextColor(new java.awt.Color(0, 0, 51));
        tfTitle.setEnabled(false);

        pnlByDate.setBackground(new java.awt.Color(204, 255, 204));

        jLabel4.setText("Date (From)");

        jLabel5.setText("Date (To)");

        btnSearchByDate.setBackground(new java.awt.Color(204, 204, 255));
        btnSearchByDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refreshicon24.png"))); // NOI18N
        btnSearchByDate.setOpaque(false);
        btnSearchByDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlByDateLayout = new javax.swing.GroupLayout(pnlByDate);
        pnlByDate.setLayout(pnlByDateLayout);
        pnlByDateLayout.setHorizontalGroup(
            pnlByDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlByDateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlByDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlByDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(btnSearchByDate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnlByDateLayout.setVerticalGroup(
            pnlByDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlByDateLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlByDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchByDate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlByDateLayout.createSequentialGroup()
                        .addGroup(pnlByDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlByDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlByDateLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel5))
                            .addComponent(tfDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel6.setText("Total Amount");

        jLabel7.setText("Paid");

        jLabel8.setText("Unpaid");

        jLabel9.setText("Part Paid");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlByDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTotalPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTotalUnpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTotalPartPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlByDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlGrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tfTotalPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(tfTotalUnpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(tfTotalPartPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String gradeID = (String) cmbGrade.getSelectedItem();
        String timeCode = cmbTimeCode.getTimeCode();
        this.getInvoiceRecord(timeCode, gradeID);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInvoiceMouseClicked
        // TODO add your handling code here:
        int clickCount = evt.getClickCount();
        if (clickCount == 2) {
            int i = tblInvoice.getSelectedRow();
            String invoiceID = (String) tblInvoice.getValueAt(i, 0);
            String studentID = (String) tblInvoice.getValueAt(i, 1);
            String issueDate = (String) tblInvoice.getValueAt(i, 2);
            String amount = (String) tblInvoice.getValueAt(i, 3);
            String status = (String) tblInvoice.getValueAt(i, 4);

            
                FInvoiceSimpleView fp = new FInvoiceSimpleView(invoiceID);
                fp.setVisible(true);
            

        }
    }//GEN-LAST:event_tblInvoiceMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String studentID = tfStudentID.getText();
        this.getInvoiceRecordStudent(studentID);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSearchByDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByDateActionPerformed
        // TODO add your handling code here:
        String dateFrom = tfDateFrom.getSQLDate();
        String dateTo = tfDateTo.getSQLDate();
        this.getInvoiceRecordDate(dateFrom, dateTo);
        //this.getVoucherByDate(dateFrom, dateTo);
}//GEN-LAST:event_btnSearchByDateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FInvoiceReporting().setVisible(true);
            }
        });
    }

    public void getInvoiceRecord(String timeCode, String gradeID) {
        DefaultTableModel model = (DefaultTableModel) tblInvoice.getModel();
        model.setRowCount(0);
        double totalPaid = 0;
        double totalUnpaid = 0;
        double totalPartialPaid = 0;
        double totalAmount = 0;

        String query = "SELECT INVOICE_ID, STUDENT_ID, ISSUE_DATE,"
                + "INVOICE_TOTAL FROM MONTHLYINVOICEISSUED WHERE "
                + "TIME_CODE LIKE '" + timeCode + "' AND "
                + "GRADE_ID LIKE '" + gradeID + "'";

        String title = "Invoices Issued: Month(" + cmbTimeCode.getMonthName() + ", " + cmbTimeCode.getYear() + ")"
                + " Grade/Class (" + gradeID + ")";

        tfTitle.setText(title);

        ArrayList al = gdb.searchRecord(query);
        Iterator i = al.iterator();
        while (i.hasNext()) {

            Vector v = (Vector) i.next();
            String invoiceStatus = getInvoiceStatus((String) v.get(0));
            String name = getStudentName((String) v.get(1));

            String amount = (String) v.get(3);

            try{totalAmount+=Double.parseDouble(amount);}catch(Exception fe){}

            if (invoiceStatus.compareToIgnoreCase("PAID") == 0) {
                try {
                    totalPaid += Double.parseDouble(amount);
                }catch (Exception e) {
                }
            }

            if (invoiceStatus.compareToIgnoreCase("UNPAID") == 0) {
                try {
                    totalUnpaid += Double.parseDouble(amount);
                }catch (Exception e) {
                }
            }

            if (invoiceStatus.compareToIgnoreCase("PARTIAL PAID") == 0) {
                try {
                    totalPartialPaid += Double.parseDouble(amount);
                }catch (Exception e) {
                }
            }




            Vector row = new Vector();
            row.add((String) v.get(0));
            row.add((String) v.get(1));
            row.add(name);
            row.add((String) v.get(2));
            row.add((String) v.get(3));
            row.add(invoiceStatus);
            model.addRow(row);
        }

        tfTotalAmount.setText(Double.toString(totalAmount));
        tfTotalPaid.setText(Double.toString(totalPaid));
        tfTotalUnpaid.setText(Double.toString(totalUnpaid));
        tfTotalPartPaid.setText(Double.toString(totalPartialPaid));




    }

    public void getInvoiceRecordStudent(String studentID) {
        DefaultTableModel model = (DefaultTableModel) tblInvoice.getModel();
        model.setRowCount(0);
        String query = "SELECT INVOICE_ID, STUDENT_ID, ISSUE_DATE,"
                + "INVOICE_TOTAL FROM MONTHLYINVOICEISSUED WHERE "
                + "STUDENT_ID LIKE '" + studentID + "'";

        String title = "Invoices Issued To: ("+studentID+" - "+getStudentName(studentID)+")" ;

        tfTitle.setText(title);

        double totalPaid = 0;
        double totalUnpaid = 0;
        double totalPartialPaid = 0;
        double totalAmount = 0;

        ArrayList al = gdb.searchRecord(query);
        Iterator i = al.iterator();
        while (i.hasNext()) {
            Vector v = (Vector) i.next();
            String invoiceStatus = getInvoiceStatus((String) v.get(0));
            String name = getStudentName((String) v.get(1));

                String amount = (String) v.get(3);

            try{totalAmount+=Double.parseDouble(amount);}catch(Exception fe){}

            if (invoiceStatus.compareToIgnoreCase("PAID") == 0) {
                try {
                    totalPaid += Double.parseDouble(amount);
                }catch (Exception e) {
                }
            }

            if (invoiceStatus.compareToIgnoreCase("UNPAID") == 0) {
                try {
                    totalUnpaid += Double.parseDouble(amount);
                }catch (Exception e) {
                }
            }

            if (invoiceStatus.compareToIgnoreCase("PARTIAL PAID") == 0) {
                try {
                    totalPartialPaid += Double.parseDouble(amount);
                }catch (Exception e) {
                }
            }



            Vector row = new Vector();
            row.add((String) v.get(0));
            row.add((String) v.get(1));
            row.add(name);
            row.add((String) v.get(2));
            row.add((String) v.get(3));
            row.add(invoiceStatus);
            model.addRow(row);
        }

        tfTotalAmount.setText(Double.toString(totalAmount));
        tfTotalPaid.setText(Double.toString(totalPaid));
        tfTotalUnpaid.setText(Double.toString(totalUnpaid));
        tfTotalPartPaid.setText(Double.toString(totalPartialPaid));

    }


     public void getInvoiceRecordDate(String dateFrom, String dateTo) {
        DefaultTableModel model = (DefaultTableModel) tblInvoice.getModel();
        model.setRowCount(0);
        String query = "SELECT INVOICE_ID, STUDENT_ID, ISSUE_DATE,"
                + "INVOICE_TOTAL FROM MONTHLYINVOICEISSUED WHERE "
                + "ISSUE_DATE BETWEEN '"+dateFrom+"' AND '"+dateTo+"'";
                

        String dFrom = tfDateFrom.getText();
        String dTo = tfDateTo.getText();
        String title = "Invoices Issued: FROM ("+dFrom+") To ("+dTo+")";

        tfTitle.setText(title);

        double totalPaid = 0;
        double totalUnpaid = 0;
        double totalPartialPaid = 0;
        double totalAmount = 0;

        ArrayList al = gdb.searchRecord(query);
        Iterator i = al.iterator();
        while (i.hasNext()) {
            Vector v = (Vector) i.next();
            String invoiceStatus = getInvoiceStatus((String) v.get(0));
            String name = getStudentName((String) v.get(1));

                String amount = (String) v.get(3);

            try{totalAmount+=Double.parseDouble(amount);}catch(Exception fe){}

            if (invoiceStatus.compareToIgnoreCase("PAID") == 0) {
                try {
                    totalPaid += Double.parseDouble(amount);
                }catch (Exception e) {
                }
            }

            if (invoiceStatus.compareToIgnoreCase("UNPAID") == 0) {
                try {
                    totalUnpaid += Double.parseDouble(amount);
                }catch (Exception e) {
                }
            }

            if (invoiceStatus.compareToIgnoreCase("PARTIAL PAID") == 0) {
                try {
                    totalPartialPaid += Double.parseDouble(amount);
                }catch (Exception e) {
                }
            }



            Vector row = new Vector();
            row.add((String) v.get(0));
            row.add((String) v.get(1));
            row.add(name);
            row.add((String) v.get(2));
            row.add((String) v.get(3));
            row.add(invoiceStatus);
            model.addRow(row);
        }

        tfTotalAmount.setText(Double.toString(totalAmount));
        tfTotalPaid.setText(Double.toString(totalPaid));
        tfTotalUnpaid.setText(Double.toString(totalUnpaid));
        tfTotalPartPaid.setText(Double.toString(totalPartialPaid));

    }


    public String getInvoiceStatus(String invoiceID) {
        String invoiceAmount = this.getInvoiceAmount(invoiceID);
        String amountPaid = this.getAmountPaid(invoiceID);
        String status = "";

        double ia = 0;
        double ap = 0;

        try {
            ia = Double.parseDouble(invoiceAmount);
        } catch (Exception e) {
            ia = 0;
        }

        try {
            ap = Double.parseDouble(amountPaid);
        } catch (Exception e) {
            ap = 0;
        }

        if (ia == ap) {
            status = "PAID";
        } else if (ap < ia && ap > 0) {
            status = "PARTIAL PAID";
        } else if (ap <= 0) {
            status = "UNPAID";
        }

        return status;

    }

    public String getInvoiceAmount(String invoiceID) {

        String query = "SELECT INVOICE_TOTAL FROM MONTHLYINVOICEISSUED "
                + "WHERE INVOICE_ID LIKE '" + invoiceID + "'";

        String amount = gdb.getSingleColumnData(query);

        return amount;

    }

    public String getStudentName(String studentID) {
        String name = "";
        String query = "SELECT FULL_NAME FROM STUDENT WHERE STUDENT_ID "
                + "LIKE '" + studentID + "'";
        name = gdb.getSingleColumnData(query);
        return name;
    }

    public String getAmountPaid(String invoiceID) {
        String amountPaid = "0";
        String query = "SELECT SUM(PAYMENTAMOUNT) FROM PAYMENT WHERE "
                + "INVOICEID LIKE '" + invoiceID + "'";
        amountPaid = gdb.getSingleColumnData(query);
        return amountPaid;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearchByDate;
    private mysd.CCMBGrade cmbGrade;
    private mysd.CCMBTimeCode cmbTimeCode;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlByDate;
    private javax.swing.JPanel pnlGrade;
    private javax.swing.JTable tblInvoice;
    private acr.component.CDateField tfDateFrom;
    private acr.component.CDateField tfDateTo;
    private acr.component.CAlphaNumericField tfStudentID;
    private javax.swing.JTextField tfTitle;
    private javax.swing.JTextField tfTotalAmount;
    private javax.swing.JTextField tfTotalPaid;
    private javax.swing.JTextField tfTotalPartPaid;
    private javax.swing.JTextField tfTotalUnpaid;
    // End of variables declaration//GEN-END:variables
}