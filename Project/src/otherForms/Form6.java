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
import interfaces.EventCallBack;
import interfaces.EventTextField;
import java.awt.Color;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import popUps.placeholder;
import settings.GlassPanePopup;
import settings.Model_User;

public class Form6 extends javax.swing.JPanel {

    public Form6() {
        initComponents();
        setOpaque(false);
        initData();

        searchField.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                try {
                    String data = searchField.getText();
                    for (int i = 1; i <= 100; i++) {
                        Thread.sleep(10);
                    }
                    call.done();
                    searchData(data);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread was interrupted: " + e);
                } catch (Exception e) {
                    System.err.println(e);
                }
            }

            @Override
            public void onCancel() {
                searchField.setText("");
            }
        });
        
        // Add a DocumentListener to the searchField
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkIfEmpty();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkIfEmpty();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkIfEmpty();
            }

            private void checkIfEmpty() {
                if (searchField.getText().trim().isEmpty()) {
                    initData();
                }
            }
        });
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
        addBtn = new components.RoundedButtons();
        exportBtn = new components.RoundedButtons();
        searchField = new components.TextFieldAnimation();
        jLabel1 = new javax.swing.JLabel();

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

        searchField.setBackground(new java.awt.Color(240, 240, 240));
        searchField.setAnimationColor(new java.awt.Color(15, 106, 191));
        searchField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        searchField.setHintText("Search a user...");
        searchField.setSelectionColor(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel1.setText("Users Information Page");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(exportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(scroll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1061, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
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
        panelItem2.removeAll();
        
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

    private void searchData(String data) {
        panelItem2.removeAll();

        try {
            Statement s = Main.getDbCon().createStatement();

            ResultSet rs = s.executeQuery("SELECT * FROM users WHERE fullname LIKE '%" + data + "%'");

            if (rs.isBeforeFirst()) { // Check if the ResultSet is not empty
                while (rs.next()) {
                    addUser(new Model_User(
                            rs.getString("users_pk"),
                            rs.getString("fname"),
                            rs.getString("lname"),
                            rs.getString("userRole"),
                            rs.getString("userName"),
                            new ImageIcon(rs.getBytes("img")),
                            rs.getString("status")
                    ));
                }
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
    private components.RoundedButtons addBtn;
    private components.RoundedButtons exportBtn;
    private javax.swing.JLabel jLabel1;
    private components.PanelItem panelItem2;
    private javax.swing.JScrollPane scroll;
    private components.TextFieldAnimation searchField;
    // End of variables declaration//GEN-END:variables
}
