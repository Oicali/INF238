/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherForms;

import Main.Main;
import Main.home;
import Pages.Form0;
import Pages.Form2;
import Pages.Form3;
import Pages.Form4;
import Pages.Form5;
import java.awt.Cursor;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import settings.GlassPanePopup;

/**
 *
 * @author ASUS
 */
public class checkOut extends javax.swing.JDialog {

    private DecimalFormat decimal = new DecimalFormat("0.00");
    private String typedName = "";
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM-dd-yyyy HH:mm");
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LENGTH = 12;
    private static final SecureRandom RANDOM = new SecureRandom();

    public checkOut(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initCustomers();
        cmdCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        double total = 0;
        for (int i = 0; i < Form3.cartList.size(); i++) {
            total = total + Double.parseDouble(Form3.orderTable.getValueAt(i, 2).toString());
        }
        totalLbl.setText("₱" + decimal.format(total));

        // Create a rounded frame
        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        setShape(roundedRectangle);

    }

    private static String transactionCode() {
        StringBuilder otpBuilder = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            otpBuilder.append(CHARACTERS.charAt(index));
        }
        return otpBuilder.toString();
    }

    public static String capitalizeFirstLetters(String str) {
        // Split the string into words
        String[] words = str.split("\\s+");

        StringBuilder capitalizedString = new StringBuilder();

        // Capitalize the first letter of each word
        for (String word : words) {
            if (word.length() > 0) {
                capitalizedString.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        // Remove the trailing space and return the result
        return capitalizedString.toString().trim();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        ErrorMessage = new javax.swing.JLabel();
        customerField = new components.TextFieldSuggestion();
        jLabel7 = new javax.swing.JLabel();
        locationField = new javax.swing.JTextField();
        paymentMethod = new components.Combobox();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmdCancel = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        totalLbl = new javax.swing.JLabel();
        generateBtn = new components.RoundedButtons();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Customer:");

        ErrorMessage.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ErrorMessage.setForeground(new java.awt.Color(255, 51, 51));
        ErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        customerField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        customerField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerFieldActionPerformed(evt);
            }
        });
        customerField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customerFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customerFieldKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Total Price:");

        locationField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        locationField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        locationField.setSelectionColor(new java.awt.Color(204, 204, 204));
        locationField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                locationFieldMouseClicked(evt);
            }
        });
        locationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationFieldActionPerformed(evt);
            }
        });

        paymentMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Digital Payment" }));
        paymentMethod.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        paymentMethod.setLabelText("");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Location:");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Delivery Information");

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

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Mode of Payment:");

        totalLbl.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        totalLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalLbl.setText("₱999,999,999,999,999.00");

        generateBtn.setForeground(new java.awt.Color(255, 255, 255));
        generateBtn.setText("Proceed");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cmdCancel))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(generateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(locationField, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerField, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(ErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void locationFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_locationFieldMouseClicked
        ErrorMessage.setText(" ");
    }//GEN-LAST:event_locationFieldMouseClicked

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        GlassPanePopup.closePopupLast();
        dispose();
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void customerFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerFieldActionPerformed

    // This does not work if the caret is in the middle or tabbed
    private void customerFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerFieldKeyTyped
//        if (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE && customerField.getCaretPosition() == 0) {
//            customerField.setText("");
//            tabbed = false;
//            typedName = "";
//            System.out.println("1");
//        } else if (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
//            tabbed = false;
//            typedName = typedName + evt.getKeyChar();
//            System.out.println("2");
//        } else if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
//            tabbed = true;
//            customerField.setCaretPosition(customerField.getText().length());
//            typedName = customerField.getText().trim();
//            System.out.println("3");
//        } else {
//            typedName = typedName + evt.getKeyChar();
//            System.out.println("4");
//        }

    }//GEN-LAST:event_customerFieldKeyTyped

    private void generateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBtnActionPerformed
        String customer = capitalizeFirstLetters(customerField.getText());
        LocalDateTime now = LocalDateTime.now();
        String dateOrdered = dtf.format(now);
        String code = transactionCode(); //
        String delivery_status = "NOT DELIVERED"; //
        String location = locationField.getText();
        String mop = (String) paymentMethod.getSelectedItem();
        String total = totalLbl.getText();

        if (customerField.getText().trim().isEmpty() || location.trim().isEmpty()) {
            ErrorMessage.setText("Please complete all required fields with *");
        } else {
            ErrorMessage.setText(" ");

            try {
                Connection con = Main.getDbCon();
                Statement s = Main.getDbCon().createStatement();

                String checkUserQuery = "SELECT COUNT(*) FROM customers WHERE name = ?";
                PreparedStatement ps = con.prepareStatement(checkUserQuery);
                ps.setString(1, customer);
                ResultSet rs = ps.executeQuery();
                ResultSet rs2 = s.executeQuery("Select * from products");
                rs.next();
                int userCount = rs.getInt(1);

                if (userCount == 0) {
                    String insertCustomer = "INSERT INTO customers (name) values (?)";
                    ps = con.prepareStatement(insertCustomer);
                    ps.setString(1, customer);
                    System.out.println(customer);
                    ps.executeUpdate();
                }

                for (int i = 0; i < Form3.cartList.size(); i++) {
                    String query = "INSERT INTO orders (name, item_ordered, quantity, payment_Method, total_Price, date_Ordered, location, delivery_status, code) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ? ,?)";
                    ps = con.prepareStatement(query);
                    ps.setString(1, customer);
                    ps.setString(2, Form3.cartList.get(i));
                    ps.setString(3, Form3.orderTable.getValueAt(i, 1).toString());
                    ps.setString(4, mop);
                    ps.setString(5, total);
                    ps.setString(6, dateOrdered);
                    ps.setString(7, location);
                    ps.setString(8, delivery_status);
                    ps.setString(9, code);
                    ps.executeUpdate();

                    int OldQty = 0;
                    rs2 = s.executeQuery("Select * from products where item_Name = '" + Form3.cartList.get(i) + "'");
                    if (rs2.next()) {
                        OldQty = rs2.getInt("quantity");
                    }
                    
                    System.out.println("Old quantity: " + OldQty);

                    String query2 = "UPDATE products SET quantity = ? where item_Name = ?";
                    ps = con.prepareStatement(query2);
                    ps.setString(1, String.valueOf(OldQty - Integer.parseInt(Form3.orderTable.getValueAt(i, 1).toString())));
                    
                    System.out.println("new quantity: " + String.valueOf(OldQty - Integer.parseInt(Form3.orderTable.getValueAt(i, 1).toString())));
                    ps.setString(2, Form3.cartList.get(i));
                    ps.executeUpdate();

                }

                GlassPanePopup.closePopupLast();
                dispose();

                home.form3Order = new Form3();
                home.setForm(home.form3Order);
                home.form2Products = new Form2();
                home.form4ViewOrder = new Form4();
                home.form5Customers = new Form5();
                home.form0DashBoard = new Form0();

                home.successSetOrder.showNotification();

                s.close();
                ps.close();
                rs.close();
                rs2.close();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace(); // Print the exception details for debugging
                JOptionPane.showMessageDialog(null, "An error occurred in database. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                Main.closeCon();
            }
        }


    }//GEN-LAST:event_generateBtnActionPerformed

    private void customerFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerFieldKeyPressed

    }//GEN-LAST:event_customerFieldKeyPressed

    private void locationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locationFieldActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(checkOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(checkOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(checkOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(checkOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                checkOut dialog = new checkOut(new javax.swing.JFrame(), true);
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

    public void initCustomers() {
        try {
            Statement s = Main.getDbCon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM customers");

            while (rs.next()) {
                customerField.addItemSuggestion(rs.getString("name"));
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrorMessage;
    private javax.swing.JButton cmdCancel;
    private components.TextFieldSuggestion customerField;
    private components.RoundedButtons generateBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField locationField;
    private components.Combobox paymentMethod;
    private javax.swing.JLabel totalLbl;
    // End of variables declaration//GEN-END:variables
}
