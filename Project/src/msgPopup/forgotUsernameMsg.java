/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package msgPopup;

import Main.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;
import java.net.URLConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import settings.GlassPanePopup;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author jairus
 */
public class forgotUsernameMsg extends javax.swing.JPanel {
    
    


    public forgotUsernameMsg() {
        initComponents();
        setOpaque(false);
        txt.setBackground(new Color(0, 0, 0, 0));
        txt.setOpaque(false);
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
    
    

    // Code for email sending
    public static void emailUsername(String recipient) throws Exception {

        System.out.print("sending...");

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

        Message message = prepareUsernameMessage(session, myAccountEmail, recipient);
        Transport.send(message);
        System.out.println("sent!");
    }

    private static Message prepareUsernameMessage(Session session, String myAccountEmail, String recipient) throws MessagingException {
        String storedUsername = "", storedName = "";

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Inventory System Username Request");

            try {
                Statement s = Main.getDbCon().createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM users WHERE email = '" + recipient + "'");

                while (rs.next()) {
                    storedUsername = rs.getString("userName");
                    storedName = rs.getString("name");
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

            String htmlText = "<h3 style=\"color:black;\">Find Your Username!</h3>"
                    + "<p style=\"color:black;\">Dear Mr./Mrs. " + storedName + ", </p>"
                    + "<p style=\"color:black;\"> Thank you for reaching us out! We've received your request for your username to log in to our Mark-It Inventory System. </p>"
                    + "<p style=\"color:black;\"> You username is:  <strong>" + storedUsername + "</strong> </p>"
                    + "<p style=\"color:black;\"> Please note that this message is generated automatically, so there's no need to reply. If you have any further questions or concerns, feel free to reach out our administrators.</p>"
                    + "<p style=\"color:black;\">Best regards,</p>"
                    + "<p style=\"color:black;\">Mark-It Inventory System </p>";

            message.setContent(htmlText, "text/html");
            return message;
        } catch (AddressException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sendUsernameBtn = new components.RoundedButtons();
        txt = new javax.swing.JLabel();
        field = new javax.swing.JTextField();
        cmdCancel = new components.RoundedButtons();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 106, 191));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Forgot your username?");

        sendUsernameBtn.setBackground(new java.awt.Color(70, 191, 50));
        sendUsernameBtn.setForeground(new java.awt.Color(255, 255, 255));
        sendUsernameBtn.setText("Send");
        sendUsernameBtn.setBorderColor(new java.awt.Color(70, 191, 50));
        sendUsernameBtn.setBorderPainted(false);
        sendUsernameBtn.setColor(new java.awt.Color(70, 191, 50));
        sendUsernameBtn.setColorClick(new java.awt.Color(70, 191, 50));
        sendUsernameBtn.setColorOver(new java.awt.Color(70, 191, 50));
        sendUsernameBtn.setFocusPainted(false);
        sendUsernameBtn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        sendUsernameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendUsernameBtnActionPerformed(evt);
            }
        });

        txt.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txt.setForeground(new java.awt.Color(102, 102, 102));
        txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt.setText("Enter your registered email address to receive your username.");

        field.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        field.setForeground(new java.awt.Color(153, 153, 153));
        field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        field.setText("Enter Email Address");
        field.setOpaque(false);
        field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldFocusLost(evt);
            }
        });
        field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldActionPerformed(evt);
            }
        });

        cmdCancel.setBackground(new java.awt.Color(191, 50, 50));
        cmdCancel.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel.setText("Cancel");
        cmdCancel.setBorderColor(new java.awt.Color(191, 50, 50));
        cmdCancel.setBorderPainted(false);
        cmdCancel.setColor(new java.awt.Color(191, 50, 50));
        cmdCancel.setColorClick(new java.awt.Color(191, 50, 50));
        cmdCancel.setColorOver(new java.awt.Color(191, 50, 50));
        cmdCancel.setFocusPainted(false);
        cmdCancel.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(119, 119, 119))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sendUsernameBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(field))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(txt)
                .addGap(18, 18, 18)
                .addComponent(field, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendUsernameBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendUsernameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendUsernameBtnActionPerformed
        if (!field.getText().isEmpty() && !field.getText().trim().equalsIgnoreCase("Enter Email Address")) {
            try {
                String storedEmail ="";

                URL url = new URL("http://www.google.com");
                URLConnection connection = url.openConnection();
                connection.connect();

                String findUsername = field.getText();

                boolean emailFound = false;
                try {
                    Statement s = Main.getDbCon().createStatement();
                    ResultSet rs = s.executeQuery("SELECT * FROM users WHERE email = '" + findUsername + "' AND status = 'Active'");

                    while (rs.next()) {
                        emailFound = true;
                        storedEmail = rs.getString("email"); // Get the stored email from the database
                        System.out.println("Email found: " + storedEmail);
                    }

                    if (emailFound) {
                        try {
                            GlassPanePopup.closePopupLast();
                            emailUsername(storedEmail);
                            emailedUsernameMsg obj3 = new emailedUsernameMsg();
                            GlassPanePopup.showPopup(obj3);
                            

                        } catch (Exception ex) {
                            Logger.getLogger(forgotUsernameMsg.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "   Sorry, it looks like the account of the email\nyou entered is either inactive or not registered.", "Email Not Found!", JOptionPane.ERROR_MESSAGE);
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

            } catch (Exception e) {
                GlassPanePopup.closePopupLast();
                noWiFiMsg obj2 = new noWiFiMsg();
                obj2.closeBtnEvnt(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        GlassPanePopup.closePopupLast();
                    }
                });
                GlassPanePopup.showPopup(obj2);
            }

        }
    }//GEN-LAST:event_sendUsernameBtnActionPerformed

    private void fieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldFocusGained
        field.setText(null);
        field.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_fieldFocusGained

    private void fieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldFocusLost
        if (field.getText().isEmpty()) {
            field.setText("Enter Email Address");
            field.setForeground(new Color(153, 153, 153));
        }


    }//GEN-LAST:event_fieldFocusLost

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.RoundedButtons cmdCancel;
    private javax.swing.JTextField field;
    private javax.swing.JLabel jLabel1;
    private components.RoundedButtons sendUsernameBtn;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables
}
