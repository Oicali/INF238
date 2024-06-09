package popUps;

import Main.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import settings.GlassPanePopup;

public class resetPasswordMsg extends javax.swing.JPanel {

    public resetPasswordMsg() {
        initComponents();
        setOpaque(false);
        txt.setBackground(new Color(0, 0, 0, 0));
        txt.setOpaque(false);
        txt1.setText(forgotPasswordMsg.storedEmail);
        newPassField.setEchoChar('•');
        cmdCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        setNewPassBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private boolean isSpecialCharacter(char c) {
        String specialChars = "!@#$%^&*()-_+=<>?/|\\{}[]~`";
        return specialChars.indexOf(c) >= 0;
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
        setNewPassBtn = new components.RoundedButtons();
        txt1 = new javax.swing.JLabel();
        newPassField = new components.PasswordField();
        showNewPass = new components.JCheckBoxCustom();
        lbl = new javax.swing.JLabel();
        cmdCancel = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 106, 191));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reset your password!");

        txt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txt.setForeground(new java.awt.Color(102, 102, 102));
        txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt.setText("Enter your new password for the account:");

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
        newPassField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newPassFieldKeyTyped(evt);
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

        lbl.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbl.setForeground(new java.awt.Color(255, 0, 0));
        lbl.setText(" ");

        cmdCancel.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        cmdCancel.setForeground(new java.awt.Color(153, 153, 153));
        cmdCancel.setText("X");
        cmdCancel.setBorderPainted(false);
        cmdCancel.setContentAreaFilled(false);
        cmdCancel.setFocusPainted(false);
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(setNewPassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(showNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newPassField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 5, Short.MAX_VALUE)))
                        .addGap(53, 53, 53))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt)
                .addGap(3, 3, 3)
                .addComponent(txt1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(setNewPassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setNewPassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setNewPassBtnActionPerformed
        if (newPassField.getText().length() < 8) {
            lbl.setText("Password must be at least 8 characters!");
        } else {
            try {
                lbl.setText(" ");
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

    private void showNewPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showNewPassActionPerformed
        if (showNewPass.isSelected()) {
            newPassField.setEchoChar((char) 0);
        } else {
            newPassField.setEchoChar('•');
        }
    }//GEN-LAST:event_showNewPassActionPerformed

    private void newPassFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newPassFieldKeyTyped
        char keyChar = evt.getKeyChar();

        if (!Character.isDigit(keyChar) && !Character.isLetter(keyChar) && !isSpecialCharacter(keyChar)) {
            evt.consume();
        }
    }//GEN-LAST:event_newPassFieldKeyTyped

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void newPassFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPassFieldActionPerformed
        lbl.setText(" ");
    }//GEN-LAST:event_newPassFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl;
    private components.PasswordField newPassField;
    private components.RoundedButtons setNewPassBtn;
    private components.JCheckBoxCustom showNewPass;
    private javax.swing.JLabel txt;
    private javax.swing.JLabel txt1;
    // End of variables declaration//GEN-END:variables
}
