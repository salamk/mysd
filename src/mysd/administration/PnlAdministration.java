/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PnlAdministration.java
 *
 * Created on Feb 5, 2011, 7:43:25 AM
 */

package mysd.administration;

/**
 *
 * @author salam
 */
public class PnlAdministration extends javax.swing.JPanel {

    private AdminController controller;
    /** Creates new form PnlAdministration */
    public PnlAdministration() {
        initComponents();
        controller = new AdminController();
    }
 
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnPrintUserInfo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnUpdateUser = new javax.swing.JButton();
        btnAssignRights = new javax.swing.JButton();
        btnViewUserInfo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnPrintCampusInformation = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnNewCampus = new javax.swing.JButton();
        btnNewClassRoom = new javax.swing.JButton();
        btnViewCampus = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Assign/Update User Privileges");

        btnPrintUserInfo.setBackground(new java.awt.Color(204, 204, 255));
        btnPrintUserInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/print32.png"))); // NOI18N
        btnPrintUserInfo.setFocusable(false);
        btnPrintUserInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrintUserInfo.setOpaque(false);
        btnPrintUserInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("View User Information");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Print Users Report");

        btnUpdateUser.setBackground(new java.awt.Color(204, 204, 255));
        btnUpdateUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/useradd32.png"))); // NOI18N
        btnUpdateUser.setFocusable(false);
        btnUpdateUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdateUser.setOpaque(false);
        btnUpdateUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateUserActionPerformed(evt);
            }
        });

        btnAssignRights.setBackground(new java.awt.Color(204, 204, 255));
        btnAssignRights.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/userrole32.png"))); // NOI18N
        btnAssignRights.setFocusable(false);
        btnAssignRights.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAssignRights.setOpaque(false);
        btnAssignRights.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAssignRights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignRightsActionPerformed(evt);
            }
        });

        btnViewUserInfo.setBackground(new java.awt.Color(204, 204, 255));
        btnViewUserInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view32.png"))); // NOI18N
        btnViewUserInfo.setFocusable(false);
        btnViewUserInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewUserInfo.setOpaque(false);
        btnViewUserInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnViewUserInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewUserInfoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Add/Update a User Account");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPrintUserInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnViewUserInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAssignRights, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(btnUpdateUser, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAssignRights, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewUserInfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrintUserInfo))
                .addGap(73, 73, 73))
        );

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("New Class Room Addition");

        btnPrintCampusInformation.setBackground(new java.awt.Color(204, 204, 255));
        btnPrintCampusInformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/print32.png"))); // NOI18N
        btnPrintCampusInformation.setFocusable(false);
        btnPrintCampusInformation.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrintCampusInformation.setOpaque(false);
        btnPrintCampusInformation.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("View Campus Information");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setText("Print Campus Report");

        btnNewCampus.setBackground(new java.awt.Color(204, 204, 255));
        btnNewCampus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/building_add32.png"))); // NOI18N
        btnNewCampus.setFocusable(false);
        btnNewCampus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNewCampus.setOpaque(false);
        btnNewCampus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNewCampus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCampusActionPerformed(evt);
            }
        });

        btnNewClassRoom.setBackground(new java.awt.Color(204, 204, 255));
        btnNewClassRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/classroom32.png"))); // NOI18N
        btnNewClassRoom.setFocusable(false);
        btnNewClassRoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNewClassRoom.setOpaque(false);
        btnNewClassRoom.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNewClassRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewClassRoomActionPerformed(evt);
            }
        });

        btnViewCampus.setBackground(new java.awt.Color(204, 204, 255));
        btnViewCampus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/view32.png"))); // NOI18N
        btnViewCampus.setFocusable(false);
        btnViewCampus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewCampus.setOpaque(false);
        btnViewCampus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnViewCampus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewCampusActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel10.setText("New Campus Addition");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNewClassRoom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNewCampus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnViewCampus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnPrintCampusInformation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewCampus)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNewClassRoom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewCampus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrintCampusInformation))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUserActionPerformed
        // TODO add your handling code here:
        controller.addUpdateUser();
    }//GEN-LAST:event_btnUpdateUserActionPerformed

    private void btnAssignRightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignRightsActionPerformed
        // TODO add your handling code here:
        controller.updateRights();
    }//GEN-LAST:event_btnAssignRightsActionPerformed

    private void btnViewUserInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewUserInfoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnViewUserInfoActionPerformed

    private void btnNewCampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCampusActionPerformed
        // TODO add your handling code here:
        controller.addNewBuilding();
    }//GEN-LAST:event_btnNewCampusActionPerformed

    private void btnNewClassRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewClassRoomActionPerformed
        // TODO add your handling code here:
        controller.addNewClassRoom();
    }//GEN-LAST:event_btnNewClassRoomActionPerformed

    private void btnViewCampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewCampusActionPerformed
        // TODO add your handling code here:
        controller.viewCampusInfo();
    }//GEN-LAST:event_btnViewCampusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnAssignRights;
    protected javax.swing.JButton btnNewCampus;
    protected javax.swing.JButton btnNewClassRoom;
    protected javax.swing.JButton btnPrintCampusInformation;
    protected javax.swing.JButton btnPrintUserInfo;
    protected javax.swing.JButton btnUpdateUser;
    protected javax.swing.JButton btnViewCampus;
    protected javax.swing.JButton btnViewUserInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
