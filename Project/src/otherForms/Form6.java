/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherForms;

import Main.Main;
import Main.home;
import components.ScrollBarCustom;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import popUps.placeholder;
import settings.GlassPanePopup;
import settings.Model_User;

/**
 *
 * @author ASUS
 */
public class Form6 extends javax.swing.JPanel {

    public Form6() {
        initComponents();
        setOpaque(false);
        initData();
        
        /*DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        try {
            Statement s = Main.getDbCon().createStatement();
            //ResultSet rs = s.executeQuery("SELECT * FROM users WHERE userName = '" + username + "' AND userRole = '" + selectedRole + "' AND status = 'Active'");
            //ResultSet rs = s.executeQuery("SELECT * FROM users WHERE userName = '" + username + "' AND status = 'Active'");
            ResultSet rs = s.executeQuery("select * from users");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("users_pk"), rs.getString("fullname"), rs.getString("userRole"), rs.getString("gender")});
            }
            // Close the ResultSet
            rs.close();
            s.close();

        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception details for debugging
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            Main.closeCon();
        }*/
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

        jButton2 = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        panelItem2 = new components.PanelItem();
        card1 = new otherForms.Card();
        card2 = new otherForms.Card();
        jTextField1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBar(new ScrollBarCustom());

        panelItem2.add(card1);
        panelItem2.add(card2);

        scroll.setViewportView(panelItem2);

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 1071, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        
    }//GEN-LAST:event_formComponentShown

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        model.removeRow(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    public void addUser(Model_User data){
        Card card = new Card();
        card.setData(data);
        card.addMouseListener(new MouseAdapter (){
            @Override
            public void mousePressed(MouseEvent me){
                if(SwingUtilities.isLeftMouseButton(me)){
                    GlassPanePopup.showPopup(new placeholder());
                    
                    new updateUser(null, true, data.getUserName()).show();
                }
            }
        });
        panelItem2.add(card);
        panelItem2.repaint();
        panelItem2.revalidate();
    }
    
    public void initData(){
        try {
            Statement s = Main.getDbCon().createStatement();
      
            ResultSet rs = s.executeQuery("select * from users");

            while (rs.next()) {
                addUser(new Model_User(rs.getString("users_pk"), rs.getString("fname"), rs.getString("lname"), rs.getString("userRole"),rs.getString("userName"),new ImageIcon(rs.getBytes("img")),rs.getString("status")));
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
    private otherForms.Card card1;
    private otherForms.Card card2;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField jTextField1;
    private components.PanelItem panelItem2;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
