/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package popUps;

import Main.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import settings.GlassPanePopup;

/**
 *
 * @author jairus
 */
public class resetPasswordMsg extends javax.swing.JPanel {

    /**
     * Creates new form resetPasswordMsg
     */
    public resetPasswordMsg() {
        initComponents();
        setOpaque(false);
        txt.setBackground(new Color(0, 0, 0, 0));
        txt.setOpaque(false);
        txt1.setText(forgotPasswordMsg.storedEmail);
        newPassField.setEchoChar('•');
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        g2.dispose();
        super.paintComponent(grphcs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt = new javax.swing.JLabel();
        cmdCancel = new components.RoundedButtons();
        setNewPassBtn = new components.RoundedButtons();
        txt1 = new javax.swing.JLabel();
        newPassField = new components.PasswordField();
        showNewPass = new components.JCheckBoxCustom();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 106, 191));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reset your password!");

        txt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txt.setForeground(new java.awt.Color(102, 102, 102));
        txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt.setText("Enter your new password for the account:");

        cmdCancel.setBackground(new java.awt.Color(191, 50, 50));
        cmdCancel.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel.setText("Cancel");
        cmdCancel.setBorderColor(new java.awt.Color(191, 50, 50));
        cmdCancel.setBorderPainted(false);
        cmdCancel.setColor(new java.awt.Color(191, 50, 50));
        cmdCancel.setColorClick(new java.awt.Color(191, 50, 50));
        cmdCancel.setColorOver(new java.awt.Color(191, 50, 50));
        cmdCancel.setFocusPainted(false);
        cmdCancel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        setNewPassBtn.setBackground(new java.awt.Color(70, 191, 50));
        setNewPassBtn.setForeground(new java.awt.Color(255, 255, 255));
        setNewPassBtn.setText("Confirm");
        setNewPassBtn.setBorderColor(new java.awt.Color(70, 191, 50));
        setNewPassBtn.setBorderPainted(false);
        setNewPassBtn.setColor(new java.awt.Color(70, 191, 50));
        setNewPassBtn.setColorClick(new java.awt.Color(70, 191, 50));
        setNewPassBtn.setColorOver(new java.awt.Color(70, 191, 50));
        setNewPassBtn.setFocusPainted(false);
        setNewPassBtn.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        setNewPassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setNewPassBtnActionPerformed(evt);
            }
        });

        txt1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt1.setForeground(new java.awt.Color(102, 102, 102));
        txt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt1.setText("@gmail.com");

        newPassField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        newPassField.setLabelText("");
        newPassField.setSelectionColor(new java.awt.Color(204, 204, 204));
        newPassField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPassFieldActionPerformed(evt);
            }
        });

        showNewPass.setForeground(new java.awt.Color(153, 153, 153));
        showNewPass.setText("Show Password");
        showNewPass.setFocusPainted(false);
        showNewPass.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        showNewPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showNewPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(showNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newPassField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 5, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(setNewPassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt)
                .addGap(3, 3, 3)
                .addComponent(txt1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setNewPassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setNewPassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setNewPassBtnActionPerformed
        if (!newPassField.getText().isEmpty()) {

            try {

                Statement s = Main.getDbCon().createStatement();
                int rowsAffected = s.executeUpdate("UPDATE users SET password = '" + newPassField.getText() + "' WHERE email = '" + forgotPasswordMsg.storedEmail + "'");

                // Check if any rows were affected by the update
                if (rowsAffected > 0) {
                    forgotPasswordMsg.storedEmail = "";
                    GlassPanePopup.closePopupLast();
                    resetPassMsg obj9 = new resetPassMsg();
                    GlassPanePopup.showPopup(obj9);
                } else {
                    JOptionPane.showMessageDialog(null, "No records were updated. Please check the email address and try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Close the ResultSet
                s.close();

            } catch (SQLException e) {
                e.printStackTrace(); // Print the exception details for debugging
                JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                Main.closeCon();

            }
        }
    }//GEN-LAST:event_setNewPassBtnActionPerformed

    private void newPassFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPassFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPassFieldActionPerformed

    private void showNewPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showNewPassActionPerformed
        if (showNewPass.isSelected()) {
            newPassField.setEchoChar((char) 0);
        } else {
            newPassField.setEchoChar('•');
        }
    }//GEN-LAST:event_showNewPassActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_cmdCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.RoundedButtons cmdCancel;
    private javax.swing.JLabel jLabel1;
    private components.PasswordField newPassField;
    private components.RoundedButtons setNewPassBtn;
    private components.JCheckBoxCustom showNewPass;
    private javax.swing.JLabel txt;
    private javax.swing.JLabel txt1;
    // End of variables declaration//GEN-END:variables
}
