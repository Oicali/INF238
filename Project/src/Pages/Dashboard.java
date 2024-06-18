/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Pages;

import Main.Main;
import chart.ModelChart;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import settings.LeftCellRenderer2;
import settings.ModernCellRenderer;
import settings.ModernHeaderRenderer;

/**
 *
 * @author jairus
 */
public class Dashboard extends javax.swing.JPanel {

    /**
     * Creates new form Form0
     */
    public Dashboard() {
        initComponents();
        setOpaque(false);
        c1.setBackground(new Color(255, 255, 255, 20));
        c2.setBackground(new Color(255, 255, 255, 20));
        c7.setBackground(new Color(255, 255, 255, 20));
        c8.setBackground(new Color(255, 255, 255, 20));
        c5.setBackground(new Color(255, 255, 255, 20));
        c6.setBackground(new Color(255, 255, 255, 20));
        c3.setBackground(new Color(205, 205, 205, 50));
        c4.setBackground(new Color(205, 205, 205, 50));

        initCards();
        initTable();
        initData();

        chart.addLegend("Sales", new Color(15, 106, 191));
        chart.addData(new ModelChart("January", new double[]{0}));
        chart.addData(new ModelChart("February", new double[]{0}));
        chart.addData(new ModelChart("March", new double[]{0}));
        chart.addData(new ModelChart("April", new double[]{0}));
        chart.addData(new ModelChart("May", new double[]{0}));
        chart.addData(new ModelChart("June", new double[]{chartJune()}));
        chart.addData(new ModelChart("July", new double[]{0}));
        chart.addData(new ModelChart("August", new double[]{0}));
        chart.addData(new ModelChart("September", new double[]{0}));
        chart.addData(new ModelChart("October", new double[]{0}));
        chart.addData(new ModelChart("November", new double[]{0}));
        chart.addData(new ModelChart("December", new double[]{0}));
    }

    public void initCards() {
        try {
            Statement s = Main.getDbCon().createStatement();
            ResultSet rs = s.executeQuery("SELECT count(*) FROM products");

            if (rs.next()) {
                t1.setText(rs.getString("count(*)"));
            }

            rs = s.executeQuery("SELECT COUNT(*) AS total_count FROM (SELECT t1.orders_pk, t1.code, t1.name, t1.cost, t1.payment_Method, t1.location, t1.date_Ordered, t1.date_Delivered, t1.delivery_status\n"
                    + "FROM orders t1 INNER JOIN (SELECT MAX(orders_pk) AS orders_pk FROM orders GROUP BY code) t2 ON t1.orders_pk = t2.orders_pk ORDER BY t1.orders_pk DESC) AS subquery;");

            if (rs.next()) {
                t2.setText(rs.getString("total_count"));
            }

            rs = s.executeQuery("select count(*) from customers;");

            if (rs.next()) {
                t3.setText(rs.getString("count(*)"));
            }

            rs = s.executeQuery("select count(*) from users;");

            if (rs.next()) {
                t4.setText(rs.getString("count(*)"));
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

    public void initData() {
        try {
            Statement s = Main.getDbCon().createStatement();
            ResultSet rs = s.executeQuery("select * from products where quantity <= " + Main.lowerLimit + "");

            DefaultTableModel model = (DefaultTableModel) table1.getModel();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("item_Name"), rs.getString("quantity")});
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

    public void initTable() {
        table1.setShowGrid(false);

        if (table1.getRowCount() > 0) {
            table1.setRowSelectionInterval(0, 0);
        }

        LeftCellRenderer2 LeftRenderer2 = new LeftCellRenderer2();
        ModernCellRenderer modernRenderer = new ModernCellRenderer();
        ModernHeaderRenderer headerRenderer = new ModernHeaderRenderer();

        table1.getColumnModel().getColumn(0).setCellRenderer(LeftRenderer2); // First column
        for (int i = 1; i < table1.getColumnCount(); i++) {
            table1.getColumnModel().getColumn(i).setCellRenderer(modernRenderer); // Other columns
        }
        table1.getTableHeader().setDefaultRenderer(headerRenderer); // Header

        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public double chartJune() {
        double data = 0;

        try {
            Statement s = Main.getDbCon().createStatement();
            ResultSet rs = s.executeQuery("SELECT COUNT(*) AS total_count FROM (SELECT t1.orders_pk, t1.code, t1.name, t1.cost, t1.payment_Method, t1.location, t1.date_Ordered, t1.date_Delivered, t1.delivery_status\n"
                    + "FROM orders t1 INNER JOIN (SELECT MAX(orders_pk) AS orders_pk FROM orders where date_Ordered like '%June%' GROUP BY code) t2 ON t1.orders_pk = t2.orders_pk ORDER BY t1.orders_pk DESC) AS subquery;");

            while (rs.next()) {
                data = rs.getDouble("total_count");
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

        return data;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        datePicker1 = new calendar.DatePicker();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new components.ScrollPaneWin11();
        table1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        panelBorder1 = new otherForms.PanelBorder();
        jLabel6 = new javax.swing.JLabel();
        c1 = new otherForms.CircularPanel();
        c2 = new otherForms.CircularPanel();
        jLabel7 = new javax.swing.JLabel();
        t1 = new javax.swing.JLabel();
        panelBorder2 = new otherForms.PanelBorder();
        c3 = new otherForms.CircularPanel();
        c4 = new otherForms.CircularPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        t4 = new javax.swing.JLabel();
        panelBorder3 = new otherForms.PanelBorder();
        jLabel12 = new javax.swing.JLabel();
        c5 = new otherForms.CircularPanel();
        c6 = new otherForms.CircularPanel();
        jLabel13 = new javax.swing.JLabel();
        t2 = new javax.swing.JLabel();
        panelBorder4 = new otherForms.PanelBorder();
        c7 = new otherForms.CircularPanel();
        c8 = new otherForms.CircularPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        t3 = new javax.swing.JLabel();
        chart = new chart.Chart();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer", "Date Ordered", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1141, 794));
        setPreferredSize(new java.awt.Dimension(1141, 794));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datePicker1.setForeground(new java.awt.Color(15, 106, 191));
        add(datePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 530, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Annual Report:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 250, 50));

        jScrollPane2.setBackground(new java.awt.Color(40, 72, 134));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setRowHeight(25);
        jScrollPane2.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setResizable(false);
            table1.getColumnModel().getColumn(1).setResizable(false);
            table1.getColumnModel().getColumn(1).setPreferredWidth(15);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 290, 280, 220));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Items low in stocks:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 240, 250, 50));

        panelBorder1.setBackground(new java.awt.Color(40, 72, 134));
        panelBorder1.setPreferredSize(new java.awt.Dimension(280, 170));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/17.png"))); // NOI18N
        panelBorder1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        c1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout c1Layout = new javax.swing.GroupLayout(c1);
        c1.setLayout(c1Layout);
        c1Layout.setHorizontalGroup(
            c1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        c1Layout.setVerticalGroup(
            c1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelBorder1.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        c2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout c2Layout = new javax.swing.GroupLayout(c2);
        c2.setLayout(c2Layout);
        c2Layout.setHorizontalGroup(
            c2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        c2Layout.setVerticalGroup(
            c2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelBorder1.add(c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total Products");
        panelBorder1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        t1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        t1.setForeground(new java.awt.Color(255, 255, 255));
        t1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t1.setText("Total");
        panelBorder1.add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 90, -1));

        add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 50, 260, 150));

        panelBorder2.setBackground(new java.awt.Color(240, 240, 240));
        panelBorder2.setPreferredSize(new java.awt.Dimension(280, 170));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        c3.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout c3Layout = new javax.swing.GroupLayout(c3);
        c3.setLayout(c3Layout);
        c3Layout.setHorizontalGroup(
            c3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        c3Layout.setVerticalGroup(
            c3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelBorder2.add(c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        c4.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout c4Layout = new javax.swing.GroupLayout(c4);
        c4.setLayout(c4Layout);
        c4Layout.setHorizontalGroup(
            c4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        c4Layout.setVerticalGroup(
            c4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelBorder2.add(c4, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 50, -1, -1));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel10.setText("Total Users");
        panelBorder2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/20.png"))); // NOI18N
        panelBorder2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        t4.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        t4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t4.setText("Total");
        panelBorder2.add(t4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 90, -1));

        add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(853, 50, 260, 150));

        panelBorder3.setBackground(new java.awt.Color(15, 106, 191));
        panelBorder3.setPreferredSize(new java.awt.Dimension(280, 170));
        panelBorder3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/18.png"))); // NOI18N
        panelBorder3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        c5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout c5Layout = new javax.swing.GroupLayout(c5);
        c5.setLayout(c5Layout);
        c5Layout.setHorizontalGroup(
            c5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        c5Layout.setVerticalGroup(
            c5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelBorder3.add(c5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        c6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout c6Layout = new javax.swing.GroupLayout(c6);
        c6.setLayout(c6Layout);
        c6Layout.setHorizontalGroup(
            c6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        c6Layout.setVerticalGroup(
            c6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelBorder3.add(c6, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 50, -1, -1));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total Orders");
        panelBorder3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        t2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        t2.setForeground(new java.awt.Color(255, 255, 255));
        t2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t2.setText("Total");
        panelBorder3.add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 90, -1));

        add(panelBorder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 50, 260, 150));

        panelBorder4.setBackground(new java.awt.Color(24, 124, 197));
        panelBorder4.setPreferredSize(new java.awt.Dimension(280, 170));
        panelBorder4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        c7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout c7Layout = new javax.swing.GroupLayout(c7);
        c7.setLayout(c7Layout);
        c7Layout.setHorizontalGroup(
            c7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        c7Layout.setVerticalGroup(
            c7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelBorder4.add(c7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        c8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout c8Layout = new javax.swing.GroupLayout(c8);
        c8.setLayout(c8Layout);
        c8Layout.setHorizontalGroup(
            c8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        c8Layout.setVerticalGroup(
            c8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelBorder4.add(c8, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 50, -1, -1));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Total Customers");
        panelBorder4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/19.png"))); // NOI18N
        panelBorder4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        t3.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        t3.setForeground(new java.awt.Color(255, 255, 255));
        t3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t3.setText("Total");
        panelBorder4.add(t3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 90, -1));

        add(panelBorder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 50, 260, 150));
        add(chart, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 292, 760, 430));
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private otherForms.CircularPanel c1;
    private otherForms.CircularPanel c2;
    private otherForms.CircularPanel c3;
    private otherForms.CircularPanel c4;
    private otherForms.CircularPanel c5;
    private otherForms.CircularPanel c6;
    private otherForms.CircularPanel c7;
    private otherForms.CircularPanel c8;
    private chart.Chart chart;
    private calendar.DatePicker datePicker1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private otherForms.PanelBorder panelBorder1;
    private otherForms.PanelBorder panelBorder2;
    private otherForms.PanelBorder panelBorder3;
    private otherForms.PanelBorder panelBorder4;
    private javax.swing.JLabel t1;
    private javax.swing.JLabel t2;
    private javax.swing.JLabel t3;
    private javax.swing.JLabel t4;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
}
