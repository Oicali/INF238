/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import interfaces.EventMenuSelected;
import java.awt.Color;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import otherForms.*;
import popUps.changePassword;
import settings.GlassPanePopup;

/**
 *
 * @author jairus
 */
public class home extends javax.swing.JFrame {

    ImageIcon image = new ImageIcon(getClass().getResource("/resources/logoSmall.png"));
    private Form0 form0;
    private Form1 form1;
    private Form2 form2;
    private Form3 form3;
    public static Form6 form6;
    public static Form7 form7;
    public static int lastSelected;
    public static Notifications successChangePassword, successChangeImg;

    public home() {
        initComponents();
        GlassPanePopup.install(this);
        setIconImage(image.getImage());
        //JDialog.setDefaultLookAndFeelDecorated(true);

        nameLbl.setText(Main.fname + " " + Main.lname);
        roleLbl.setText(Main.selectedRole);
        lastSelected = 0;

        successChangePassword = new Notifications(this, Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Password Changed", "You have successfully changed your password");
        successChangeImg = new Notifications(this, Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Profile Image Changed", "New profile picture uploaded");

        //Set up forms
        setBackground(new Color(0, 0, 0, 0));
        form0 = new Form0();
        form1 = new Form1();
        form2 = new Form2();
        form3 = new Form3();
        form6 = new Form6();
        form7 = new Form7(Main.username);
        setForm(form0); // added to be in form 0 by default
        menu.initMoving(home.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                //System.out.println(index);
                if (Main.selectedRole.equalsIgnoreCase("Administrator")) {
                    if (index == 0) {
                        lastSelected = 0;
                        setForm(form0);
                    } else if (index == 1) {
                        lastSelected = 1;
                        setForm(form1);
                    } else if (index == 2) {
                        lastSelected = 2;
                        setForm(form2);
                    } else if (index == 3) {
                        lastSelected = 3;
                        setForm(form3);
                    } else if (index == 4) {
                        lastSelected = 4;
                    } else if (index == 5) {
                        lastSelected = 5;
                    } else if (index == 6) {
                        lastSelected = 6;
                        setForm(form6);
                    } else if (index == 7) {
                        lastSelected = 7;
                        setForm(form7);

                    } else if (index == 11) {
                        logout();
                    }

                } else if (Main.selectedRole.equalsIgnoreCase("Employee")) {
                    if (index == 0) {
                        lastSelected = 0;
                        setForm(form0);
                    } else if (index == 1) {
                        lastSelected = 1;
                        setForm(form2);
                    } else if (index == 2) {
                        lastSelected = 2;
                        setForm(form3);
                    } else if (index == 3) {
                        lastSelected = 3;

                    } else if (index == 4) {
                        lastSelected = 4;

                    } else if (index == 5) {
                        lastSelected = 5;
                        setForm(form7);
                    } else if (index == 11) {
                        logout();
                    }

                }

            }
        });

        // Create a rounded frame
        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        setShape(roundedRectangle);
    }

    // private void setForm
    // mainPanel is private only
    public static void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    //jPanel1 is private only
    public static void setHeader(JComponent com) {
        jPanel1.repaint();
        jPanel1.revalidate();
    }

    public home(String Role) {
        initComponents();
        GlassPanePopup.install(this);
        setIconImage(image.getImage());
        //JDialog.setDefaultLookAndFeelDecorated(true);

        nameLbl.setText(Main.fname + " " + Main.lname);
        roleLbl.setText(Main.selectedRole);
        lastSelected = 0;

        successChangePassword = new Notifications(this, Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Password Changed", "You have successfully changed your password");
        successChangeImg = new Notifications(this, Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Profile Image Changed", "Log in to see changes");

        //Set up forms
        setBackground(new Color(0, 0, 0, 0));
        form0 = new Form0();
        form1 = new Form1();
        form2 = new Form2();
        form3 = new Form3();
        form6 = new Form6();
        form7 = new Form7();
        setForm(form0); // added to be in form 0 by default
        menu.initMoving(home.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                //System.out.println(index);
                if (Main.selectedRole.equalsIgnoreCase("Administrator")) {
                    if (index == 0) {
                        lastSelected = 0;
                        setForm(form0);
                    } else if (index == 1) {
                        lastSelected = 1;
                        setForm(form1);
                    } else if (index == 2) {
                        lastSelected = 2;
                        setForm(form2);
                    } else if (index == 3) {
                        lastSelected = 3;
                        setForm(form3);
                    } else if (index == 4) {
                        lastSelected = 4;
                    } else if (index == 5) {
                        lastSelected = 5;
                    } else if (index == 6) {
                        lastSelected = 6;
                        setForm(form6);
                    } else if (index == 7) {
                        lastSelected = 7;
                        setForm(form7);

                    } else if (index == 11) {
                        logout();
                    }

                } else if (Main.selectedRole.equalsIgnoreCase("Employee")) {
                    if (index == 0) {
                        lastSelected = 0;
                        setForm(form0);
                    } else if (index == 1) {
                        lastSelected = 1;
                        setForm(form2);
                    } else if (index == 2) {
                        lastSelected = 2;
                        setForm(form3);
                    } else if (index == 3) {
                        lastSelected = 3;

                    } else if (index == 4) {
                        lastSelected = 4;

                    } else if (index == 5) {
                        lastSelected = 5;
                        setForm(form7);
                    } else if (index == 11) {
                        logout();
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
        jPanel1 = new javax.swing.JPanel();
        nameLbl = new javax.swing.JLabel();
        roleLbl = new javax.swing.JLabel();
        avatar1 = new components.ImageAvatar();
        mainPanel = new javax.swing.JPanel();
        menu = new otherForms.Menu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1250, 750));
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        nameLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        nameLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLbl.setText("User Name");

        roleLbl.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(20, 20, 20)
                .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
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
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    public void logout() {
        int choice = JOptionPane.showConfirmDialog(this, "Do you want to log out?", "Log Out", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            Main.username = "";
            Main.setStoredPassword("");
            Main.selectedRole = "";
            Main.fname = "";
            Main.mname = "";
            Main.lname = "";
            Main.sname = "";
            Main.fullname = "";
            Main.number = "";
            Main.email = "";
            Main.birth = "";
            Main.gender = "";
            Main.date = "";
            Main.status = "";
            Main.imageBytes = null;
            dispose();
            new logIn().show();;

        }
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
            java.util.logging.Logger.getLogger(home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel mainPanel;
    private otherForms.Menu menu;
    public javax.swing.JLabel nameLbl;
    private otherForms.PanelBorder panelBorder1;
    public javax.swing.JLabel roleLbl;
    // End of variables declaration//GEN-END:variables
}
