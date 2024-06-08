/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherForms;

import Main.Main;
import Main.home;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import settings.GlassPanePopup;

public class updateUser extends javax.swing.JDialog {

    //private boolean isShowing = false;
    private String selectedAccount = "";
    JFileChooser file = new JFileChooser();

    public updateUser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        // Create a rounded frame
        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        setShape(roundedRectangle);
    }
    
    
    
    

    public updateUser(java.awt.Frame parent, boolean modal, String username) {
        super(parent, modal);
        initComponents();
        uploadBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showDateBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        delBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        updateBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        selectedAccount = username;
        if (Main.userPosition.equals("Administrator")) {
            passwordField.setEditable(true);
            usernameField.setEditable(true);
            delBtn.setEnabled(true);
        } else {
            passwordField.setEditable(false);
            usernameField.setEditable(false);
            delBtn.setEnabled(false);
        }
        
        if(Main.username.equals(username)){
            delBtn.setEnabled(false);
        }

        try {
            Statement s = Main.getDbCon().createStatement();
            //ResultSet rs = s.executeQuery("SELECT * FROM users WHERE userName = '" + username + "' AND userRole = '" + selectedRole + "' AND status = 'Active'");
            //ResultSet rs = s.executeQuery("SELECT * FROM users WHERE userName = '" + username + "' AND status = 'Active'");
            ResultSet rs = s.executeQuery("select * from users where userName = '" + username + "'");

            while (rs.next()) {
                fnameField.setText(rs.getString("fname"));
                mnameField.setText(rs.getString("mname"));
                lnameField.setText(rs.getString("lname"));
                snameField.setText(rs.getString("Sname"));
                genderField.setSelectedItem(rs.getString("gender"));
                emailField.setText(rs.getString("email"));
                bdayField.setText(rs.getString("birthDate"));
                numberField.setText(rs.getString("mobileNumber").substring(2));
                usernameField.setText(rs.getString("userName"));
                passwordField.setText(rs.getString("password"));
                roleField.setSelectedItem(rs.getString("userRole"));
                statusField.setSelectedItem(rs.getString("status"));
                imgField.setText(rs.getString("fileName"));
                entryField.setText(rs.getString("entryDate"));

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

        // Create a rounded frame
        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        setShape(roundedRectangle);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new otherForms.DatePicker();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        numberField = new javax.swing.JTextField();
        entryField = new javax.swing.JLabel();
        snameField = new javax.swing.JTextField();
        delBtn = new components.RoundedButtons();
        lnameField = new javax.swing.JTextField();
        uploadBtn = new javax.swing.JButton();
        imgField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        mnameField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        updateBtn = new components.RoundedButtons();
        jLabel18 = new javax.swing.JLabel();
        statusField = new components.Combobox();
        showDateBtn = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        roleField = new components.Combobox();
        fnameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmdCancel = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bdayField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        genderField = new components.Combobox();
        jLabel21 = new javax.swing.JLabel();
        ErrorMessage = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        date.setForeground(new java.awt.Color(48, 144, 216));
        date.setDateFormat("MMMM-dd-yyyy");
        date.setTextRefernce(bdayField);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("09");

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Entry Date: ");

        numberField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        numberField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        numberField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                numberFieldMouseClicked(evt);
            }
        });
        numberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberFieldActionPerformed(evt);
            }
        });
        numberField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numberFieldKeyTyped(evt);
            }
        });

        entryField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        entryField.setForeground(new java.awt.Color(102, 102, 102));
        entryField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        entryField.setText("September-00-0000");

        snameField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        snameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));

        delBtn.setBackground(new java.awt.Color(191, 50, 50));
        delBtn.setForeground(new java.awt.Color(255, 255, 255));
        delBtn.setText("Delete");
        delBtn.setBorderColor(new java.awt.Color(191, 50, 50));
        delBtn.setBorderPainted(false);
        delBtn.setColor(new java.awt.Color(191, 50, 50));
        delBtn.setColorClick(new java.awt.Color(191, 50, 50));
        delBtn.setColorOver(new java.awt.Color(191, 50, 50));
        delBtn.setFocusPainted(false);
        delBtn.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        delBtn.setPreferredSize(new java.awt.Dimension(97, 40));
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });

        lnameField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        lnameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        lnameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lnameFieldMouseClicked(evt);
            }
        });

        uploadBtn.setBackground(new java.awt.Color(15, 106, 191));
        uploadBtn.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        uploadBtn.setForeground(new java.awt.Color(255, 255, 255));
        uploadBtn.setText("Upload");
        uploadBtn.setBorderPainted(false);
        uploadBtn.setFocusPainted(false);
        uploadBtn.setPreferredSize(new java.awt.Dimension(29, 25));
        uploadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadBtnActionPerformed(evt);
            }
        });

        imgField.setEditable(false);
        imgField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        imgField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(178, 178, 178)), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        imgField.setCaretColor(new java.awt.Color(0, 0, 0));
        imgField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgFieldActionPerformed(evt);
            }
        });

        emailField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        emailField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        emailField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailFieldMouseClicked(evt);
            }
        });
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        usernameField.setEditable(false);
        usernameField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        usernameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        usernameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameFieldMouseClicked(evt);
            }
        });

        mnameField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        mnameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Mobile Number:");

        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Update");
        updateBtn.setBorderColor(new java.awt.Color(70, 191, 50));
        updateBtn.setBorderPainted(false);
        updateBtn.setColor(new java.awt.Color(70, 191, 50));
        updateBtn.setColorClick(new java.awt.Color(70, 191, 50));
        updateBtn.setColorOver(new java.awt.Color(70, 191, 50));
        updateBtn.setFocusPainted(false);
        updateBtn.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        updateBtn.setPreferredSize(new java.awt.Dimension(97, 40));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Email:");

        statusField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Inactive" }));
        statusField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        statusField.setLabelText("");
        statusField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusFieldActionPerformed(evt);
            }
        });

        showDateBtn.setBackground(new java.awt.Color(15, 106, 191));
        showDateBtn.setForeground(new java.awt.Color(255, 255, 255));
        showDateBtn.setText("...");
        showDateBtn.setBorderPainted(false);
        showDateBtn.setFocusPainted(false);
        showDateBtn.setPreferredSize(new java.awt.Dimension(29, 25));
        showDateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showDateBtnActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Birthday:");

        roleField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "Supervisor", "Sales Associate", "Warehouse Staff" }));
        roleField.setSelectedIndex(2);
        roleField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        roleField.setLabelText("");

        fnameField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        fnameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        fnameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fnameFieldMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Information");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("First Name:");

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

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Status:");

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Position:");

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Password:");

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Last Name:");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Gender:");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Suffix:");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Username:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Middle Name:");

        bdayField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        bdayField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(178, 178, 178)), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        bdayField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdayFieldActionPerformed(evt);
            }
        });

        passwordField.setEditable(false);
        passwordField.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        passwordField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        passwordField.setSelectionColor(new java.awt.Color(204, 204, 204));
        passwordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordFieldMouseClicked(evt);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });

        genderField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        genderField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        genderField.setLabelText("");

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Image:");

        ErrorMessage.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ErrorMessage.setForeground(new java.awt.Color(255, 51, 51));
        ErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 51, 51));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("*");

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 51, 51));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("*");

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 51, 51));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("*");

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 51, 51));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bdayField, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(showDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel13))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(3, 3, 3)
                                                .addComponent(jLabel6)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lnameField, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                                    .addComponent(mnameField)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(snameField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(genderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(fnameField)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3)))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                            .addComponent(passwordField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(409, 409, 409)
                        .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(entryField))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(imgField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(uploadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(roleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)
                                        .addGap(3, 3, 3)
                                        .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(363, 363, 363))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(331, 331, 331))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel20)
                    .addComponent(jLabel23))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel24))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(snameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel15)
                            .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(genderField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roleField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(entryField)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(imgField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21))
                    .addComponent(uploadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bdayField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(26, 26, 26)
                .addComponent(ErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure to delete this account?", "Delete User", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {

            String password = JOptionPane.showInputDialog(this, "Enter your password:");

            if (password != null && password.equals(Main.getStoredPassword())) {
                try {
                    Connection con = Main.getDbCon();
                    PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE userName = '" + selectedAccount + "'");

                    // Execute the DELETE statement
                    int rowsDeleted = ps.executeUpdate();

                    // Check if any rows were deleted
                    if (rowsDeleted > 0) {
                        System.out.println("Row deleted successfully.");
                    } else {
                        System.out.println("No rows were deleted.");
                    }

                    home.setHeader(home.jPanel1, Main.username);
                    home.form6Users = new Form6();
                    home.setForm(home.form6Users);
                    GlassPanePopup.closePopupLast();
                    dispose();
                    home.successDeleteUser.showNotification();

                    // Close the ResultSet
                    ps.close();
                    con.close();

                } catch (SQLException e) {
                    e.printStackTrace(); // Print the exception details for debugging
                    JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    Main.closeCon();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect password! Task canceled.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }


    }//GEN-LAST:event_delBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed

        if (fnameField.getText().isEmpty() || lnameField.getText().isEmpty() || usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            ErrorMessage.setText("Please complete all required fields with *");
        } else {
            if (numberField.getText().trim().length() < 9 && !numberField.getText().trim().isEmpty()) {
                ErrorMessage.setText("Invalid mobile number!");
            } else if (passwordField.getText().trim().length() < 8) {
                ErrorMessage.setText("Password must be at least 8 characters!");
            } else {
                if (!emailField.getText().trim().isEmpty()) {
                    try {
                        new InternetAddress(emailField.getText().trim()).validate();
                    } catch (AddressException ex) {
                        ErrorMessage.setText("Invalid email address!");
                        return;
                    }
                }

                int choice = JOptionPane.showConfirmDialog(this, "Save your current changes?", "Save Task", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    String fname = fnameField.getText().trim();
                    String mname = mnameField.getText().trim();
                    String lname = lnameField.getText().trim();
                    String sname = snameField.getText().trim();
                    String gender = (String) genderField.getSelectedItem();
                    String email = emailField.getText().trim();
                    String bday = bdayField.getText();
                    String number = "09" + numberField.getText().trim();
                    String username = usernameField.getText();
                    String password = passwordField.getText();
                    String imgname = imgField.getText().trim();
                    String role = (String) roleField.getSelectedItem();
                    String status = (String) statusField.getSelectedItem();
                    System.out.println(status);
                    //String status = (String) statusField.getSelectedItem();

                    try {
                        Connection con = Main.getDbCon();

                        String Filepath = "";
                        File selectedFile = file.getSelectedFile();
                        if (selectedFile != null) {
                            String destinationDir = "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads";
                            File destinationFile = new File(destinationDir, selectedFile.getName());

                            try {
                                resizeAndCopyImage(selectedFile, destinationFile, 150, 150);
                                System.out.println(destinationFile.getName());
                                Filepath = destinationFile.getAbsolutePath();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "File upload failed!", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        } else {
                            String destinationDir = "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads";
                            File defaultFile = new File(destinationDir, imgField.getText().trim());
                            // Assign the default file to the destination file
                            Filepath = defaultFile.getAbsolutePath();
                            System.out.println("No file selected or selection canceled.");
                        }

                        PreparedStatement ps = con.prepareStatement("UPDATE users SET img = LOAD_FILE(?), fname = ?, mname = ?, lname = ?, Sname = ?, fullname = ?, userName = ?, userRole = ?, password = ?, email = ?, gender = ?, mobileNumber = ?, birthDate = ?, status = ?, fileName = ? WHERE username = ?");
                        ps.setString(1, Filepath); // Assuming Filepath is the file path string
                        ps.setString(2, fname);
                        ps.setString(3, mname);
                        ps.setString(4, lname);
                        ps.setString(5, sname);
                        if (mname.isEmpty()) {
                            ps.setString(6, fname + " " + lname + " " + sname);
                        } else {
                            ps.setString(6, fname + " " + mname + " " + lname + " " + sname);
                        }
                        ps.setString(7, username);
                        ps.setString(8, role);
                        ps.setString(9, password);
                        ps.setString(10, email);
                        ps.setString(11, gender);
                        ps.setString(12, number);
                        ps.setString(13, bday);
                        ps.setString(14, status);
                        ps.setString(15, imgname);
                        ps.setString(16, selectedAccount); // Assuming selectedAccount is the username to update
                        ps.executeUpdate();

                        ErrorMessage.setText(" ");

                        // Close the ResultSet
                        ps.close();
                        con.close();

                    } catch (SQLException e) {
                        e.printStackTrace(); // Print the exception details for debugging
                        JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        Main.closeCon();
                    }

                    home.setHeader(home.jPanel1, Main.username);
                    home.form6Users = new Form6();
                    home.setForm(home.form6Users);
                    home.form7Profile = new Form7(Main.username);
                    GlassPanePopup.closePopupLast();
                    dispose();
                    home.successUpdateUser.showNotification();
                }

            }
        }


    }//GEN-LAST:event_updateBtnActionPerformed

    private void statusFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusFieldActionPerformed

    private void showDateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showDateBtnActionPerformed
        date.showPopup();
    }//GEN-LAST:event_showDateBtnActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Changes you made will not be save.", "Close Task", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            GlassPanePopup.closePopupLast();
            dispose();
        }


    }//GEN-LAST:event_cmdCancelActionPerformed

    private void bdayFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdayFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bdayFieldActionPerformed

    private void passwordFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordFieldMouseClicked
        ErrorMessage.setText(" ");
    }//GEN-LAST:event_passwordFieldMouseClicked

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed

    }//GEN-LAST:event_passwordFieldKeyPressed

    private void imgFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imgFieldActionPerformed

    private void uploadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadBtnActionPerformed

        file.setCurrentDirectory(new File("user.dir"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("All Pic", "png", "jpg");
        file.setFileFilter(filter);

        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            if (!filePath.toLowerCase().endsWith(".png") && !filePath.toLowerCase().endsWith(".jpg")) {
                JOptionPane.showMessageDialog(null, "Please select a valid image file (PNG, JPG).", "Invalid File", JOptionPane.ERROR_MESSAGE);
            } else {

                imgField.setText(file.getSelectedFile().getName());

                // Destination directory
                String destinationDir = "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads";
                File destinationFile = new File(destinationDir, selectedFile.getName());

                try {
                    resizeAndCopyImage(selectedFile, destinationFile, 150, 150);

                    System.out.println(destinationFile.getName());

                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "File upload failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_uploadBtnActionPerformed

    private void fnameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fnameFieldMouseClicked
        ErrorMessage.setText(" ");
    }//GEN-LAST:event_fnameFieldMouseClicked

    private void lnameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lnameFieldMouseClicked
        ErrorMessage.setText(" ");
    }//GEN-LAST:event_lnameFieldMouseClicked

    private void usernameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameFieldMouseClicked
        ErrorMessage.setText(" ");
    }//GEN-LAST:event_usernameFieldMouseClicked

    private void numberFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numberFieldMouseClicked
        ErrorMessage.setText(" ");
    }//GEN-LAST:event_numberFieldMouseClicked

    private void numberFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberFieldKeyTyped
        String value = numberField.getText();
        int l = value.length();

        // Check if the key typed is a number or a space
        char c = evt.getKeyChar();
        if ((c >= '0' && c <= '9') || c == ' ') {
            if (l >= 9) {
                evt.consume();
                ErrorMessage.setText("Accepts 9-digit number only!");
            } else {
                ErrorMessage.setText(""); // Clear the error message
            }
        } else {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_numberFieldKeyTyped

    private void numberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberFieldActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void emailFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailFieldMouseClicked
        ErrorMessage.setText(" ");
    }//GEN-LAST:event_emailFieldMouseClicked

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

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(updateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                updateUser dialog = new updateUser(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrorMessage;
    private javax.swing.JTextField bdayField;
    private javax.swing.JButton cmdCancel;
    private otherForms.DatePicker date;
    private components.RoundedButtons delBtn;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel entryField;
    private javax.swing.JTextField fnameField;
    private components.Combobox genderField;
    private javax.swing.JTextField imgField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lnameField;
    private javax.swing.JTextField mnameField;
    private javax.swing.JTextField numberField;
    private javax.swing.JPasswordField passwordField;
    private components.Combobox roleField;
    private javax.swing.JButton showDateBtn;
    private javax.swing.JTextField snameField;
    private components.Combobox statusField;
    private components.RoundedButtons updateBtn;
    private javax.swing.JButton uploadBtn;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
