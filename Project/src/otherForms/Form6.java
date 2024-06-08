/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherForms;

import Main.Main;
import Main.home;
import popUps.*;
import components.ScrollBarCustom;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        scroll = new javax.swing.JScrollPane();
        panelItem2 = new components.PanelItem();
        jTextField1 = new javax.swing.JTextField();
        addBtn = new components.RoundedButtons();
        exportBtn = new components.RoundedButtons();

        setBackground(new java.awt.Color(255, 255, 255));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.setViewportView(panelItem2);

        jTextField1.setText("jTextField1");

        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.setBorderColor(new java.awt.Color(15, 106, 191));
        addBtn.setBorderPainted(false);
        addBtn.setColor(new java.awt.Color(15, 106, 191));
        addBtn.setColorClick(new java.awt.Color(15, 106, 191));
        addBtn.setColorOver(new java.awt.Color(15, 106, 191));
        addBtn.setFocusPainted(false);
        addBtn.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        exportBtn.setForeground(new java.awt.Color(255, 255, 255));
        exportBtn.setText("Export");
        exportBtn.setBorderColor(new java.awt.Color(15, 106, 191));
        exportBtn.setBorderPainted(false);
        exportBtn.setColor(new java.awt.Color(15, 106, 191));
        exportBtn.setColorClick(new java.awt.Color(15, 106, 191));
        exportBtn.setColorOver(new java.awt.Color(15, 106, 191));
        exportBtn.setFocusPainted(false);
        exportBtn.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        exportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 1071, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

    }//GEN-LAST:event_formComponentShown

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        placeholder obj23 = new placeholder();
        GlassPanePopup.showPopup(obj23);
        new addNewUser(null, true).show();
    }//GEN-LAST:event_addBtnActionPerformed

    private void exportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBtnActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Get a copy of users information?", "Export users", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            try {
                Statement s = Main.getDbCon().createStatement();

                ResultSet rs = s.executeQuery("select fname, mname, lname, Sname, userName, userRole, email, gender, mobileNumber, birthDate, entryDate, status from users");
                String filePath = "D:\\GitHub\\INF238\\Project\\src\\documents\\users.csv";
                try {
                    writeResultSetToCSV(rs, filePath);
                } catch (IOException ex) {
                    Logger.getLogger(Form6.class.getName()).log(Level.SEVERE, null, ex);
                }

                rs.close();
                s.close();

                home.successPrintUsers.showNotification();

            } catch (SQLException e) {
                e.printStackTrace(); // Print the exception details for debugging
                JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                Main.closeCon();
            }

        }


    }//GEN-LAST:event_exportBtnActionPerformed

    public void addUser(Model_User data) {
        Card card = new Card();
        card.setData(data);
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    placeholder obj22 = new placeholder();
                    GlassPanePopup.showPopup(obj22);

                    new updateUser(null, true, data.getUserName()).show();
                }
            }
        });
        panelItem2.add(card);
        panelItem2.repaint();
        panelItem2.revalidate();
    }

    public void initData() {
        try {
            Statement s = Main.getDbCon().createStatement();

            ResultSet rs = s.executeQuery("select * from users");

            while (rs.next()) {
                addUser(new Model_User(rs.getString("users_pk"), rs.getString("fname"), rs.getString("lname"), rs.getString("userRole"), rs.getString("userName"), new ImageIcon(rs.getBytes("img")), rs.getString("status")));
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

    private static void writeResultSetToCSV(ResultSet resultSet, String filePath) throws SQLException, IOException {
        FileWriter fileWriter = new FileWriter(filePath);

        // Write CSV header
        int columnCount = resultSet.getMetaData().getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            fileWriter.append(resultSet.getMetaData().getColumnName(i));
            if (i < columnCount) {
                fileWriter.append(",");
            }
        }
        fileWriter.append("\n");

        // Write CSV rows
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                fileWriter.append(resultSet.getString(i));
                if (i < columnCount) {
                    fileWriter.append(",");
                }
            }
            fileWriter.append("\n");
        }

        fileWriter.flush();
        fileWriter.close();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.RoundedButtons addBtn;
    private components.RoundedButtons exportBtn;
    private javax.swing.JTextField jTextField1;
    private components.PanelItem panelItem2;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JButton uploadBtn;
    // End of variables declaration//GEN-END:variables
}
