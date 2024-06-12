/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popUps;

import Pages.Form2;
import Main.Main;
import Main.home;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import otherForms.*;
import settings.CenteredCellRenderer;
import settings.GlassPanePopup;
import model.Model_User;
import settings.ModernCellRenderer;
import settings.ModernHeaderRenderer;

/**
 *
 * @author ASUS
 */
public class editCategories extends javax.swing.JPanel {

    private boolean isEditing = true;

    public editCategories() {
        initComponents();
        setOpaque(false);
        initData();
        initTable();
        updateBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        addBtn.setVisible(true);
        updateBtn.setVisible(false);
        deleteBtn.setVisible(false);
    }

    public void initTable() {
        categoryTable.setShowGrid(false);

        if (categoryTable.getRowCount() > 0) {
            categoryTable.setRowSelectionInterval(0, 0);
        }

        // Set custom cell renderer for all columns
        ModernCellRenderer cellRenderer = new ModernCellRenderer();
        for (int i = 1; i < categoryTable.getColumnCount(); i++) { // Skip the first column for now
            TableColumn column = categoryTable.getColumnModel().getColumn(i);
            column.setCellRenderer(cellRenderer);
        }

        // Set custom cell renderer for the first column to center text and alternate row colors
        CenteredCellRenderer centeredRenderer = new CenteredCellRenderer();
        TableColumn firstColumn = categoryTable.getColumnModel().getColumn(0);
        firstColumn.setCellRenderer(centeredRenderer);

        // Set the preferred width of the first column to fit the content
        int width = getColumnWidth(categoryTable, 0);
        firstColumn.setPreferredWidth(width + 10);
        firstColumn.setMaxWidth(width + 10);
        firstColumn.setMinWidth(width + 10);

        // Set custom header renderer
        JTableHeader header = categoryTable.getTableHeader();
        header.setDefaultRenderer(new ModernHeaderRenderer()); // Use the centered header renderer for the whole table
        header.setPreferredSize(new Dimension(0, 40));
        header.setReorderingAllowed(false);

        categoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        categoryTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = categoryTable.getSelectedRow();
                    if (selectedRow != -1 && !addBtn.isVisible()) {
                        String label = categoryTable.getValueAt(selectedRow, 1).toString();
                        String ID = categoryTable.getValueAt(selectedRow, 0).toString();

                        IDField.setText(ID);
                        labelField.setText(label);
                    }
                }
            }
        });

    }

    public void initData() {
        DefaultTableModel model = (DefaultTableModel) categoryTable.getModel();

        try {
            Statement s = Main.getDbCon().createStatement();

            ResultSet rs = s.executeQuery("select * from category");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("category_ID"), rs.getString("label")});
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

    // Method to calculate the preferred width of a column based on its content
    private static int getColumnWidth(JTable table, int columnIndex) {
        int width = 0; // Min width
        TableColumn column = table.getColumnModel().getColumn(columnIndex);
        Component comp;
        Font font = new Font("SansSerif", Font.PLAIN, 14);
        for (int row = 0; row < table.getRowCount(); row++) {
            comp = table.prepareRenderer(table.getCellRenderer(row, columnIndex), row, columnIndex);
            comp.setFont(font); // Ensure font is set for accurate width calculation
            width = Math.max(comp.getPreferredSize().width + 10, width); // Adding padding
        }
        return width;
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
        cmdCancel = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        labelField = new javax.swing.JTextField();
        jScrollPane1 = new components.ScrollPaneWin11();
        categoryTable = new javax.swing.JTable();
        IDField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ErrorMessage = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(723, 511));
        setMinimumSize(new java.awt.Dimension(723, 511));
        setPreferredSize(new java.awt.Dimension(723, 511));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edit Category");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 323, -1));

        cmdCancel.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        cmdCancel.setForeground(new java.awt.Color(153, 153, 153));
        cmdCancel.setText("X");
        cmdCancel.setBorderPainted(false);
        cmdCancel.setContentAreaFilled(false);
        cmdCancel.setFocusPainted(false);
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });
        add(cmdCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 3, -1, 40));

        addBtn.setBackground(new java.awt.Color(15, 106, 191));
        addBtn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.setBorderPainted(false);
        addBtn.setFocusPainted(false);
        addBtn.setPreferredSize(new java.awt.Dimension(29, 25));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 85, 31));

        editBtn.setBackground(new java.awt.Color(15, 106, 191));
        editBtn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("Edit");
        editBtn.setBorderPainted(false);
        editBtn.setFocusPainted(false);
        editBtn.setPreferredSize(new java.awt.Dimension(29, 25));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(599, 351, 84, 35));

        labelField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        labelField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(178, 178, 178)), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        labelField.setMaximumSize(new java.awt.Dimension(16, 27));
        labelField.setSelectionColor(new java.awt.Color(204, 204, 204));
        labelField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelFieldMouseClicked(evt);
            }
        });
        labelField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelFieldActionPerformed(evt);
            }
        });
        add(labelField, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 298, 285, 35));

        jScrollPane1.setBackground(new java.awt.Color(40, 72, 102));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        categoryTable.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        categoryTable.setRowHeight(30);
        jScrollPane1.setViewportView(categoryTable);
        if (categoryTable.getColumnModel().getColumnCount() > 0) {
            categoryTable.getColumnModel().getColumn(0).setResizable(false);
            categoryTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 121, 342, 350));

        IDField.setEditable(false);
        IDField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        IDField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(178, 178, 178)), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        IDField.setMaximumSize(new java.awt.Dimension(16, 27));
        IDField.setSelectionColor(new java.awt.Color(204, 204, 204));
        IDField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IDFieldMouseClicked(evt);
            }
        });
        IDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDFieldActionPerformed(evt);
            }
        });
        add(IDField, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 193, 285, 35));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Category ID:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, -1, 35));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Category Label:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 256, 206, 36));

        ErrorMessage.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ErrorMessage.setForeground(new java.awt.Color(255, 51, 51));
        ErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorMessage.setText("      ");
        ErrorMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(ErrorMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 413, 285, 26));

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 51, 51));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("*");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, -1));

        updateBtn.setBackground(new java.awt.Color(15, 106, 191));
        updateBtn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Update");
        updateBtn.setBorderPainted(false);
        updateBtn.setFocusPainted(false);
        updateBtn.setPreferredSize(new java.awt.Dimension(29, 25));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 351, 85, 35));

        deleteBtn.setBackground(new java.awt.Color(15, 106, 191));
        deleteBtn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete");
        deleteBtn.setBorderPainted(false);
        deleteBtn.setFocusPainted(false);
        deleteBtn.setPreferredSize(new java.awt.Dimension(29, 25));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 84, 35));
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Changes you made will not be save.\nClick Yes to close.", "Close Task", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            GlassPanePopup.closePopupLast();
        }
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        ErrorMessage.setText(" ");
        String categorylabel = labelField.getText().trim();

        if (categorylabel.isEmpty()) {
            ErrorMessage.setText("Please complete all required fields with *");

        } else if (categorylabel.length() > 24) {
            ErrorMessage.setText("Category label too long!");
        } else {
            try {
                Connection con = Main.getDbCon();

                String checkUserQuery = "SELECT COUNT(*) FROM category WHERE label = ?";
                PreparedStatement ps = con.prepareStatement(checkUserQuery);
                ps.setString(1, categorylabel);
                ResultSet rs = ps.executeQuery();
                rs.next();
                int userCount = rs.getInt(1);

                if (userCount > 0) {
                    ErrorMessage.setText("Category label already exist!");

                } else {

                    String insertCategory = "INSERT INTO category (label) values (?)";
                    ps = con.prepareStatement(insertCategory);
                    ps.setString(1, categorylabel);
                    ps.executeUpdate();

                    home.form2Products = new Form2();
                    home.setForm(home.form2Products);

                    GlassPanePopup.closePopupLast();
                    home.successNewCategory.showNotification();

                }

                ps.close();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace(); // Print the exception details for debugging
                JOptionPane.showMessageDialog(null, "An error occurred in database. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                Main.closeCon();
            }
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        ErrorMessage.setText(" ");

        if (isEditing) {
            int row = categoryTable.getSelectedRow();

            if (row == -1) {
                ErrorMessage.setText("Please select a row to edit!");
            } else {
                String label = categoryTable.getValueAt(row, 1).toString();
                String ID = categoryTable.getValueAt(row, 0).toString();

                IDField.setText(ID);
                labelField.setText(label);

                addBtn.setVisible(false);
                updateBtn.setVisible(true);
                deleteBtn.setVisible(true);

                editBtn.setText("Cancel");
                isEditing = false;

            }

        } else {
            editBtn.setText("Edit");
            isEditing = true;
            labelField.setText("");
            IDField.setText("");
//
//            addBtn.setEnabled(true);
//            updateBtn.setEnabled(false);
//            deleteBtn.setEnabled(false);

            addBtn.setVisible(true);
            updateBtn.setVisible(false);
            deleteBtn.setVisible(false);
        }


    }//GEN-LAST:event_editBtnActionPerformed

    private void labelFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFieldMouseClicked
        ErrorMessage.setText(" ");
    }//GEN-LAST:event_labelFieldMouseClicked

    private void labelFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelFieldActionPerformed
        ErrorMessage.setText(" ");

    }//GEN-LAST:event_labelFieldActionPerformed

    private void IDFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IDFieldMouseClicked
        ErrorMessage.setText(" ");
    }//GEN-LAST:event_IDFieldMouseClicked

    private void IDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDFieldActionPerformed

    }//GEN-LAST:event_IDFieldActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        ErrorMessage.setText(" ");
        int row = categoryTable.getSelectedRow();
        String data = labelField.getText().trim();
        if (row == -1) {
            ErrorMessage.setText("You did not select a row to update!");

        } else if (data.length() > 24) {
            ErrorMessage.setText("Category label too long!");
        } else {
            try {

                Connection con = Main.getDbCon();

                PreparedStatement ps = con.prepareStatement("UPDATE category SET label = ? where label = ?");
                ps.setString(1, data);
                ps.setString(2, (String) categoryTable.getValueAt(row, 1));
                ps.executeUpdate();

//                categoryTable.setValueAt(data, row, 1);
                ErrorMessage.setText(" ");

                home.form2Products = new Form2();
                home.setForm(home.form2Products);
                GlassPanePopup.closePopupLast();
                home.successUpdateCategory.showNotification();

                // Close the ResultSet
                ps.close();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace(); // Print the exception details for debugging
                JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                Main.closeCon();
            }
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        ErrorMessage.setText(" ");
        int row = categoryTable.getSelectedRow();
        if (row == -1) {
            ErrorMessage.setText("You did not select a row to delete!");

        } else {

            int choice = JOptionPane.showConfirmDialog(this, "Are you sure to delete this data?", "Delete Data", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                String password = JOptionPane.showInputDialog(this, "Enter your password:", "");
                if (password != null && password.equals(Main.getStoredPassword())) {

                    try {
                        Connection con = Main.getDbCon();
                        PreparedStatement ps = con.prepareStatement("DELETE FROM category WHERE label = '" + categoryTable.getValueAt(row, 1) + "'");

                        // Execute the DELETE statement
                        int rowsDeleted = ps.executeUpdate();

                        // Check if any rows were deleted
                        if (rowsDeleted > 0) {
                            home.form2Products = new Form2();
                            home.setForm(home.form2Products);
                            GlassPanePopup.closePopupLast();
                            home.successDeleteCategory.showNotification();

                        } else {
                            System.out.println("No rows were deleted.");
                        }

                        // Close the ResultSet
                        ps.close();
                        con.close();

                    } catch (SQLException e) {
                        e.printStackTrace(); // Print the exception details for debugging
                        JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        Main.closeCon();
                    }

                }
            }

        }
    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrorMessage;
    private javax.swing.JTextField IDField;
    private javax.swing.JButton addBtn;
    private javax.swing.JTable categoryTable;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField labelField;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
