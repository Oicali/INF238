/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import interfaces.EventMenuSelected;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComponent;
import otherForms.*;

/**
 *
 * @author jairus
 */
public class home extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private Form0 form0;
    private Form1 form1;
    private Form2 form2;
    private Form3 form3;
    private Form7 form7;

    public home() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setForm(form0); // added to be in form 0 by default
        menu.initMoving(home.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                //System.out.println(index);
                if (Main.selectedRole.equalsIgnoreCase("Administrator")) {
                    if (index == 0) {
                        setForm(form0);
                    } else if (index == 1) {
                        setForm(form1);
                    } else if (index == 2) {
                        setForm(form2);
                    } else if (index == 3) {
                        setForm(form3);
                    } else if (index == 4) {

                    } else if (index == 5) {

                    } else if (index == 6) {

                    } else if (index == 11) {
                        dispose();
                        new logIn().show();
                    }

                } else if (Main.selectedRole.equalsIgnoreCase("Employee")) {
                    if (index == 0) {
                        setForm(form0);
                    } else if (index == 1) {
                        setForm(form2);
                    } else if (index == 2) {
                        setForm(form3);
                    } else if (index == 3) {

                    } else if (index == 4) {

                    } else if (index == 5) {

                    } else if (index == 6) {

                    } else if (index == 11) {
                        dispose();
                        new logIn().show();
                    }

                }

            }
        });
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    public home(String Role) {
        initComponents();

        nameLbl.setText(Main.fname + " " + Main.mname + " " +Main.lname);
        roleLbl.setText(Main.selectedRole);

        setBackground(new Color(0, 0, 0, 0));
        form0 = new Form0();
        form1 = new Form1();
        form2 = new Form2();
        form3 = new Form3();
        form7 = new Form7();
        setForm(form0); // added to be in form 0 by default
        menu.initMoving(home.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                //System.out.println(index);
                if (Main.selectedRole.equalsIgnoreCase("Administrator")) {
                    if (index == 0) {
                        setForm(form0);
                    } else if (index == 1) {
                        setForm(form1);
                    } else if (index == 2) {
                        setForm(form2);
                    } else if (index == 3) {
                        setForm(form3);
                    } else if (index == 4) {

                    } else if (index == 5) {

                    } else if (index == 6) {

                    } else if (index == 7) {
                        setForm(form7);
                    } else if (index == 11) {
                        dispose();
                        new logIn().show();
                    }

                } else if (Main.selectedRole.equalsIgnoreCase("Employee")) {
                    if (index == 0) {
                        setForm(form0);
                    } else if (index == 1) {
                        setForm(form2);
                    } else if (index == 2) {
                        setForm(form3);
                    } else if (index == 3) {

                    } else if (index == 4) {

                    } else if (index == 5) {
                        setForm(form7);
                    } else if (index == 11) {
                        dispose();
                        new logIn().show();
                    }

                }

            }
        });

        // Create a rounded frame
        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        setShape(roundedRectangle);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new otherForms.PanelBorder();
        menu = new otherForms.Menu();
        jPanel1 = new javax.swing.JPanel();
        nameLbl = new javax.swing.JLabel();
        roleLbl = new javax.swing.JLabel();
        avatar1 = new components.ImageAvatar();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1250, 750));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        nameLbl.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        nameLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLbl.setText("User Name");

        roleLbl.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        roleLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        roleLbl.setText("Role");

        avatar1.setForeground(new java.awt.Color(40, 72, 102));
        avatar1.setBorderSize(1);
        avatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logInUser.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(1023, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roleLbl, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(avatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avatar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static components.ImageAvatar avatar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    private otherForms.Menu menu;
    public javax.swing.JLabel nameLbl;
    private otherForms.PanelBorder panelBorder1;
    public javax.swing.JLabel roleLbl;
    // End of variables declaration//GEN-END:variables
}
