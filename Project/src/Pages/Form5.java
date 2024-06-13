/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Pages;

import Main.Main;
import Main.home;
import interfaces.EventCallBack;
import interfaces.EventTextField;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import model.Model_User;
import settings.CenteredCellRenderer;
import settings.GlassPanePopup;
import settings.ModernCellRenderer;
import settings.ModernHeaderRenderer;

/**
 *
 * @author jairus
 */
public class Form5 extends javax.swing.JPanel {

    private boolean isEditing = true;

    public Form5() {
        initComponents();
        setOpaque(false);
        initTable();
        initData();

        deleteBtn.setVisible(false);

        deleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        dualBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        searchField.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                try {
                    String data = searchField.getText();
                    for (int i = 1; i <= 100; i++) {
                        Thread.sleep(10);
                    }
                    call.done();
                    searchData(data);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread was interrupted: " + e);
                } catch (Exception e) {
                    System.err.println(e);
                }
            }

            @Override
            public void onCancel() {
                searchField.setText("");
            }
        });

        // Add a DocumentListener to the searchField
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkIfEmpty();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkIfEmpty();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkIfEmpty();
            }

            private void checkIfEmpty() {
                if (searchField.getText().trim().isEmpty()) {
                    initData();
                }
            }
        });

        repaint();
        revalidate();
    }

    public void initData() {

        DefaultTableModel model = (DefaultTableModel) customerTable.getModel();

        model.setRowCount(0);

        try {
            Statement s = Main.getDbCon().createStatement();

            ResultSet rs = s.executeQuery("select * from customers");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("customers_pk"), rs.getString("name"), rs.getString("mobile_Number"), rs.getString("email")});
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

    private void searchData(String data) {

        DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
        model.setRowCount(0);
        try {

            Statement s = Main.getDbCon().createStatement();

            ResultSet rs = s.executeQuery("SELECT * FROM customers WHERE name LIKE '%" + data + "%' OR customers_pk LIKE '%" + data + "%'");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("customers_pk"), rs.getString("name"), rs.getString("mobile_Number"), rs.getString("email")});
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new components.ScrollPaneWin11();
        customerTable = new javax.swing.JTable();
        panelBorder1 = new otherForms.PanelBorder();
        jLabel11 = new javax.swing.JLabel();
        numberField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        fnameField = new javax.swing.JTextField();
        circleImageAvatar1 = new components.CircleImageAvatar();
        jLabel6 = new javax.swing.JLabel();
        editBtn = new javax.swing.JButton();
        dualBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        ErrorMessage = new javax.swing.JLabel();
        searchField = new components.TextFieldAnimation();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(40, 72, 102));

        customerTable.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Contact Number", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(customerTable);
        if (customerTable.getColumnModel().getColumnCount() > 0) {
            customerTable.getColumnModel().getColumn(0).setResizable(false);
            customerTable.getColumnModel().getColumn(1).setResizable(false);
            customerTable.getColumnModel().getColumn(2).setResizable(false);
            customerTable.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 172, 680, 580));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("09");

        numberField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        numberField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        numberField.setMaximumSize(new java.awt.Dimension(252, 35));
        numberField.setPreferredSize(new java.awt.Dimension(252, 35));
        numberField.setSelectionColor(new java.awt.Color(204, 204, 204));
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

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Mobile Number:");

        emailField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        emailField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        emailField.setMaximumSize(new java.awt.Dimension(289, 35));
        emailField.setMinimumSize(new java.awt.Dimension(289, 35));
        emailField.setPreferredSize(new java.awt.Dimension(289, 35));
        emailField.setSelectionColor(new java.awt.Color(204, 204, 204));
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

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Email:");

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 51, 51));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("*");

        fnameField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        fnameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        fnameField.setPreferredSize(new java.awt.Dimension(18, 35));
        fnameField.setSelectionColor(new java.awt.Color(204, 204, 204));
        fnameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fnameFieldMouseClicked(evt);
            }
        });

        circleImageAvatar1.setBackground(new java.awt.Color(15, 106, 191));
        circleImageAvatar1.setForeground(new java.awt.Color(15, 106, 191));
        circleImageAvatar1.setBorderSize(1);
        circleImageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logInUser.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Full Name:");

        editBtn.setBackground(new java.awt.Color(15, 106, 191));
        editBtn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("Edit");
        editBtn.setBorderPainted(false);
        editBtn.setFocusPainted(false);
        editBtn.setPreferredSize(new java.awt.Dimension(29, 25));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        dualBtn.setBackground(new java.awt.Color(15, 106, 191));
        dualBtn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        dualBtn.setForeground(new java.awt.Color(255, 255, 255));
        dualBtn.setText("Add");
        dualBtn.setBorderPainted(false);
        dualBtn.setFocusPainted(false);
        dualBtn.setPreferredSize(new java.awt.Dimension(29, 25));
        dualBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dualBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(15, 106, 191));
        deleteBtn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete");
        deleteBtn.setBorderPainted(false);
        deleteBtn.setFocusPainted(false);
        deleteBtn.setPreferredSize(new java.awt.Dimension(29, 25));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        ErrorMessage.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ErrorMessage.setForeground(new java.awt.Color(255, 51, 51));
        ErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorMessage.setText("      ");
        ErrorMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fnameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ErrorMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel19)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dualBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(circleImageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(circleImageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dualBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 170, 370, 580));

        searchField.setBackground(new java.awt.Color(240, 240, 240));
        searchField.setAnimationColor(new java.awt.Color(15, 106, 191));
        searchField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        searchField.setHintText("Search a customer");
        searchField.setSelectionColor(new java.awt.Color(204, 204, 204));
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 363, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Customer Information");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 440, 68));
    }// </editor-fold>//GEN-END:initComponents

    private void fnameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fnameFieldMouseClicked
        ErrorMessage.setText(" ");
    }//GEN-LAST:event_fnameFieldMouseClicked

    private void numberFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numberFieldMouseClicked
        ErrorMessage.setText(" ");
    }//GEN-LAST:event_numberFieldMouseClicked

    private void numberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberFieldActionPerformed

    private void numberFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberFieldKeyTyped
        String value = numberField.getText();
        int l = value.length();

        // Check if the key typed is a number or a space
        char c = evt.getKeyChar();
        if ((c >= '0' && c <= '9')) {
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

    private void emailFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldMouseClicked

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        ErrorMessage.setText(" ");

        if (isEditing) {
            int row = customerTable.getSelectedRow();

            if (row == -1) {
                ErrorMessage.setText("Please select a row to edit!");
            } else {
                String name = customerTable.getValueAt(row, 1).toString();
                String number = "";
                if (customerTable.getValueAt(row, 2).equals("")) {
                    number = "";
                } else {
                    number = customerTable.getValueAt(row, 2).toString().substring(2);
                }

                String email = customerTable.getValueAt(row, 3).toString();

                fnameField.setText(name);
                numberField.setText(number);
                emailField.setText(email);

                deleteBtn.setVisible(true);

                editBtn.setText("Cancel");
                dualBtn.setText("Update");
                isEditing = false;
            }

        } else {
            fnameField.setText("");
            numberField.setText("");
            emailField.setText("");

            editBtn.setText("Edit");
            dualBtn.setText("Add");
            isEditing = true;

            deleteBtn.setVisible(false);
        }

    }//GEN-LAST:event_editBtnActionPerformed

    private void dualBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dualBtnActionPerformed
        ErrorMessage.setText(" ");
        String nameField = fnameField.getText().trim();

        if (!isEditing) {
            ErrorMessage.setText(" ");
            int row = customerTable.getSelectedRow();

            String data = nameField;
            if (row == -1) {
                ErrorMessage.setText("You did not select a row to update!");
            } else {
                if (nameField.isEmpty()) {
                    ErrorMessage.setText("Please complete all required fields with *");
                } else if (numberField.getText().trim().length() < 9 && !numberField.getText().trim().isEmpty()) {
                    ErrorMessage.setText("Invalid mobile number!");
                } else {
                    try {

                        Connection con = Main.getDbCon();

                        PreparedStatement ps = con.prepareStatement("UPDATE customers SET name = ?, mobile_Number = ?, email = ? where customers_pk = ?");
                        ps.setString(1, data);

                        if (numberField.getText().trim().isEmpty()) {
                            ps.setString(2, numberField.getText().trim());
                        } else {
                            ps.setString(2, "09" + numberField.getText().trim());
                        }

                        ps.setString(3, emailField.getText().trim());
                        ps.setString(4, (String) customerTable.getValueAt(row, 0));
                        ps.executeUpdate();

                        ErrorMessage.setText(" ");

                        home.form5Customers = new Form5();
                        home.setForm(home.form5Customers);
                        home.successUpdateCustomer.showNotification();

                        // Close the ResultSet
                        ps.close();
                        con.close();

                    } catch (SQLException e) {
                        e.printStackTrace(); // Print the exception details for debugging
                        JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        Main.closeCon();
                    }
                }

            }

        } else {
            if (nameField.isEmpty()) {
                ErrorMessage.setText("Please complete all required fields with *");
            } else if (numberField.getText().trim().length() < 9 && !numberField.getText().trim().isEmpty()) {
                ErrorMessage.setText("Invalid mobile number!");
            } else {

                try {
                    Connection con = Main.getDbCon();

                    String checkUserQuery = "SELECT COUNT(*) FROM customers WHERE name = ?";
                    PreparedStatement ps = con.prepareStatement(checkUserQuery);
                    ps.setString(1, nameField);
                    ResultSet rs = ps.executeQuery();
                    rs.next();
                    int userCount = rs.getInt(1);

                    if (userCount > 0) {
                        ErrorMessage.setText("Customer already exist!");

                    } else {

                        String insertCustomer = "INSERT INTO customers (name, mobile_Number, email) values (?, ?, ?)";
                        ps = con.prepareStatement(insertCustomer);
                        ps.setString(1, nameField);
                        ps.setString(2, numberField.getText().trim());
                        ps.setString(3, emailField.getText().trim());
                        ps.executeUpdate();

                        home.form5Customers = new Form5();
                        home.setForm(home.form5Customers);
                        home.successAddCustomer.showNotification();
                    }

                    ps.close();
                    con.close();

                } catch (SQLException e) {
                    e.printStackTrace(); // Print the exception details for debugging
                    JOptionPane.showMessageDialog(null, "An error occurred in database. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    Main.closeCon();
                }
            }
        }


    }//GEN-LAST:event_dualBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        ErrorMessage.setText(" ");
        int row = customerTable.getSelectedRow();
        if (row == -1) {
            ErrorMessage.setText("You did not select a row to delete!");

        } else {

            int choice = JOptionPane.showConfirmDialog(this, "Are you sure to delete this data?", "Delete Data", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                String password = JOptionPane.showInputDialog(this, "Enter your password:", "");
                if (password != null && password.equals(Main.getStoredPassword())) {

                    try {
                        Connection con = Main.getDbCon();
                        PreparedStatement ps = con.prepareStatement("DELETE FROM customers WHERE name = '" + customerTable.getValueAt(row, 1) + "'");

                        // Execute the DELETE statement
                        int rowsDeleted = ps.executeUpdate();

                        // Check if any rows were deleted
                        if (rowsDeleted > 0) {
                            home.form5Customers = new Form5();
                            home.setForm(home.form5Customers);
                            home.successDeleteCustomer.showNotification();

                        } else {
                            System.out.println("No rows were deleted.");
                        }

                        // Close the ResultSet
                        ps.close();
                        con.close();

                    } catch (SQLException e) {
                        e.printStackTrace(); // Print the exception details for debugging
                        JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        Main.closeCon();
                    }

                }
            }

        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(grphcs);
    }

    public void initTable() {
        customerTable.setShowGrid(false);

        if (customerTable.getRowCount() > 0) {
            customerTable.setRowSelectionInterval(0, 0);
        }

        // Set custom cell renderer for all columns
        ModernCellRenderer cellRenderer = new ModernCellRenderer();
        for (int i = 1; i < customerTable.getColumnCount(); i++) { // Skip the first column for now
            TableColumn column = customerTable.getColumnModel().getColumn(i);
            column.setCellRenderer(cellRenderer);
        }

        // Set custom cell renderer for the first column to center text and alternate row colors
        CenteredCellRenderer centeredRenderer = new CenteredCellRenderer();
        TableColumn firstColumn = customerTable.getColumnModel().getColumn(0);
        firstColumn.setCellRenderer(centeredRenderer);

        // Set the preferred width of the first column to fit the content
        int width = getColumnWidth(customerTable, 0) + 40;
        firstColumn.setPreferredWidth(width);
        firstColumn.setMaxWidth(width);
        firstColumn.setMinWidth(width);

        // Set custom header renderer
        JTableHeader header = customerTable.getTableHeader();
        header.setDefaultRenderer(new ModernHeaderRenderer()); // Use the centered header renderer for the whole table
        header.setPreferredSize(new Dimension(0, 40));
        header.setReorderingAllowed(false);

        customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        customerTable.setRowHeight(35);

        customerTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = customerTable.getSelectedRow();
                    if (selectedRow != -1 && isEditing == false) {
                        String name = customerTable.getValueAt(selectedRow, 1).toString();
                        String number = customerTable.getValueAt(selectedRow, 2).toString();
                        String email = customerTable.getValueAt(selectedRow, 3).toString();

                        fnameField.setText(name);
                        numberField.setText(number);
                        emailField.setText(email);

                    }
                }
            }
        });

    }

    // Method to calculate the preferred width of a column based on its content
    private static int getColumnWidth(JTable table, int columnIndex) {
        int width = 0; // Min width
        TableColumn column = table.getColumnModel().getColumn(columnIndex);
        Component comp;
        Font font = new Font("SansSerif", Font.PLAIN, 17);
        for (int row = 0; row < table.getRowCount(); row++) {
            comp = table.prepareRenderer(table.getCellRenderer(row, columnIndex), row, columnIndex);
            comp.setFont(font); // Ensure font is set for accurate width calculation
            width = Math.max(comp.getPreferredSize().width + 20, width); // Adding padding
        }
        return width;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrorMessage;
    private components.CircleImageAvatar circleImageAvatar1;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton dualBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField fnameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numberField;
    private otherForms.PanelBorder panelBorder1;
    private components.TextFieldAnimation searchField;
    // End of variables declaration//GEN-END:variables
}
