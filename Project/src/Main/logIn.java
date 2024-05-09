/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.metal.MetalButtonUI;
import msgPopup.forgotPasswordMsg;
import msgPopup.forgotUsernameMsg;
import settings.GlassPanePopup;

public class logIn extends javax.swing.JFrame {

    ImageIcon image = new ImageIcon("C:\\Users\\Marilou Ilacio\\Documents\\NetBeansProjects\\OOP_Project\\src\\resources\\logoSmall.png");
    public static boolean isUserEmpty = true;
    public static boolean isPassEmpty = true;

    public logIn() {
        initComponents();
        setIconImage(image.getImage());
        GlassPanePopup.install(this);
        passField.setEchoChar('•');
        JDialog.setDefaultLookAndFeelDecorated(true);

        logInBtn.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return new Color(15, 106, 191);
            }
        });

        usernameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLoginButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLoginButton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLoginButton();
            }

            // Method to enable/disable the login button based on the PIN length
            private void updateLoginButton() {

                String usernameText = usernameField.getText().trim();
                if (usernameText.length() == 0) {
                    isUserEmpty = true;
                } else {
                    isUserEmpty = false;
                }

                logInBtn.setEnabled(!isUserEmpty && !isPassEmpty);
            }
        });

        passField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLoginButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLoginButton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLoginButton();
            }

            // Method to enable/disable the login button based on the PIN length
            private void updateLoginButton() {

                String passText = passField.getText().trim();
                if (passText.length() == 0) {
                    isPassEmpty = true;
                } else {
                    isPassEmpty = false;
                }

                logInBtn.setEnabled(!isUserEmpty && !isPassEmpty);
            }
        });

        // Create a rounded frame
        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        setShape(roundedRectangle);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        userIcon = new javax.swing.JLabel();
        forgotUser = new javax.swing.JButton();
        forgotPass = new javax.swing.JButton();
        License = new javax.swing.JButton();
        logInErrorMessage = new javax.swing.JLabel();
        passField = new components.PasswordField();
        usernameField = new components.TextField();
        selectRole = new components.Combobox();
        logInBtn = new components.RoundedButtons();
        showPass = new components.JCheckBoxCustom();
        closeBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log In");
        setMaximumSize(new java.awt.Dimension(1250, 750));
        setMinimumSize(new java.awt.Dimension(1250, 750));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        forgotUser.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        forgotUser.setForeground(new java.awt.Color(153, 153, 153));
        forgotUser.setText("Forgot Username?");
        forgotUser.setBorderPainted(false);
        forgotUser.setContentAreaFilled(false);
        forgotUser.setFocusPainted(false);
        forgotUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotUserActionPerformed(evt);
            }
        });

        forgotPass.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        forgotPass.setForeground(new java.awt.Color(153, 153, 153));
        forgotPass.setText("Forgot Password?");
        forgotPass.setBorderPainted(false);
        forgotPass.setContentAreaFilled(false);
        forgotPass.setFocusPainted(false);
        forgotPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotPassActionPerformed(evt);
            }
        });

        License.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        License.setForeground(new java.awt.Color(153, 153, 153));
        License.setText("@Mark-It! 2024");
        License.setBorderPainted(false);
        License.setContentAreaFilled(false);
        License.setFocusPainted(false);
        License.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        logInErrorMessage.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        logInErrorMessage.setForeground(new java.awt.Color(255, 51, 51));
        logInErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logInErrorMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        passField.setSelectionColor(new java.awt.Color(204, 204, 204));
        passField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passFieldMousePressed(evt);
            }
        });

        usernameField.setSelectionColor(new java.awt.Color(204, 204, 204));
        usernameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usernameFieldMousePressed(evt);
            }
        });

        selectRole.setMaximumRowCount(3);
        selectRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "Supervisor", "Employee" }));
        selectRole.setSelectedIndex(2);
        selectRole.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        selectRole.setLabelText("Logging in as");
        selectRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectRoleMousePressed(evt);
            }
        });
        selectRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectRoleActionPerformed(evt);
            }
        });

        logInBtn.setForeground(new java.awt.Color(15, 106, 191));
        logInBtn.setText("Log In");
        logInBtn.setBorderColor(new java.awt.Color(15, 106, 191));
        logInBtn.setBorderPainted(false);
        logInBtn.setColorClick(new java.awt.Color(153, 153, 153));
        logInBtn.setColorOver(new java.awt.Color(204, 204, 204));
        logInBtn.setEnabled(false);
        logInBtn.setFocusPainted(false);
        logInBtn.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        logInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInBtnActionPerformed(evt);
            }
        });

        showPass.setForeground(new java.awt.Color(153, 153, 153));
        showPass.setText("Show Password");
        showPass.setFocusPainted(false);
        showPass.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        showPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassActionPerformed(evt);
            }
        });

        closeBtn.setFont(new java.awt.Font("Arial Black", 1, 30)); // NOI18N
        closeBtn.setForeground(new java.awt.Color(15, 106, 191));
        closeBtn.setText("X");
        closeBtn.setBorderPainted(false);
        closeBtn.setContentAreaFilled(false);
        closeBtn.setFocusPainted(false);
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logInUser.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(showPass, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(selectRole, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(License, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(logInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(80, 80, 80)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(logInErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(forgotUser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(forgotPass, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(userIcon))
                        .addGap(163, 163, 163))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(35, 35, 35)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forgotUser)
                .addGap(24, 24, 24)
                .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showPass, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forgotPass))
                .addGap(39, 39, 39)
                .addComponent(selectRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(logInErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(logInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(License, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jPanel2.setBackground(new java.awt.Color(15, 106, 191));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Log In to your Account");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(80, 220, 540, 80);
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 810, 0);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logInBg.png"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 0, 800, 750);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInBtnActionPerformed
        Main.username = usernameField.getText();
        String password = passField.getText();
        Main.selectedRole = (String) selectRole.getSelectedItem();

        //Connection con = InventorySystem.getDbCon();
        boolean accountNotFound = true;
        try {

            Statement s = Main.getDbCon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM users WHERE userName = '" + Main.username + "' AND userRole = '" + Main.selectedRole + "' AND status = 'Active'");

            while (rs.next()) {
                accountNotFound = false;
                Main.storedPassword = rs.getString("password"); // Get the stored password from the database
                Main.fullname = rs.getString("name");
                Main.number = rs.getString("mobileNumber");
                Main.email = rs.getString("email");
                //Main.birth = rs.getString("birthDate");
                //Main.gender = rs.getString("gender");
                Main.username = rs.getString("userName");
                //Main.date = rs.getString("entryDate");
            }

            if (password.equals(Main.storedPassword)) {
                dispose();
                new home(Main.selectedRole).show();
            } else {
                logInErrorMessage.setText("Invalid Password!");
            }

            // Close the ResultSet
            rs.close();
            s.close();

            if (accountNotFound) {
                logInErrorMessage.setText("Account not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception details for debugging
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            Main.closeCon();
            /*try {
                // Close the Connection
                if (InventorySystem.getDbCon()!= null) {
                    InventorySystem.getDbCon().close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }*/
        }


    }//GEN-LAST:event_logInBtnActionPerformed

    private void usernameFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameFieldMousePressed
        logInErrorMessage.setText("");
    }//GEN-LAST:event_usernameFieldMousePressed

    private void passFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passFieldMousePressed
        logInErrorMessage.setText("");
    }//GEN-LAST:event_passFieldMousePressed

    private void selectRoleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectRoleMousePressed
        logInErrorMessage.setText("");
    }//GEN-LAST:event_selectRoleMousePressed

    private void showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassActionPerformed
        if (showPass.isSelected()) {
            passField.setEchoChar((char) 0);
        } else {
            passField.setEchoChar('•');
        }
        logInErrorMessage.setText("");
    }//GEN-LAST:event_showPassActionPerformed

    private void selectRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectRoleActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Exit the program?", "Close Program", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_closeBtnActionPerformed

    private void forgotUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotUserActionPerformed
        forgotUsernameMsg obj0 = new forgotUsernameMsg();
        GlassPanePopup.showPopup(obj0);
    }//GEN-LAST:event_forgotUserActionPerformed

    private void forgotPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotPassActionPerformed
        forgotPasswordMsg obj5 = new forgotPasswordMsg();
        GlassPanePopup.showPopup(obj5);
    }//GEN-LAST:event_forgotPassActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new logIn().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton License;
    private javax.swing.JButton closeBtn;
    private javax.swing.JButton forgotPass;
    private javax.swing.JButton forgotUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private components.RoundedButtons logInBtn;
    private javax.swing.JLabel logInErrorMessage;
    private components.PasswordField passField;
    private components.Combobox selectRole;
    private components.JCheckBoxCustom showPass;
    private javax.swing.JLabel userIcon;
    private components.TextField usernameField;
    // End of variables declaration//GEN-END:variables
}
