/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Pages.Form7;
import Pages.Form6;
import Pages.Form5;
import Pages.Form4;
import Pages.Form3;
import Pages.Form2;
import Pages.Form0;
import components.ScrollBarWin11UI;
import interfaces.EventMenuSelected;
import java.awt.Color;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import otherForms.*;
import popUps.changePassword;
import settings.GlassPanePopup;


public class home extends javax.swing.JFrame {
    

    ImageIcon image = new ImageIcon(getClass().getResource("/resources/logoSmall.png"));
    private Form0 form0DashBoard;
    public static Form2 form2Products;
    private Form3 form3Order;
    public static Form4 form4ViewOrder;
    public static Form5 form5Customers;
    public static Form6 form6Users;
    public static Form7 form7Profile;

    public static int lastSelected;
    public static Notifications successChangePassword, successChangeImg, successPrintDocument, successAddUser, successUpdateUser,
            successDeleteUser, successNewCategory, successUpdateCategory, successDeleteCategory, successUpdateItem, successAddItem;
    public static Notifications itemWarning;

    public home() {
        initComponents();
        GlassPanePopup.install(this);
        setIconImage(image.getImage());
        setHeader(jPanel1, Main.username);
        //JDialog.setDefaultLookAndFeelDecorated(true);
        //nameLbl.setText(Main.fname + " " + Main.lname);
        //roleLbl.setText(Main.selectedRole);
        lastSelected = 0;

        successChangePassword = new Notifications(this, Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Password Changed", "You have successfully changed your password");
        successChangeImg = new Notifications(this, Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Profile Image Changed", "New profile picture uploaded");
        successPrintDocument = new Notifications(this, Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "CSV File Created", "Check you downloads folder");
        successAddUser = new Notifications(this, Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Added New User", "You have successfully added a new user");
        successUpdateUser = new Notifications(this, Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Updated User Information", "You have successfully updated user information");
        successDeleteUser = new Notifications(this, Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "User Account Deleted", "You have successfully deleted a user account");
        successNewCategory = new Notifications(this, Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Added New Category", "You have successfully added an item category");
        successUpdateCategory = new Notifications(this, Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Updated Item Category", "You have successfully updated item category");
        successDeleteCategory = new Notifications(this, Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Item Category Deleted", "You have successfully deleted an item category");
        successUpdateItem = new Notifications(this, Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Updated Products Data", "You have successfully updated products data");
        itemWarning = new Notifications(this,Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Item Stocks Warning", "An item is running low or out of stock"); 
        successAddItem = new Notifications(this, Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Added New Item", "You have successfully added a new item");
        
        //Set up forms
        setBackground(new Color(0, 0, 0, 0));
        form0DashBoard = new Form0();
        form2Products = new Form2();
        form3Order = new Form3();
        form4ViewOrder = new Form4();
        form5Customers = new Form5();
        form6Users = new Form6();
        form7Profile = new Form7(Main.username);
        setForm(form0DashBoard); // added to be in form 0 by default
        menu.initMoving(home.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                //System.out.println(index);
                if (Main.userPosition.equalsIgnoreCase("Administrator")) {
                    if (index == 0) {
                        lastSelected = 0;
                        setForm(form0DashBoard);
                    } else if (index == 1) {
                        lastSelected = 1;
                        setForm(form2Products);
                    } else if (index == 2) {
                        lastSelected = 2;
                        setForm(form3Order);
                    } else if (index == 3) {
                        lastSelected = 3;
                        setForm(form4ViewOrder);
                    } else if (index == 4) {
                        lastSelected = 4;
                        setForm(form5Customers);
                    } else if (index == 5) {
                        lastSelected = 5;
                        setForm(form6Users);
                    } else if (index == 6) {
                        lastSelected = 6;
                        setForm(form7Profile);
                    } else if (index == 11) {
                        logout();
                    }

                } else if (Main.userPosition.equalsIgnoreCase("Supervisor")) {
                    if (index == 0) {
                        lastSelected = 0;
                        setForm(form0DashBoard);
                    } else if (index == 1) {
                        lastSelected = 1;
                        setForm(form2Products);
                    } else if (index == 2) {
                        lastSelected = 2;
                        setForm(form3Order);
                    } else if (index == 3) {
                        lastSelected = 3;
                        setForm(form4ViewOrder);
                    } else if (index == 4) {
                        lastSelected = 4;
                        setForm(form5Customers);
                    } else if (index == 5) {
                        lastSelected = 5;
                        setForm(form7Profile);
                    } else if (index == 11) {
                        logout();
                    }

                } else if (Main.userPosition.equalsIgnoreCase("Sales Associate")) {
                    if (index == 0) {
                        lastSelected = 0;
                        setForm(form0DashBoard);
                    } else if (index == 1) {
                        lastSelected = 1;
                        setForm(form3Order);
                    } else if (index == 2) {
                        lastSelected = 2;
                        setForm(form4ViewOrder);
                    } else if (index == 3) {
                        lastSelected = 3;
                        setForm(form5Customers);
                    } else if (index == 4) {
                        lastSelected = 4;
                        setForm(form7Profile);

                    } else if (index == 11) {
                        logout();
                    }
                } else if (Main.userPosition.equalsIgnoreCase("Warehouse Staff")) {
                    if (index == 0) {
                        lastSelected = 0;
                        setForm(form0DashBoard);
                    } else if (index == 1) {
                        lastSelected = 1;
                        setForm(form2Products);
                    } else if (index == 2) {
                        lastSelected = 2;
                        setForm(form4ViewOrder);
                    } else if (index == 3) {
                        lastSelected = 3;
                        setForm(form7Profile);
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
    public static void setHeader(JComponent com, String username) {
        try {
            Statement s = Main.getDbCon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM users WHERE userName = '" + username + "'");

            while (rs.next()) {
                nameLbl.setText(rs.getString("fname") + " " + rs.getString("lname"));
                roleLbl.setText(rs.getString("userRole"));
                avatar1.setIcon(new ImageIcon(rs.getBytes("img")));
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

        jPanel1.repaint();
        jPanel1.revalidate();
    }

    public void logout() {
        int choice = JOptionPane.showConfirmDialog(this, "Do you want to log out?", "Log Out", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            Main.username = "";
            Main.setStoredPassword("");
            Main.userPosition = "";
//            Main.fname = "";
//            Main.mname = "";
//            Main.lname = "";
//            Main.sname = "";
//            Main.fullname = "";
            //Main.number = "";
//            Main.email = "";
            //Main.birth = "";
            //Main.gender = "";
            //Main.date = "";
            Main.status = "";
            //Main.imageBytes = null;
            dispose();
            new logIn().show();;

        }
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new otherForms.PanelBorder();
        jPanel1 = new javax.swing.JPanel();
        nameLbl = new javax.swing.JLabel();
        roleLbl = new javax.swing.JLabel();
        avatar1 = new components.CircleImageAvatar();
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

    public static void main(String args[]) {
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
        
        UIDefaults ui = UIManager.getDefaults();
        ui.put("ScrollBarUI", ScrollBarWin11UI.class.getCanonicalName());
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
    
    
    
    
    public home(String Role) {
        initComponents();
        GlassPanePopup.install(this);
        setIconImage(image.getImage());
        //JDialog.setDefaultLookAndFeelDecorated(true);

//        nameLbl.setText(Main.fname + " " + Main.lname);
        roleLbl.setText(Main.userPosition);
        lastSelected = 0;

        successChangePassword = new Notifications(this, Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Password Changed", "You have successfully changed your password");
        successChangeImg = new Notifications(this, Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Profile Image Changed", "Log in to see changes");

        //Set up forms
        setBackground(new Color(0, 0, 0, 0));
        form0DashBoard = new Form0();
        //form1Categories = new Form1();
        form2Products = new Form2();
        form3Order = new Form3();
        form6Users = new Form6();
        form7Profile = new Form7();
        setForm(form0DashBoard); // added to be in form 0 by default
        menu.initMoving(home.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                //System.out.println(index);
                if (Main.userPosition.equalsIgnoreCase("Administrator")) {
                    if (index == 0) {
                        lastSelected = 0;
                        setForm(form0DashBoard);
                    } else if (index == 1) {
                        lastSelected = 1;
                        //setForm(form1Categories);
                    } else if (index == 2) {
                        lastSelected = 2;
                        setForm(form2Products);
                    } else if (index == 3) {
                        lastSelected = 3;
                        setForm(form3Order);
                    } else if (index == 4) {
                        lastSelected = 4;
                    } else if (index == 5) {
                        lastSelected = 5;
                    } else if (index == 6) {
                        lastSelected = 6;
                        setForm(form6Users);
                    } else if (index == 7) {
                        lastSelected = 7;
                        setForm(form7Profile);

                    } else if (index == 11) {
                        logout();
                    }

                } else if (Main.userPosition.equalsIgnoreCase("Employee")) {
                    if (index == 0) {
                        lastSelected = 0;
                        setForm(form0DashBoard);
                    } else if (index == 1) {
                        lastSelected = 1;
                        setForm(form2Products);
                    } else if (index == 2) {
                        lastSelected = 2;
                        setForm(form3Order);
                    } else if (index == 3) {
                        lastSelected = 3;

                    } else if (index == 4) {
                        lastSelected = 4;

                    } else if (index == 5) {
                        lastSelected = 5;
                        setForm(form7Profile);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static components.CircleImageAvatar avatar1;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel mainPanel;
    private otherForms.Menu menu;
    private static javax.swing.JLabel nameLbl;
    private otherForms.PanelBorder panelBorder1;
    private static javax.swing.JLabel roleLbl;
    // End of variables declaration//GEN-END:variables
}
