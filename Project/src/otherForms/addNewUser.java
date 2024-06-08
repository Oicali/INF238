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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.mail.Authenticator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import popUps.noWiFiMsg;
import settings.GlassPanePopup;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class addNewUser extends javax.swing.JDialog {

    private JFileChooser file = new JFileChooser();
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM-dd-yyyy");
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LENGTH = 8;
    private static final SecureRandom RANDOM = new SecureRandom();

    public addNewUser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

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
        numberField = new javax.swing.JTextField();
        snameField = new javax.swing.JTextField();
        lnameField = new javax.swing.JTextField();
        uploadBtn = new javax.swing.JButton();
        imgField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        mnameField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        generateBtn = new components.RoundedButtons();
        jLabel18 = new javax.swing.JLabel();
        showDateBtn = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        roleField = new components.Combobox();
        fnameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmdCancel = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bdayField = new javax.swing.JTextField();
        genderField = new components.Combobox();
        jLabel21 = new javax.swing.JLabel();
        ErrorMessage = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

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

        snameField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        snameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));

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

        mnameField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        mnameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Mobile Number:");

        generateBtn.setForeground(new java.awt.Color(255, 255, 255));
        generateBtn.setText("Generate");
        generateBtn.setBorderColor(new java.awt.Color(70, 191, 50));
        generateBtn.setBorderPainted(false);
        generateBtn.setColor(new java.awt.Color(70, 191, 50));
        generateBtn.setColorClick(new java.awt.Color(70, 191, 50));
        generateBtn.setColorOver(new java.awt.Color(70, 191, 50));
        generateBtn.setFocusPainted(false);
        generateBtn.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        generateBtn.setPreferredSize(new java.awt.Dimension(97, 40));
        generateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBtnActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Email:");

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

        roleField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "Supervisor", "Employee" }));
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
        jLabel1.setText("Add New User");

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

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Position:");

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Last Name:");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Gender:");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Suffix:");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(roleField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(imgField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(uploadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(3, 3, 3)
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(bdayField, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(showDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(ErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(generateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel20))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(snameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(genderField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel23))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bdayField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(imgField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uploadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(26, 26, 26)
                .addComponent(ErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(generateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
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

    private void generateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBtnActionPerformed

        if (fnameField.getText().isEmpty() || lnameField.getText().isEmpty() || emailField.getText().isEmpty()) {
            ErrorMessage.setText("Please complete all required fields with *");
        } else {
            if (numberField.getText().trim().length() < 9 && !numberField.getText().trim().isEmpty()) {
                ErrorMessage.setText("Invalid mobile number!");
            } else {
                // Validate email address
                try {
                    new InternetAddress(emailField.getText().trim()).validate();
                } catch (AddressException ex) {
                    ErrorMessage.setText("Invalid email address!");
                    return;
                }

                int choice = JOptionPane.showConfirmDialog(this, "Click yes to confirm.", "Add New User", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    try {
                        // Check internet connection
                        URL url = new URL("http://www.google.com");
                        URLConnection connection = url.openConnection();
                        connection.connect();

                        String fname = fnameField.getText().trim();
                        String mname = mnameField.getText().trim();
                        String lname = lnameField.getText().trim();
                        String sname = snameField.getText().trim();
                        String gender = (String) genderField.getSelectedItem();
                        String email = emailField.getText().trim();
                        String bday = bdayField.getText();
                        String number = "09" + numberField.getText().trim();
                        String imgname = imgField.getText().trim();
                        String role = (String) roleField.getSelectedItem();

                        LocalDateTime now = LocalDateTime.now();
                        String entry = dtf.format(now);

                        try {
                            Connection con = Main.getDbCon();

                            File selectedFile;
                            if (imgname.isEmpty()) {
                                selectedFile = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\default.png");
                            } else {
                                selectedFile = file.getSelectedFile();
                            }

                            String destinationDir = "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads";
                            File destinationFile = new File(destinationDir, selectedFile.getName());

                            try {
                                resizeAndCopyImage(selectedFile, destinationFile, 150, 150);
                                System.out.println(destinationFile.getName());
                            } catch (IOException ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "File upload failed!", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                            String query = "INSERT INTO users (img, fname, mname, lname, Sname, fullname, userName, userRole, password, email, gender, mobileNumber, birthDate, entryDate, status, fileName) "
                                    + "VALUES (LOAD_FILE(?), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            PreparedStatement ps = con.prepareStatement(query);
                            ps.setString(1, destinationFile.getAbsolutePath());
                            ps.setString(2, fname);
                            ps.setString(3, mname);
                            ps.setString(4, lname);
                            ps.setString(5, sname);
                            if (mname.isEmpty()) {
                                ps.setString(6, fname + " " + lname + " " + sname);
                                String username = lname.replaceAll("\\s+", "").toLowerCase() + fname.substring(0, 1).toLowerCase() + RNG() + "@invsys.mark-it";
                                ps.setString(7, username);
                            } else {
                                ps.setString(6, fname + " " + mname + " " + lname + " " + sname);
                                String username = lname.replaceAll("\\s+", "").toLowerCase() + fname.substring(0, 1).toLowerCase() + mname.substring(0, 1).toLowerCase() + RNG() + "@invsys.mark-it";
                                ps.setString(7, username);
                            }

                            ps.setString(8, role);
                            ps.setString(9, randomPass());
                            ps.setString(10, email);
                            ps.setString(11, gender);
                            ps.setString(12, number);
                            ps.setString(13, bday);
                            ps.setString(14, entry);
                            ps.setString(15, "Active");
                            ps.setString(16, destinationFile.getName());
                            ps.executeUpdate();

                            ErrorMessage.setText(" ");

                            ps.close();
                            con.close();

                        } catch (SQLException e) {
                            e.printStackTrace(); // Print the exception details for debugging
                            JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            Main.closeCon();
                        }

                        emailNewUser(email);
                        home.setHeader(home.jPanel1, Main.username);
                        home.form6 = new Form6();
                        home.setForm(home.form6);
                        home.form7 = new Form7(Main.username);
                        GlassPanePopup.closePopupLast();
                        dispose();
                        home.successAddUser.showNotification();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Internet Connection Occurred!", "Network Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }


    }//GEN-LAST:event_generateBtnActionPerformed

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
                    String file = destinationFile.getName();

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

    private static String RNG() {
        StringBuilder otpBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            otpBuilder.append((char) ((int) (Math.random() * 10) + '0'));
        }
        return otpBuilder.toString();
    }

    private static String randomPass() {
        StringBuilder otpBuilder = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            otpBuilder.append(CHARACTERS.charAt(index));
        }
        return otpBuilder.toString();
    }

    private static Message sendCreatedUserMsg(Session session, String myAccountEmail, String recipient) throws MessagingException {
        String storedName = "";
        String storedUserName = "";
        String storedRole = "";
        String storedPass = "";

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Mark-It Inventory System Account Registered");

            try {
                Statement s = Main.getDbCon().createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM users WHERE email = '" + recipient + "'");

                while (rs.next()) {
                    storedName = rs.getString("lname");
                    storedUserName = rs.getString("userName");
                    storedRole = rs.getString("userRole");
                    storedPass = rs.getString("password");
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

            String htmlText = "<h3 style=\"color:black;\">Welcome New User!</h3>"
                    + "<p style=\"color:black;\">Dear Mr./Mrs. " + storedName + ", </p>"
                    + "<p style=\"color:black;\"> We are pleased to know that you are joining our team! Please refer to the credentials below for you to access your account in our Inventory System.</p>"
                    + "<p style=\"color:black;\"> Username:  <strong>" + storedUserName + " </strong> </p>"
                    + "<p style=\"color:black;\"> Position:  <strong>" + storedRole + " </strong> </p>"
                    + "<p style=\"color:black;\"> Password:  <strong>" + storedPass + " </strong> </p>"
                    + "<p style=\"color:black;\"> Keep your credentials safe to open our Inventory System. Feel free to change your password as you log in your account.</p>"
                    + "<p style=\"color:black;\"> This message is generated automatically, so there's no need to reply. If you have any questions or concerns, you may contact our support team.</p>"
                    + "<p style=\"color:black;\">Best regards,</p>"
                    + "<p style=\"color:black;\">Mark-It Inventory System </p>";

            message.setContent(htmlText, "text/html");
            return message;
        } catch (AddressException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Code for email sending
    public static void emailNewUser(String recipient) throws Exception {

        System.out.println("sending...");

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "invsysmarkitbot@gmail.com";
        String password = "qfsb ksrp pwfw rigc";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = sendCreatedUserMsg(session, myAccountEmail, recipient);
        Transport.send(message);
        System.out.println("sent!");
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
            java.util.logging.Logger.getLogger(addNewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addNewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addNewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addNewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                addNewUser dialog = new addNewUser(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField fnameField;
    private components.Combobox genderField;
    private components.RoundedButtons generateBtn;
    private javax.swing.JTextField imgField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lnameField;
    private javax.swing.JTextField mnameField;
    private javax.swing.JTextField numberField;
    private components.Combobox roleField;
    private javax.swing.JButton showDateBtn;
    private javax.swing.JTextField snameField;
    private javax.swing.JButton uploadBtn;
    // End of variables declaration//GEN-END:variables
}
