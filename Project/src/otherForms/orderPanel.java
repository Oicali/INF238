/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherForms;

import cards.Item_Card;
import model.Model_Products;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import Pages.*;
import static Pages.Form2.f2ErrorMessage;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class orderPanel extends javax.swing.JPanel {

    private DecimalFormat decimal = new DecimalFormat("0.00");

    public orderPanel() {
        initComponents();
        
        
    }

    public orderPanel(String Category) {
        initComponents();
        jLabel1.setText(Category);
        
    }

    public void addOrderItem(Model_Products data) {
        Item_Card card = new Item_Card();
        card.setData(data);
        
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {

                if (SwingUtilities.isLeftMouseButton(me)) {

                        System.out.println("Click me !!!");

                }
            }
        });

        jPanel1.add(card);
        jPanel1.repaint();
        jPanel1.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        item_Card4 = new cards.Item_Card();
        item_Card5 = new cards.Item_Card();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new components.ScrollPaneWin11();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(708, 310));
        setMinimumSize(new java.awt.Dimension(605, 310));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(620, 310));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("Category Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));
        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 52, 610, 250));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cards.Item_Card item_Card4;
    private cards.Item_Card item_Card5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}