/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package msgPopup;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.text.*;
import settings.GlassPanePopup;

/**
 *
 * @author jairus
 */
public class verifyCodeMsg extends javax.swing.JPanel {

    private AtomicInteger secondsLeft = new AtomicInteger(300);
    private Timer timer;

    public verifyCodeMsg() {
        initComponents();
        setOpaque(false);
        txt.setBackground(new Color(0, 0, 0, 0));
        txt.setOpaque(false);
        txt1.setBackground(new Color(0, 0, 0, 0));
        txt1.setOpaque(false);
        code1.requestFocus();
        code1.setEchoChar((char) 0);
        code2.setEchoChar((char) 0);
        code3.setEchoChar((char) 0);
        code4.setEchoChar((char) 0);
        code5.setEchoChar((char) 0);
        code6.setEchoChar((char) 0);

        // Set up timer to update countdown label
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsLeft.decrementAndGet();
                if (secondsLeft.get() >= 0) {
                    txt1.setText("Enter the code before it expires in " + secondsLeft + " seconds.");

                } else {
                    forgotPasswordMsg.Code = "";
                    timer.stop();
                    GlassPanePopup.closePopupLast();
                    System.out.println("Code :" + forgotPasswordMsg.Code);
                }
            }
        });
        timer.start();

        ((AbstractDocument) code1.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (offset == 1) {
                    return; // Only allow one character
                }
                super.replace(fb, offset, length, text, attrs);
                code2.requestFocusInWindow(); 
            }
        });

        ((AbstractDocument) code2.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (offset == 1) {
                    return; // Only allow one character
                }
                super.replace(fb, offset, length, text, attrs);
                code3.requestFocusInWindow(); 
            }
        });

        ((AbstractDocument) code3.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (offset == 1) {
                    return; // Only allow one character
                }
                super.replace(fb, offset, length, text, attrs);
                code4.requestFocusInWindow(); 
            }
        });

        ((AbstractDocument) code4.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (offset == 1) {
                    return; // Only allow one character
                }
                super.replace(fb, offset, length, text, attrs);
                code5.requestFocusInWindow(); 
            }
        });

        ((AbstractDocument) code5.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (offset == 1) {
                    return; // Only allow one character
                }
                super.replace(fb, offset, length, text, attrs);
                code6.requestFocusInWindow(); 
            }
        });

        ((AbstractDocument) code6.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (offset == 1) {
                    return; // Only allow one character
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });
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
        code1 = new javax.swing.JPasswordField();
        code2 = new javax.swing.JPasswordField();
        code3 = new javax.swing.JPasswordField();
        code4 = new javax.swing.JPasswordField();
        code5 = new javax.swing.JPasswordField();
        code6 = new javax.swing.JPasswordField();
        verifyBtn = new components.RoundedButtons();
        txt1 = new javax.swing.JLabel();
        resendCodeBtn = new javax.swing.JButton();
        cmdCancel = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Verification Code");

        txt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txt.setForeground(new java.awt.Color(102, 102, 102));
        txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt.setText("We have sent the verification code through email.");

        code1.setBackground(new java.awt.Color(238, 238, 238));
        code1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        code1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        code1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        code1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                code1ActionPerformed(evt);
            }
        });
        code1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                code1KeyTyped(evt);
            }
        });

        code2.setBackground(new java.awt.Color(238, 238, 238));
        code2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        code2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        code2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        code2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                code2KeyTyped(evt);
            }
        });

        code3.setBackground(new java.awt.Color(238, 238, 238));
        code3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        code3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        code3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        code3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                code3KeyTyped(evt);
            }
        });

        code4.setBackground(new java.awt.Color(238, 238, 238));
        code4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        code4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        code4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        code4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                code4KeyTyped(evt);
            }
        });

        code5.setBackground(new java.awt.Color(238, 238, 238));
        code5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        code5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        code5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        code5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                code5KeyTyped(evt);
            }
        });

        code6.setBackground(new java.awt.Color(238, 238, 238));
        code6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        code6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        code6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        code6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                code6KeyTyped(evt);
            }
        });

        verifyBtn.setBackground(new java.awt.Color(70, 191, 50));
        verifyBtn.setForeground(new java.awt.Color(255, 255, 255));
        verifyBtn.setText("Verify");
        verifyBtn.setBorderColor(new java.awt.Color(70, 191, 50));
        verifyBtn.setBorderPainted(false);
        verifyBtn.setColor(new java.awt.Color(70, 191, 50));
        verifyBtn.setColorClick(new java.awt.Color(70, 191, 50));
        verifyBtn.setColorOver(new java.awt.Color(70, 191, 50));
        verifyBtn.setFocusPainted(false);
        verifyBtn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        verifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyBtnActionPerformed(evt);
            }
        });

        txt1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt1.setForeground(new java.awt.Color(102, 102, 102));
        txt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt1.setText("Enter the code before in expires in 300 seconds.");

        resendCodeBtn.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        resendCodeBtn.setForeground(new java.awt.Color(15, 106, 191));
        resendCodeBtn.setText("Didn't get a code?");
        resendCodeBtn.setBorderPainted(false);
        resendCodeBtn.setContentAreaFilled(false);
        resendCodeBtn.setFocusPainted(false);
        resendCodeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resendCodeBtnActionPerformed(evt);
            }
        });

        cmdCancel.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        cmdCancel.setForeground(new java.awt.Color(15, 106, 191));
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
                        .addGap(164, 164, 164)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(verifyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resendCodeBtn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(code1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(code2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(code3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(code4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(code5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(code6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txt)))
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1))
                    .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(txt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(code1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(code2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(code3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(code4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(code5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(code6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(verifyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resendCodeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void verifyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyBtnActionPerformed

        System.out.println(secondsLeft);

        String enteredVC = code1.getText() + code2.getText() + code3.getText() + code4.getText() + code5.getText() + code6.getText();

        System.out.println(enteredVC);

        if (enteredVC.equals(forgotPasswordMsg.Code)) {
            timer.stop();
            GlassPanePopup.closePopupLast();
            resetPasswordMsg obj8 = new resetPasswordMsg();
            GlassPanePopup.showPopup(obj8);
            forgotPasswordMsg.Code = "";
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Verification Code!", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_verifyBtnActionPerformed

    private void code1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_code1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_code1ActionPerformed

    private void code1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_code1KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        } else {
            code2.requestFocus();
        }
    }//GEN-LAST:event_code1KeyTyped

    private void code2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_code2KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        } else {
            code3.requestFocus();
        }
    }//GEN-LAST:event_code2KeyTyped

    private void code3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_code3KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume(); // Ignore non-digit characters
        } else {
            code4.requestFocus(); // Request focus on pass2
        }
    }//GEN-LAST:event_code3KeyTyped

    private void code4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_code4KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume(); // Ignore non-digit characters
        } else {
            code5.requestFocus(); // Request focus on pass2
        }
    }//GEN-LAST:event_code4KeyTyped

    private void code5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_code5KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume(); // Ignore non-digit characters
        } else {
            code6.requestFocus(); // Request focus on pass2
        }
    }//GEN-LAST:event_code5KeyTyped

    private void code6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_code6KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume(); // Ignore non-digit characters
        }
    }//GEN-LAST:event_code6KeyTyped

    private void resendCodeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resendCodeBtnActionPerformed
        try {
            forgotPasswordMsg.emailCode(forgotPasswordMsg.storedEmail);

        } catch (Exception ex) {
            Logger.getLogger(verifyCodeMsg.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "     We have sent a new email for the\nverification code. Kindly check your email.", "", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Resend a new code: " + forgotPasswordMsg.Code);
    }//GEN-LAST:event_resendCodeBtnActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_cmdCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdCancel;
    private javax.swing.JPasswordField code1;
    private javax.swing.JPasswordField code2;
    private javax.swing.JPasswordField code3;
    private javax.swing.JPasswordField code4;
    private javax.swing.JPasswordField code5;
    private javax.swing.JPasswordField code6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton resendCodeBtn;
    private javax.swing.JLabel txt;
    private javax.swing.JLabel txt1;
    private components.RoundedButtons verifyBtn;
    // End of variables declaration//GEN-END:variables
}
