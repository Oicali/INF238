package Pages;

import Pages.Users;
import Main.*;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import popUps.changePassword;
import settings.GlassPanePopup;
import model.Model_User;

public class Profile extends javax.swing.JPanel {

    JFileChooser file = new JFileChooser();

    public Profile(String username) {
        initComponents();
        setOpaque(false);
        initData(username);
        changePassBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        uploadBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void initData(String username) {
        try {
            Statement s = Main.getDbCon().createStatement();

            ResultSet rs = s.executeQuery("select * from users where userName = '" + username + "'");

            while (rs.next()) {
                fNameField.setText(rs.getString("fname"));
                mNameField.setText(rs.getString("mname"));
                lNameField.setText(rs.getString("lname"));
                sNameField.setText(rs.getString("Sname"));
                fullNameLbl.setText(rs.getString("fullname"));
                roleLbl.setText(rs.getString("userRole"));
                roleField.setText(rs.getString("userRole"));
                genderField.setText(rs.getString("gender"));
                birthField.setText(rs.getString("birthDate"));
                usernameField.setText(rs.getString("userName"));
                dateField.setText("Entry date: " +rs.getString("entryDate"));
                avatar.setIcon(new ImageIcon(rs.getBytes("img")));
                
                String censoredPass = String.join("", Collections.nCopies(rs.getString("password").length(), "*"));
                passwordField.setText(censoredPass);

                String str1 = rs.getString("mobileNumber").substring(0, 7);
                String str2 = rs.getString("mobileNumber").substring(7);
                String maskedCN = String.join("", Collections.nCopies(str1.length(), "*"));
                String censoredCN = maskedCN + str2;
                numberField.setText(censoredCN);

                String str3 = rs.getString("email").substring(0, 4);
                String str4 = rs.getString("email").substring(4);
                String maskedEmail = String.join("", Collections.nCopies(str4.length(), "*"));
                String censoredEmail = str3 + maskedEmail;
                emailField.setText(censoredEmail);
                         
            }

            // Close the ResultSet
            rs.close();
            s.close();

        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception details for debugging
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            Main.closeCon();
        }
    }

    private static void resizeAndCopyImage(File sourceFile, File destFile, int width, int height) throws IOException {
        // Read the source image
        BufferedImage originalImage = ImageIO.read(sourceFile);

        // Create a new buffered image with the desired dimensions
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Draw the original image into the new image with the new dimensions
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();

        // Extract the file extension
        String formatName = destFile.getName().substring(destFile.getName().lastIndexOf(".") + 1);

        // Write the resized image to the destination file
        ImageIO.write(resizedImage, formatName, destFile);
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(grphcs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        avatar = new components.CircleImageAvatar();
        fullNameLbl = new javax.swing.JLabel();
        roleLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fNameField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        genderField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        birthField = new javax.swing.JTextField();
        numberField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        roleField = new javax.swing.JTextField();
        dateField = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        changePassBtn = new components.RoundedButtons();
        uploadBtn = new components.RoundedButtons();
        jLabel8 = new javax.swing.JLabel();
        mNameField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lNameField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        sNameField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        avatar.setForeground(new java.awt.Color(15, 106, 191));
        avatar.setBorderSize(2);
        avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logInUser.png"))); // NOI18N

        fullNameLbl.setFont(new java.awt.Font("SansSerif", 1, 40)); // NOI18N
        fullNameLbl.setText("User Full Name");

        roleLbl.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        roleLbl.setText("User Role ");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setText("First Name: ");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel5.setText("User Information");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        fNameField.setEditable(false);
        fNameField.setBackground(new java.awt.Color(255, 255, 255));
        fNameField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        fNameField.setForeground(new java.awt.Color(102, 102, 102));
        fNameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1)));
        fNameField.setSelectionColor(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setText("Gender: ");

        genderField.setEditable(false);
        genderField.setBackground(new java.awt.Color(255, 255, 255));
        genderField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        genderField.setForeground(new java.awt.Color(102, 102, 102));
        genderField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1)));
        genderField.setSelectionColor(new java.awt.Color(204, 204, 204));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel7.setText("Birth Date: ");

        birthField.setEditable(false);
        birthField.setBackground(new java.awt.Color(255, 255, 255));
        birthField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        birthField.setForeground(new java.awt.Color(102, 102, 102));
        birthField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1)));
        birthField.setSelectionColor(new java.awt.Color(204, 204, 204));

        numberField.setEditable(false);
        numberField.setBackground(new java.awt.Color(255, 255, 255));
        numberField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        numberField.setForeground(new java.awt.Color(153, 153, 153));
        numberField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1)));
        numberField.setSelectionColor(new java.awt.Color(204, 204, 204));

        emailField.setEditable(false);
        emailField.setBackground(new java.awt.Color(255, 255, 255));
        emailField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        emailField.setForeground(new java.awt.Color(102, 102, 102));
        emailField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1)));
        emailField.setSelectionColor(new java.awt.Color(204, 204, 204));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel10.setText("Username: ");

        usernameField.setEditable(false);
        usernameField.setBackground(new java.awt.Color(255, 255, 255));
        usernameField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        usernameField.setForeground(new java.awt.Color(102, 102, 102));
        usernameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1)));
        usernameField.setSelectionColor(new java.awt.Color(204, 204, 204));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel11.setText("Password: ");

        passwordField.setEditable(false);
        passwordField.setBackground(new java.awt.Color(255, 255, 255));
        passwordField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        passwordField.setForeground(new java.awt.Color(102, 102, 102));
        passwordField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1)));
        passwordField.setSelectionColor(new java.awt.Color(204, 204, 204));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel13.setText("User Role: ");

        roleField.setEditable(false);
        roleField.setBackground(new java.awt.Color(255, 255, 255));
        roleField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        roleField.setForeground(new java.awt.Color(102, 102, 102));
        roleField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1)));
        roleField.setSelectionColor(new java.awt.Color(204, 204, 204));

        dateField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        dateField.setForeground(new java.awt.Color(102, 102, 102));
        dateField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dateField.setText("September-00-0000");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel14.setText("Mobile Number:");

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel15.setText("Registered Email:");

        changePassBtn.setForeground(new java.awt.Color(255, 255, 255));
        changePassBtn.setText("Change Password");
        changePassBtn.setBorderColor(new java.awt.Color(15, 106, 191));
        changePassBtn.setBorderPainted(false);
        changePassBtn.setColor(new java.awt.Color(15, 106, 191));
        changePassBtn.setColorClick(new java.awt.Color(15, 106, 191));
        changePassBtn.setColorOver(new java.awt.Color(15, 106, 191));
        changePassBtn.setFocusPainted(false);
        changePassBtn.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        changePassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassBtnActionPerformed(evt);
            }
        });

        uploadBtn.setForeground(new java.awt.Color(255, 255, 255));
        uploadBtn.setText("Upload Image");
        uploadBtn.setBorderColor(new java.awt.Color(15, 106, 191));
        uploadBtn.setBorderPainted(false);
        uploadBtn.setColor(new java.awt.Color(15, 106, 191));
        uploadBtn.setColorClick(new java.awt.Color(15, 106, 191));
        uploadBtn.setColorOver(new java.awt.Color(15, 106, 191));
        uploadBtn.setFocusPainted(false);
        uploadBtn.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        uploadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadBtnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setText("Middle Name: ");

        mNameField.setEditable(false);
        mNameField.setBackground(new java.awt.Color(255, 255, 255));
        mNameField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        mNameField.setForeground(new java.awt.Color(102, 102, 102));
        mNameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1)));
        mNameField.setSelectionColor(new java.awt.Color(204, 204, 204));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setText("Last Name: ");

        lNameField.setEditable(false);
        lNameField.setBackground(new java.awt.Color(255, 255, 255));
        lNameField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        lNameField.setForeground(new java.awt.Color(102, 102, 102));
        lNameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1)));
        lNameField.setSelectionColor(new java.awt.Color(204, 204, 204));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel16.setText("Suffix: ");

        sNameField.setEditable(false);
        sNameField.setBackground(new java.awt.Color(255, 255, 255));
        sNameField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        sNameField.setForeground(new java.awt.Color(102, 102, 102));
        sNameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1)));
        sNameField.setSelectionColor(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(changePassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(uploadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                                    .addComponent(mNameField)
                                    .addComponent(lNameField)
                                    .addComponent(sNameField)
                                    .addComponent(genderField)
                                    .addComponent(birthField))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel14))
                                    .addGap(20, 20, 20))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13))
                                .addGap(71, 71, 71)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(emailField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numberField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                            .addComponent(passwordField)
                            .addComponent(roleField)
                            .addComponent(usernameField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fullNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(170, 170, 170))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(roleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1045, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(fullNameLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roleLbl)
                            .addComponent(dateField))))
                .addGap(40, 40, 40)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(mNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(roleField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(sNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(genderField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changePassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uploadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void changePassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePassBtnActionPerformed
        changePassword obj11 = new changePassword();
        GlassPanePopup.showPopup(obj11);
    }//GEN-LAST:event_changePassBtnActionPerformed

    private void uploadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadBtnActionPerformed
        // Set the current directory
        file.setCurrentDirectory(new File("user.dir"));

        // Set the file filter for image files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("All Pic", "png", "jpg");
        file.setFileFilter(filter);

        // Show the save dialog
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            // Validate file extension
            if (!filePath.toLowerCase().endsWith(".png") && !filePath.toLowerCase().endsWith(".jpg")) {
                JOptionPane.showMessageDialog(null, "Please select a valid image file (PNG, JPG).", "Invalid File", JOptionPane.ERROR_MESSAGE);
            } else {

                // Destination directory
                String destinationDir = "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\Inventory_System\\Users";
                File destinationFile = new File(destinationDir, selectedFile.getName());

                // Copy the file to the destination
                try {
                    resizeAndCopyImage(selectedFile, destinationFile, 150, 150);

                    String file = destinationFile.getName();

                    try {
                        // Create a statement
                        Statement s = Main.getDbCon().createStatement();
                        String query = "UPDATE users "
                                + "SET img = LOAD_FILE('" + destinationFile.getAbsolutePath().replace("\\", "\\\\") + "'), fileName = '" + destinationFile.getName()
                                + "' WHERE username = '" + Main.username + "'";

                        int rowsAffected = s.executeUpdate(query);

                        if (rowsAffected > 0) {
                            home.setHeader(home.jPanel1, Main.username);
                            home.form7Profile = new Profile(Main.username);
                            home.setForm(home.form7Profile);
                            home.form6Users = new Users();
                            this.setVisible(false);
                            home.successChangeImg.showNotification();
                            
                            

                        } else {
                            System.out.println("No rows were updated to change image");
                        }

                        // Close the statement
                        s.close();
                    } catch (SQLException e) {
                        e.printStackTrace(); // Print the exception details for debugging
                        JOptionPane.showMessageDialog(null, "An error occurred with Mysql. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        Main.closeCon(); // Ensure the connection is closed
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "File upload failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }

    }//GEN-LAST:event_uploadBtnActionPerformed

    
    
    
    
    
    
    
    
    
    
    
    public Profile() {
        initComponents();
        setOpaque(false);

        String censoredPass = String.join("", Collections.nCopies(Main.getStoredPassword().length(), "*"));

        //String str1 = Main.number.substring(0, 7);
        //String str2 = Main.number.substring(7);
//        String maskedCN = String.join("", Collections.nCopies(str1.length(), "*"));
//        String censoredCN = maskedCN + str2;

//        String str3 = Main.email.substring(0, 5);
//        String str4 = Main.email.substring(5);
//        String maskedEmail = String.join("", Collections.nCopies(str4.length(), "*"));
//        String censoredEmail = str3 + maskedEmail;

//        fullNameLbl.setText(Main.fullname);

        roleLbl.setText(Main.userPosition);

//        fNameField.setText(Main.fname);
//        mNameField.setText(Main.mname);
//        lNameField.setText(Main.lname);
//        sNameField.setText(Main.sname);
        roleField.setText(Main.userPosition);
//        genderField.setText(Main.gender);
        //birthField.setText(Main.birth);
//        numberField.setText(censoredCN);
        usernameField.setText(Main.username);
        passwordField.setText(censoredPass);
//        emailField.setText(censoredEmail);
        //dateField.setText("Entry date: " + Main.date);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static components.CircleImageAvatar avatar;
    private javax.swing.JTextField birthField;
    public components.RoundedButtons changePassBtn;
    private javax.swing.JLabel dateField;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField fNameField;
    private javax.swing.JLabel fullNameLbl;
    private javax.swing.JTextField genderField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lNameField;
    private javax.swing.JTextField mNameField;
    private javax.swing.JTextField numberField;
    public static javax.swing.JTextField passwordField;
    private javax.swing.JTextField roleField;
    private javax.swing.JLabel roleLbl;
    private javax.swing.JTextField sNameField;
    private components.RoundedButtons uploadBtn;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
