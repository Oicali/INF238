/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Pages;

import Main.Main;
import Main.home;
import interfaces.EventCallBack;
import interfaces.EventTextField;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;
import popUps.placeholder;
import settings.GlassPanePopup;
import settings.LeftCellRenderer;
import settings.LeftCellRenderer2;
import settings.ModernCellRenderer;
import settings.ModernHeaderRenderer;

/**
 *
 * @author jairus
 */
public class Transactions extends javax.swing.JPanel {

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM-dd-yyyy HH:mm");

    public Transactions() {
        initComponents();
        setOpaque(false);
        completeBtn.setVisible(false);
         completeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        initTable();
        initData();

        initTable2();

        searchField.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                try {
                    for (int i = 1; i <= 100; i++) {
                        Thread.sleep(10);
                    }
                    call.done();
                    searchData();

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

        repaint();
        revalidate();

    }

    public void initTable() {
        deliveryTable.setShowGrid(false);

        if (deliveryTable.getRowCount() > 0) {
            deliveryTable.setRowSelectionInterval(0, 0);
        }

        LeftCellRenderer LeftRenderer = new LeftCellRenderer();
        ModernCellRenderer modernRenderer = new ModernCellRenderer();
        ModernHeaderRenderer headerRenderer = new ModernHeaderRenderer();

        deliveryTable.getColumnModel().getColumn(0).setCellRenderer(LeftRenderer); // First column
        for (int i = 1; i < deliveryTable.getColumnCount(); i++) {
            deliveryTable.getColumnModel().getColumn(i).setCellRenderer(modernRenderer); // Other columns
        }
        deliveryTable.getTableHeader().setDefaultRenderer(headerRenderer); // Header

        deliveryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        deliveryTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int row = deliveryTable.getSelectedRow();
                    if (row != -1) {
                        DefaultTableModel model = (DefaultTableModel) detailsTable.getModel();
                        model.setRowCount(0);

                        viewOrders(deliveryTable.getValueAt(row, 0).toString());
                    }
                }
            }
        });
    }

    public void initTable2() {
        detailsTable.setShowGrid(false);

        if (detailsTable.getRowCount() > 0) {
            detailsTable.setRowSelectionInterval(0, 0);
        }

        LeftCellRenderer2 LeftRenderer2 = new LeftCellRenderer2();
        ModernCellRenderer modernRenderer = new ModernCellRenderer();
        ModernHeaderRenderer headerRenderer = new ModernHeaderRenderer();

        detailsTable.getColumnModel().getColumn(0).setCellRenderer(LeftRenderer2); // First column
        for (int i = 1; i < detailsTable.getColumnCount(); i++) {
            detailsTable.getColumnModel().getColumn(i).setCellRenderer(modernRenderer); // Other columns
        }
        detailsTable.getTableHeader().setDefaultRenderer(headerRenderer); // Header

        detailsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public void initData() {
        DefaultTableModel model = (DefaultTableModel) deliveryTable.getModel();
        DefaultTableModel model2 = (DefaultTableModel) detailsTable.getModel();

        model.setRowCount(0);
        model2.setRowCount(0);

        try {
            Statement s = Main.getDbCon().createStatement();

            // Adjust the query to fetch all required columns, selecting the minimum orders_pk for each unique code
            String query = "SELECT t1.orders_pk, t1.code, t1.name, t1.cost,  t1.payment_Method, t1.location , t1.date_Ordered, t1.date_Delivered, t1.delivery_status FROM orders t1\n"
                    + "INNER JOIN ( SELECT MAX(orders_pk) AS orders_pk FROM orders where delivery_status = 'PENDING' GROUP BY code ) t2 ON t1.orders_pk = t2.orders_pk ORDER BY t1.orders_pk DESC;";

            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("code"),
                    rs.getString("name"),
                    rs.getString("date_Ordered"),
                    rs.getString("date_Delivered"),
                    rs.getString("delivery_status")
                });
            }
            
            query = "SELECT t1.orders_pk, t1.code, t1.name, t1.cost,  t1.payment_Method, t1.location , t1.date_Ordered, t1.date_Delivered, t1.delivery_status FROM orders t1\n"
                    + "INNER JOIN ( SELECT MAX(orders_pk) AS orders_pk FROM orders where delivery_status = 'DELIVERED' GROUP BY code ) t2 ON t1.orders_pk = t2.orders_pk ORDER BY t1.orders_pk DESC;";
            
            rs = s.executeQuery(query);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("code"),
                    rs.getString("name"),
                    rs.getString("date_Ordered"),
                    rs.getString("date_Delivered"),
                    rs.getString("delivery_status")
                });
            }
            
            
            rs.close();
            s.close();

        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception details for debugging
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            Main.closeCon();
        }
    }

    public void searchData() {
        deliveryTable.clearSelection();

        DefaultTableModel model = (DefaultTableModel) detailsTable.getModel();
        model.setRowCount(0);

        locationArea.setText("");
        mop.setText("");
        cost.setText("");

        DefaultTableModel variableTable = (DefaultTableModel) deliveryTable.getModel();
        TableRowSorter<DefaultTableModel> Sorter = new TableRowSorter<>(variableTable);
        deliveryTable.setRowSorter(Sorter);
        Sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(searchField.getText().trim())));

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLabel();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLabel();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLabel();
            }

            private void updateLabel() {
                if (searchField.getText().trim().isEmpty()) {
                    deliveryTable.setRowSorter(null);
                    DefaultTableModel model = (DefaultTableModel) detailsTable.getModel();
                    model.setRowCount(0);

                    locationArea.setText("");
                    mop.setText("");
                    cost.setText("");
                }
            }
        });
    }

    public void viewOrders(String data) {
        DefaultTableModel model = (DefaultTableModel) detailsTable.getModel();
        completeBtn.setVisible(false);

        try {
            Statement s = Main.getDbCon().createStatement();

            // Adjust the query to fetch all required columns, selecting the minimum orders_pk for each unique code
            String query = "Select * from orders where code = '" + data + "'";

            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("item_ordered"),
                    rs.getString("quantity"),
                    rs.getString("cost"),});

                locationArea.setText(rs.getString("location"));
                mop.setText(rs.getString("payment_Method"));
                cost.setText(rs.getString("total_Price"));

                if (rs.getString("delivery_status").equals("PENDING") && Main.userPosition.equals("Delivery Staff")) {
                    completeBtn.setVisible(true);
                }
            }
            
            

            rs.close();
            s.close();

        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception details for debugging
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            Main.closeCon();
        }

    }

    public void completeOrder() {
        int row = deliveryTable.getSelectedRow();

        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        try {

            Connection con = Main.getDbCon();

            PreparedStatement ps = con.prepareStatement("UPDATE orders SET delivery_status = ?, date_Delivered = ? where code = ?");
            ps.setString(1, "DELIVERED");
            ps.setString(2, date);
            ps.setString(3, deliveryTable.getValueAt(row, 0).toString());
            ps.executeUpdate();

            completeBtn.setVisible(true);

            home.form4ViewOrder = new Transactions();
            home.setForm(home.form4ViewOrder);
            home.form0DashBoard = new Dashboard();

            home.successUpdateHistory.showNotification();

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        searchField = new components.SearchFieldAnimation();
        jScrollPane1 = new components.ScrollPaneWin11();
        detailsTable = new javax.swing.JTable();
        jScrollPane3 = new components.ScrollPaneWin11();
        deliveryTable = new javax.swing.JTable();
        completeBtn = new components.RoundedButtons();
        cost = new javax.swing.JLabel();
        jScrollPane2 = new components.ScrollPaneWin11();
        locationArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mop = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Order History");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 440, 68));

        searchField.setBackground(new java.awt.Color(240, 240, 240));
        searchField.setAnimationColor(new java.awt.Color(15, 106, 191));
        searchField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        searchField.setHintText("Search a transaction");
        searchField.setSelectionColor(new java.awt.Color(204, 204, 204));
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 110, 363, -1));

        jScrollPane1.setBackground(new java.awt.Color(40, 72, 134));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        detailsTable.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        detailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item", "Qty", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        detailsTable.setRowHeight(24);
        jScrollPane1.setViewportView(detailsTable);
        if (detailsTable.getColumnModel().getColumnCount() > 0) {
            detailsTable.getColumnModel().getColumn(0).setResizable(false);
            detailsTable.getColumnModel().getColumn(1).setResizable(false);
            detailsTable.getColumnModel().getColumn(1).setPreferredWidth(7);
            detailsTable.getColumnModel().getColumn(2).setResizable(false);
            detailsTable.getColumnModel().getColumn(2).setPreferredWidth(25);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(803, 172, 300, 210));

        jScrollPane3.setBackground(new java.awt.Color(40, 72, 134));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        deliveryTable.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        deliveryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer", "Date ordered", "Date Delivered", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        deliveryTable.setRowHeight(30);
        jScrollPane3.setViewportView(deliveryTable);
        if (deliveryTable.getColumnModel().getColumnCount() > 0) {
            deliveryTable.getColumnModel().getColumn(0).setResizable(false);
            deliveryTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            deliveryTable.getColumnModel().getColumn(1).setResizable(false);
            deliveryTable.getColumnModel().getColumn(2).setResizable(false);
            deliveryTable.getColumnModel().getColumn(3).setResizable(false);
            deliveryTable.getColumnModel().getColumn(4).setResizable(false);
            deliveryTable.getColumnModel().getColumn(4).setPreferredWidth(25);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 172, 750, 580));

        completeBtn.setForeground(new java.awt.Color(255, 255, 255));
        completeBtn.setText("Order Complete");
        completeBtn.setBorderColor(new java.awt.Color(15, 106, 191));
        completeBtn.setBorderPainted(false);
        completeBtn.setColor(new java.awt.Color(15, 106, 191));
        completeBtn.setColorClick(new java.awt.Color(15, 106, 191));
        completeBtn.setColorOver(new java.awt.Color(15, 106, 191));
        completeBtn.setFocusPainted(false);
        completeBtn.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        completeBtn.setMaximumSize(new java.awt.Dimension(65, 38));
        completeBtn.setMinimumSize(new java.awt.Dimension(65, 38));
        completeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeBtnActionPerformed(evt);
            }
        });
        add(completeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, 180, 38));

        cost.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        cost.setForeground(new java.awt.Color(102, 102, 102));
        cost.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add(cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 430, 300, 40));

        locationArea.setEditable(false);
        locationArea.setColumns(20);
        locationArea.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        locationArea.setForeground(new java.awt.Color(102, 102, 102));
        locationArea.setLineWrap(true);
        locationArea.setRows(5);
        locationArea.setWrapStyleWord(true);
        locationArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        jScrollPane2.setViewportView(locationArea);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(803, 572, 300, 182));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Delivery Location:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 520, 240, 50));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Total Price:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 400, 160, 30));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Payment method:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 480, 160, 40));

        mop.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        mop.setForeground(new java.awt.Color(102, 102, 102));
        mop.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        add(mop, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 480, 130, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void completeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeBtnActionPerformed
        completeOrder();
    }//GEN-LAST:event_completeBtnActionPerformed

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.RoundedButtons completeBtn;
    private javax.swing.JLabel cost;
    private javax.swing.JTable deliveryTable;
    private javax.swing.JTable detailsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea locationArea;
    private javax.swing.JLabel mop;
    private components.SearchFieldAnimation searchField;
    // End of variables declaration//GEN-END:variables
}
