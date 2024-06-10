/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popUps;

import Main.Main;
import Main.home;
import java.awt.Component;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import settings.CenteredCellRenderer;
import settings.GlassPanePopup;
import settings.Model_User;
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
        deleteBtn.setEnabled(false);
        updateBtn.setEnabled(false);
    }

    public void initTable() {
        categoryTable.setShowGrid(false);

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
        firstColumn.setPreferredWidth(width + 8);
        firstColumn.setMaxWidth(width + 8);
        firstColumn.setMinWidth(width + 8);

        // Set custom header renderer
        JTableHeader header = categoryTable.getTableHeader();
        header.setDefaultRenderer(new ModernHeaderRenderer()); // Use the centered header renderer for the whole table
        header.setPreferredSize(new Dimension(0, 40));
        header.setReorderingAllowed(false);

    }

    public void initData() {
        DefaultTableModel model = (DefaultTableModel) categoryTable.getModel();

        try {
            Statement s = Main.getDbCon().createStatement();

            ResultSet rs = s.executeQuery("select * from category");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("category_ID"), rs.getString("name")});
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
        nameField = new javax.swing.JTextField();
        jScrollPane1 = new components.ScrollPaneWin11();
        categoryTable = new javax.swing.JTable();
        nameField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ErrorMessage = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edit Category");

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

        nameField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        nameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(178, 178, 178)), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        nameField.setSelectionColor(new java.awt.Color(204, 204, 204));
        nameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameFieldMouseClicked(evt);
            }
        });
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        categoryTable.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        categoryTable.setRowHeight(30);
        jScrollPane1.setViewportView(categoryTable);
        if (categoryTable.getColumnModel().getColumnCount() > 0) {
            categoryTable.getColumnModel().getColumn(1).setResizable(false);
        }

        nameField1.setEditable(false);
        nameField1.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        nameField1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(178, 178, 178)), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        nameField1.setSelectionColor(new java.awt.Color(204, 204, 204));
        nameField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameField1MouseClicked(evt);
            }
        });
        nameField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameField1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Category ID:");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Category Name:");

        ErrorMessage.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ErrorMessage.setForeground(new java.awt.Color(255, 51, 51));
        ErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorMessage.setText("      ");
        ErrorMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 51, 51));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("*");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(108, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(ErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nameField)
                                .addComponent(nameField1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(ErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        ErrorMessage.setText(" ");
        String categoryName = nameField.getText().trim();

        if (categoryName.isEmpty()) {
            ErrorMessage.setText("Please complete all required fields with *");

        } else {
            try {
                Connection con = Main.getDbCon();

                String checkUserQuery = "SELECT COUNT(*) FROM category WHERE name = ?";
                PreparedStatement ps = con.prepareStatement(checkUserQuery);
                ps.setString(1, categoryName);
                ResultSet rs = ps.executeQuery();
                rs.next();
                int userCount = rs.getInt(1);

                if (userCount > 0) {
                    ErrorMessage.setText("Category name already exist!");

                } else {
                    

                    String insertCategory = "INSERT INTO category (name) values (?)";
                    ps = con.prepareStatement(insertCategory);
                    ps.setString(1, categoryName);
                    ps.executeUpdate();

//                    Statement s = Main.getDbCon().createStatement();
//                    ResultSet rs2 = s.executeQuery("SELECT category_ID FROM category WHERE name = '" + categoryName + "'");
//
//                    String ID = "";
//                    while (rs2.next()) {
//                        ID = rs2.getString("category_ID");
//                    }
//                    String data1 = ID;
//                    String data2 = categoryName;
//                    Object[] row = {data1, data2};
//                    DefaultTableModel model = (DefaultTableModel) categoryTable.getModel();
//                    model.addRow(row);
//
//                    s.close();
                }

                GlassPanePopup.closePopupLast();
                home.successNewCategory.showNotification();

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
        String categoryName = nameField.getText().trim();

        if (categoryName.isEmpty()) {
            ErrorMessage.setText("Please complete all required fields with *");

        } else {
            if (isEditing) {
                int row = categoryTable.getSelectedRow();

                if (row == -1) {
                    ErrorMessage.setText("You did not select a row to edit!");
                } else {
                    String Name = categoryTable.getValueAt(row, 1).toString();

                    nameField.setText(Name);

                    addBtn.setEnabled(false);
                    updateBtn.setEnabled(true);
                    deleteBtn.setEnabled(true);
                    editBtn.setText("Cancel");
                    isEditing = false;

                }

            } else {
                editBtn.setText("Edit");
                isEditing = true;
                nameField.setText("");

                addBtn.setEnabled(true);
                updateBtn.setEnabled(false);
                deleteBtn.setEnabled(false);
            }

        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void nameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameFieldMouseClicked

    }//GEN-LAST:event_nameFieldMouseClicked

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        ErrorMessage.setText(" ");

    }//GEN-LAST:event_nameFieldActionPerformed

    private void nameField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameField1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_nameField1MouseClicked

    private void nameField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameField1ActionPerformed
        ErrorMessage.setText(" ");
    }//GEN-LAST:event_nameField1ActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        ErrorMessage.setText(" ");
        int row = categoryTable.getSelectedRow();
        if (row == -1) {
            ErrorMessage.setText("You did not select a row to delete!");

        } else {
            try {
                String data = nameField.getText().trim();

                Connection con = Main.getDbCon();

                PreparedStatement ps = con.prepareStatement("UPDATE category SET name = ?");
                ps.setString(1, data);
                ps.executeUpdate();

//                categoryTable.setValueAt(data, row, 1);
                ErrorMessage.setText(" ");

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
                        PreparedStatement ps = con.prepareStatement("DELETE FROM category WHERE name = '" + categoryTable.getValueAt(row, 1) + "'");

                        // Execute the DELETE statement
                        int rowsDeleted = ps.executeUpdate();

                        // Check if any rows were deleted
                        if (rowsDeleted > 0) {
                            System.out.println("Row deleted successfully.");
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
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField nameField1;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
