/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package msgPopup;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import settings.GlassPanePopup;

/**
 *
 * @author jairus
 */
public class emailedUsernameMsg extends javax.swing.JPanel {

    /** Creates new form emailedUsernameMsg */
    public emailedUsernameMsg() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt = new javax.swing.JLabel();
        confirmBtn = new components.RoundedButtons();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(70, 191, 50));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Email Sent Success!");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/emailSent.png"))); // NOI18N

        txt.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txt.setForeground(new java.awt.Color(102, 102, 102));
        txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt.setText("Kindly check your email inbox.");

        confirmBtn.setForeground(new java.awt.Color(255, 255, 255));
        confirmBtn.setText("Confirm");
        confirmBtn.setBorderColor(new java.awt.Color(70, 191, 50));
        confirmBtn.setBorderPainted(false);
        confirmBtn.setColor(new java.awt.Color(70, 191, 50));
        confirmBtn.setColorClick(new java.awt.Color(70, 191, 50));
        confirmBtn.setColorOver(new java.awt.Color(70, 191, 50));
        confirmBtn.setFocusPainted(false);
        confirmBtn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(177, 177, 177))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt)
                .addGap(27, 27, 27)
                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        GlassPanePopup.closePopupAll();
    }//GEN-LAST:event_confirmBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.RoundedButtons confirmBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables

}
