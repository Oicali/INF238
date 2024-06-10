package popUps;

import Main.Main;
import Main.home;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import javax.swing.JOptionPane;
import otherForms.Form7;
import otherForms.Notifications;
import settings.GlassPanePopup;

public class changePassword extends javax.swing.JPanel {

//    private boolean isOPShowing = false;
//    private boolean isNPShowing = false;
//    private boolean isCPShowing = false;
    
    public changePassword() {
        initComponents();
        setOpaque(false);
        cmdCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        changePassBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
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

        cmdCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        OPField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        NPField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        CPField = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        changePassBtn = new components.RoundedButtons();
        lbl = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Change your Password!");

        OPField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        OPField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        OPField.setSelectionColor(new java.awt.Color(204, 204, 204));
        OPField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OPFieldMouseClicked(evt);
            }
        });
        OPField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                OPFieldKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Old Password:");

        NPField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        NPField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        NPField.setSelectionColor(new java.awt.Color(204, 204, 204));
        NPField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NPFieldMouseClicked(evt);
            }
        });
        NPField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NPFieldKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("New Password:");

        CPField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        CPField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        CPField.setSelectionColor(new java.awt.Color(204, 204, 204));
        CPField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CPFieldMouseClicked(evt);
            }
        });
        CPField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CPFieldKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Confirm New Password:");

        changePassBtn.setBackground(new java.awt.Color(15, 106, 191));
        changePassBtn.setForeground(new java.awt.Color(255, 255, 255));
        changePassBtn.setText("Change");
        changePassBtn.setBorderColor(new java.awt.Color(15, 106, 191));
        changePassBtn.setBorderPainted(false);
        changePassBtn.setColor(new java.awt.Color(15, 106, 191));
        changePassBtn.setColorClick(new java.awt.Color(15, 106, 191));
        changePassBtn.setColorOver(new java.awt.Color(15, 106, 191));
        changePassBtn.setFocusPainted(false);
        changePassBtn.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        changePassBtn.setPreferredSize(new java.awt.Dimension(97, 38));
        changePassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassBtnActionPerformed(evt);
            }
        });

        lbl.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbl.setForeground(new java.awt.Color(255, 0, 0));
        lbl.setText(" ");

        lbl2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbl2.setForeground(new java.awt.Color(255, 51, 51));
        lbl2.setText(" ");

        lbl3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbl3.setForeground(new java.awt.Color(255, 51, 0));
        lbl3.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(129, 129, 129))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(changePassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                .addComponent(CPField)
                                .addComponent(NPField)
                                .addComponent(OPField)
                                .addComponent(lbl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(0, 43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(OPField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(NPField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(lbl2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CPField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(changePassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void changePassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePassBtnActionPerformed
        lbl.setText(" ");
        lbl2.setText(" ");
        lbl3.setText(" ");

        String oldPassword = OPField.getText();
        String newPassword = NPField.getText();
        String confirmPassword = CPField.getText();

        if (OPField.getText().isEmpty() & NPField.getText().isEmpty() & CPField.getText().isEmpty()) {
            //JOptionPane.showMessageDialog(null, "Please complete all fields!", "", JOptionPane.ERROR_MESSAGE);
            lbl.setText("Please complete this field!");
            lbl2.setText("Please complete this field!");
            lbl3.setText("Please complete this field!");
        } else if (NPField.getText().isEmpty() & CPField.getText().isEmpty()) {
            lbl2.setText("Please complete this field!");
            lbl3.setText("Please complete this field!");
        } else if (OPField.getText().isEmpty() & CPField.getText().isEmpty()) {
            lbl.setText("Please complete this field!");
            lbl3.setText("Please complete this field!");
        } else if (OPField.getText().isEmpty() & NPField.getText().isEmpty()) {
            lbl.setText("Please complete this field!");
            lbl2.setText("Please complete this field!");
        } else if (OPField.getText().isEmpty()) {
            lbl.setText("Please complete this field!");
        } else if (NPField.getText().isEmpty()) {
            lbl2.setText("Please complete this field!");
        } else if (CPField.getText().isEmpty()) {
            lbl3.setText("Please complete this field!");
        } else {
            if (oldPassword.equals(Main.getStoredPassword())) {
                if (!oldPassword.equals(newPassword)) {
                    if (NPField.getText().trim().length() < 8) {
                        lbl2.setText("Password must be at least 8 Characters!");
                        NPField.requestFocus();
                    } else {

                        if (newPassword.equals(confirmPassword)) {
                            try {
                                // Create a statement
                                Statement s = Main.getDbCon().createStatement();
                                int rowsAffected = s.executeUpdate("UPDATE users SET password = '" + newPassword + "' WHERE username = '" + Main.username + "'");

                                if (rowsAffected > 0) {
                                    Main.setStoredPassword(newPassword);
                                    home.form7Profile = new Form7(Main.username);
                                    home.setForm(home.form7Profile);
                                    GlassPanePopup.closePopupLast();
                                    home.successChangePassword.showNotification();

                                } else {
                                    System.out.println("No rows were updated. Check if the password is correct.");
                                }

                                // Close the statement
                                s.close();
                            } catch (SQLException e) {
                                e.printStackTrace(); // Print the exception details for debugging
                                JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                            } finally {
                                Main.closeCon(); // Ensure the connection is closed
                            }
                        } else {
                            lbl3.setText("New password does not match!");
                            //JOptionPane.showMessageDialog(null, "New Password does not match!", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    lbl2.setText("Cannot be the same as old password!");
                    //JOptionPane.showMessageDialog(null, "New password must not be the\n  same as your old password!", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                lbl.setText("Wrong Old Password!");
            }
        }


    }//GEN-LAST:event_changePassBtnActionPerformed

    private void OPFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OPFieldMouseClicked
        lbl.setText(" ");
        lbl2.setText(" ");
        lbl3.setText(" ");
    }//GEN-LAST:event_OPFieldMouseClicked

    private void NPFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NPFieldMouseClicked
        lbl.setText(" ");
        lbl2.setText(" ");
        lbl3.setText(" ");
    }//GEN-LAST:event_NPFieldMouseClicked

    private void CPFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CPFieldMouseClicked
        lbl.setText(" ");
        lbl2.setText(" ");
        lbl3.setText(" ");
    }//GEN-LAST:event_CPFieldMouseClicked

    private void OPFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OPFieldKeyTyped
        char keyChar = evt.getKeyChar();
        
        if (!Character.isDigit(keyChar) && !Character.isLetter(keyChar) && !isSpecialCharacter(keyChar)) {
            evt.consume();
        }
    }//GEN-LAST:event_OPFieldKeyTyped

    private void NPFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NPFieldKeyTyped
        char keyChar = evt.getKeyChar();
        
        if (!Character.isDigit(keyChar) && !Character.isLetter(keyChar) && !isSpecialCharacter(keyChar)) {
            evt.consume();
        }
    }//GEN-LAST:event_NPFieldKeyTyped

    private void CPFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CPFieldKeyTyped
        char keyChar = evt.getKeyChar();
        
        if (!Character.isDigit(keyChar) && !Character.isLetter(keyChar) && !isSpecialCharacter(keyChar)) {
            evt.consume();
        }
    }//GEN-LAST:event_CPFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField CPField;
    private javax.swing.JPasswordField NPField;
    private javax.swing.JPasswordField OPField;
    private components.RoundedButtons changePassBtn;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    // End of variables declaration//GEN-END:variables
}
