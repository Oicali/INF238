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
import otherForms.Form7;
import settings.GlassPanePopup;

public class logIn extends javax.swing.JFrame {

    ImageIcon image = new ImageIcon("D:\\GitHub\\INF238\\Project\\src\\resources\\logoSmall.png");
    public static boolean isUserEmpty = true;
    public static boolean isPassEmpty = true;

    public logIn() {
        initComponents();
        setIconImage(image.getImage());
        GlassPanePopup.install(this);
        passField.setEchoChar('•');
        JDialog.setDefaultLookAndFeelDecorated(true);

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
        logInBtn = new components.RoundedButtons();
        showPass = new components.JCheckBoxCustom();
        closeBtn = new javax.swing.JButton();
        usernameField = new components.TextField();
        imageAvatar1 = new components.ImageAvatar();
        passField = new components.PasswordField();
        selectRole = new components.Combobox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log In");
        setMaximumSize(new java.awt.Dimension(1250, 750));
        setMinimumSize(new java.awt.Dimension(1250, 750));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        forgotUser.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
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

        forgotPass.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
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

        License.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        License.setForeground(new java.awt.Color(153, 153, 153));
        License.setText("@Mark-It! 2024");
        License.setBorderPainted(false);
        License.setContentAreaFilled(false);
        License.setFocusPainted(false);
        License.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        logInErrorMessage.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        logInErrorMessage.setForeground(new java.awt.Color(255, 51, 51));
        logInErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logInErrorMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        logInBtn.setForeground(new java.awt.Color(15, 106, 191));
        logInBtn.setText("Log In");
        logInBtn.setBorderColor(new java.awt.Color(15, 106, 191));
        logInBtn.setBorderPainted(false);
        logInBtn.setColorClick(new java.awt.Color(153, 153, 153));
        logInBtn.setColorOver(new java.awt.Color(204, 204, 204));
        logInBtn.setFocusPainted(false);
        logInBtn.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        logInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInBtnActionPerformed(evt);
            }
        });

        showPass.setForeground(new java.awt.Color(153, 153, 153));
        showPass.setText("Show Password");
        showPass.setFocusPainted(false);
        showPass.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
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

        usernameField.setSelectionColor(new java.awt.Color(204, 204, 204));
        usernameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameFieldMouseClicked(evt);
            }
        });

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logInUser.png"))); // NOI18N

        passField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        passField.setSelectionColor(new java.awt.Color(204, 204, 204));
        passField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passFieldMouseClicked(evt);
            }
        });

        selectRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "Supervisor", "Employee" }));
        selectRole.setSelectedIndex(2);
        selectRole.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        selectRole.setLabelText("Logging in as");
        selectRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectRoleMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(userIcon))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(showPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(passField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(selectRole, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 4, Short.MAX_VALUE))
                                    .addComponent(logInErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(5, 5, 5)))))
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(forgotPass)
                            .addComponent(forgotUser))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(License, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(logInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userIcon)
                .addGap(24, 24, 24)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forgotUser)
                .addGap(24, 24, 24)
                .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showPass, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forgotPass))
                .addGap(47, 47, 47)
                .addComponent(selectRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(logInErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(logInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(License, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(15, 106, 191));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Log In to your Account");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(60, 280, 540, 80);
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 810, 0);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logInBg.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 0, 900, 900);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1440, 900));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Exit the program?", "Close Program", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_closeBtnActionPerformed

    private void logInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInBtnActionPerformed
        if (usernameField.getText().isEmpty() & passField.getText().isEmpty()) {
            logInErrorMessage.setText("Please fill up all required fields!");
        } else if (usernameField.getText().isEmpty()) {
            logInErrorMessage.setText("Please fill up username field!");
        } else if (passField.getText().isEmpty()) {
            logInErrorMessage.setText("Please fill up password field!");
        } else {

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
                    Main.fname = rs.getString("fname");
                    Main.mname = rs.getString("mname");
                    Main.lname = rs.getString("lname");
                    Main.fullname = rs.getString("fullname");
                    Main.number = rs.getString("mobileNumber");
                    Main.email = rs.getString("email");
                    Main.birth = rs.getString("birthDate");
                    Main.gender = rs.getString("gender");
                    Main.username = rs.getString("userName");
                    Main.date = rs.getString("entryDate");
                    Main.imageBytes = rs.getBytes("img");
                }

                if (password.equals(Main.storedPassword)) {
                    ImageIcon Icon = new ImageIcon(Main.imageBytes);

                    dispose();
                    new home(Main.selectedRole).show();
                    home.avatar1.setIcon(Icon);
                    Form7.avatar.setIcon(Icon);
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
        }


    }//GEN-LAST:event_logInBtnActionPerformed

    private void forgotPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotPassActionPerformed
        forgotPasswordMsg obj5 = new forgotPasswordMsg();
        GlassPanePopup.showPopup(obj5);
        logInErrorMessage.setText("");
    }//GEN-LAST:event_forgotPassActionPerformed

    private void forgotUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotUserActionPerformed
        forgotUsernameMsg obj0 = new forgotUsernameMsg();
        GlassPanePopup.showPopup(obj0);
        logInErrorMessage.setText("");
    }//GEN-LAST:event_forgotUserActionPerformed

    private void showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassActionPerformed
        if (showPass.isSelected()) {
            passField.setEchoChar((char) 0);
        } else {
            passField.setEchoChar('•');
        }
        logInErrorMessage.setText("");
    }//GEN-LAST:event_showPassActionPerformed

    private void selectRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectRoleMouseClicked
        logInErrorMessage.setText("");
    }//GEN-LAST:event_selectRoleMouseClicked

    private void usernameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameFieldMouseClicked
        logInErrorMessage.setText("");
    }//GEN-LAST:event_usernameFieldMouseClicked

    private void passFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passFieldMouseClicked
        logInErrorMessage.setText("");
    }//GEN-LAST:event_passFieldMouseClicked

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
    private components.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
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
