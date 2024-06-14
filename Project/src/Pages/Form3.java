/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Pages;

import Main.Main;
import components.ScrollBarCustom;
import interfaces.EventCallBack;
import interfaces.EventTextField;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.text.NumberFormatter;
import model.Model_Products;
import otherForms.orderPanel;
import popUps.placeholder;
import popUps.viewCart;
import settings.CenteredCellRenderer;
import settings.GlassPanePopup;
import settings.LeftCellRenderer;
import settings.ModernCellRenderer;
import settings.ModernHeaderRenderer;

/**
 *
 * @author jairus
 */
public class Form3 extends javax.swing.JPanel {

    private Map<String, orderPanel> orderPanels;
    public static int itemMax = 0;
    public static double itemPrice = 0.0;
    private DecimalFormat decimal = new DecimalFormat("0.00");
    public static ArrayList<String> cartList = new ArrayList<>();
    public static ArrayList<Double> priceList = new ArrayList<>();
    public static boolean isEditing = false;

    public Form3() {
        initComponents();
        setOpaque(false);
        initTable();

        cartList.clear();
        priceList.clear();

        System.out.println("cart List: " + cartList);
        System.out.println("price List: " + priceList);

        orderPanels = new HashMap<>();
        clearBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cartBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deliveryBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        trashBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        trashBtn.setVisible(true);
        spinner2.setValue(1);

        initData();

        spinner2.addChangeListener(e -> {
            int value = (int) spinner2.getValue();

            if (value == 0) {
                spinner2.setValue(1);
                value = (int) spinner2.getValue();
            }

            if (value > itemMax) {
                spinner2.setValue(itemMax);
                value = (int) spinner2.getValue();
            }

            double newAmount = value * itemPrice;
            f3amountField.setText(String.valueOf(decimal.format(newAmount)));
        });

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

    public void initData() {
        try {
            panelItem2.removeAll();
            Statement s = Main.getDbCon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM category");

            while (rs.next()) {
                addPanelCategory(rs.getString("label"));
            }

            s = Main.getDbCon().createStatement();
            rs = s.executeQuery("select * from products inner join category on products.category_fk = category_ID;");

            while (rs.next()) {
                String itemName = rs.getString("item_Name");
                byte[] imageBytes = rs.getBytes("item_Image");
                Icon imageIcon = new ImageIcon(imageBytes);
                int stocks = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String category = rs.getString(8); // Assuming the 8th column is the category
                String ID = rs.getString("product_pk");

                Model_Products product = new Model_Products(itemName, imageIcon, stocks, price, ID, category);
                addItemToCategory(category, product);
            }

            panelItem2.repaint();
            panelItem2.revalidate();

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

    public void searchData() {
        try {
            panelItem2.removeAll();

            String data = searchField.getText().trim();
            Statement s = Main.getDbCon().createStatement();
            ResultSet rs = s.executeQuery("select * from products inner join category on products.category_fk = category_ID where item_Name like '%" + data + "%'");

            Set<String> processedLabels = new HashSet<>();

            while (rs.next()) {
                String label = rs.getString("label");
                if (!processedLabels.contains(label)) {
                    addPanelCategory(label);
                    processedLabels.add(label);
                }
            }

            s = Main.getDbCon().createStatement();
            rs = s.executeQuery("select * from products inner join category on products.category_fk = category_ID where item_Name like '%" + data + "%' OR category.label LIKE '%" + data + "%'");

            while (rs.next()) {
                String itemName = rs.getString("item_Name");
                byte[] imageBytes = rs.getBytes("item_Image");
                Icon imageIcon = new ImageIcon(imageBytes);
                int stocks = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String category = rs.getString(8); // Assuming the 8th column is the category
                String ID = rs.getString("product_pk");

                Model_Products product = new Model_Products(itemName, imageIcon, stocks, price, ID, category);
                addItemToCategory(category, product);
            }

            panelItem2.repaint();
            panelItem2.revalidate();
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

    public void addPanelCategory(String category) {
        orderPanel panel = new orderPanel(category);
        orderPanels.put(category, panel);
        panelItem2.add(panel);

        panelItem2.repaint();
        panelItem2.revalidate();
    }

    public void addItemToCategory(String category, Model_Products item) {
        orderPanel panel = orderPanels.get(category);
        if (panel == null) {
            addPanelCategory(category);
            panel = orderPanels.get(category);
        }
        panel.addOrderItem(item);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchField = new components.TextFieldAnimation();
        clearBtn = new components.RoundedButtons();
        deliveryBtn = new components.RoundedButtons();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelItem2 = new components.PanelItem();
        jScrollPane3 = new components.ScrollPaneWin11();
        orderTable = new javax.swing.JTable();
        panelBorder1 = new otherForms.PanelBorder();
        cartBtn = new components.RoundedButtons();
        jLabel7 = new javax.swing.JLabel();
        itemNameField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        spinner2 = new javax.swing.JSpinner();
        f3itemField = new javax.swing.JTextField();
        f3amountField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        trashBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1141, 749));
        setPreferredSize(new java.awt.Dimension(1141, 749));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchField.setBackground(new java.awt.Color(240, 240, 240));
        searchField.setAnimationColor(new java.awt.Color(15, 106, 191));
        searchField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        searchField.setHintText("Search an item");
        searchField.setSelectionColor(new java.awt.Color(204, 204, 204));
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 110, 363, -1));

        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("Clear Cart");
        clearBtn.setBorderColor(new java.awt.Color(15, 106, 191));
        clearBtn.setBorderPainted(false);
        clearBtn.setColor(new java.awt.Color(15, 106, 191));
        clearBtn.setColorClick(new java.awt.Color(15, 106, 191));
        clearBtn.setColorOver(new java.awt.Color(15, 106, 191));
        clearBtn.setFocusPainted(false);
        clearBtn.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        clearBtn.setMaximumSize(new java.awt.Dimension(65, 38));
        clearBtn.setMinimumSize(new java.awt.Dimension(65, 38));
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 110, 130, 38));

        deliveryBtn.setForeground(new java.awt.Color(255, 255, 255));
        deliveryBtn.setText("Set Delivery");
        deliveryBtn.setBorderColor(new java.awt.Color(15, 106, 191));
        deliveryBtn.setBorderPainted(false);
        deliveryBtn.setColor(new java.awt.Color(15, 106, 191));
        deliveryBtn.setColorClick(new java.awt.Color(15, 106, 191));
        deliveryBtn.setColorOver(new java.awt.Color(15, 106, 191));
        deliveryBtn.setFocusPainted(false);
        deliveryBtn.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        deliveryBtn.setMaximumSize(new java.awt.Dimension(65, 38));
        deliveryBtn.setMinimumSize(new java.awt.Dimension(65, 38));
        deliveryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryBtnActionPerformed(evt);
            }
        });
        add(deliveryBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 110, 139, 38));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane2.setViewportView(panelItem2);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 172, 660, 580));

        jScrollPane3.setBackground(new java.awt.Color(40, 72, 102));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        orderTable.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantity", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderTable.setRowHeight(30);
        orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(orderTable);
        if (orderTable.getColumnModel().getColumnCount() > 0) {
            orderTable.getColumnModel().getColumn(0).setResizable(false);
            orderTable.getColumnModel().getColumn(1).setResizable(false);
            orderTable.getColumnModel().getColumn(1).setPreferredWidth(10);
            orderTable.getColumnModel().getColumn(2).setResizable(false);
            orderTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 172, 400, 290));

        cartBtn.setForeground(new java.awt.Color(255, 255, 255));
        cartBtn.setText("Add to Cart");
        cartBtn.setBorderColor(new java.awt.Color(15, 106, 191));
        cartBtn.setBorderPainted(false);
        cartBtn.setColor(new java.awt.Color(15, 106, 191));
        cartBtn.setColorClick(new java.awt.Color(15, 106, 191));
        cartBtn.setColorOver(new java.awt.Color(15, 106, 191));
        cartBtn.setFocusPainted(false);
        cartBtn.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        cartBtn.setMaximumSize(new java.awt.Dimension(65, 38));
        cartBtn.setMinimumSize(new java.awt.Dimension(65, 38));
        cartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setText("Amount:");

        itemNameField.setEditable(false);
        itemNameField.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        itemNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemNameField.setText("Item Details");
        itemNameField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        itemNameField.setMaximumSize(new java.awt.Dimension(16, 27));
        itemNameField.setOpaque(false);
        itemNameField.setSelectionColor(new java.awt.Color(204, 204, 204));
        itemNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNameFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setText("Item Name:");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setText("Quantity:");

        spinner2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        spinner2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(178, 178, 178)));
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) spinner2.getEditor();
        editor.getTextField().setHorizontalAlignment(JTextField.CENTER);

        JFormattedTextField textField = ((JSpinner.DefaultEditor) spinner2.getEditor()).getTextField();
        textField.setFormatterFactory(createFormatterFactory());

        f3itemField.setEditable(false);
        f3itemField.setBackground(new java.awt.Color(255, 255, 255));
        f3itemField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        f3itemField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        f3itemField.setMaximumSize(new java.awt.Dimension(289, 35));
        f3itemField.setMinimumSize(new java.awt.Dimension(289, 35));
        f3itemField.setPreferredSize(new java.awt.Dimension(289, 35));
        f3itemField.setSelectionColor(new java.awt.Color(204, 204, 204));
        f3itemField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f3itemFieldActionPerformed(evt);
            }
        });

        f3amountField.setEditable(false);
        f3amountField.setBackground(new java.awt.Color(255, 255, 255));
        f3amountField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        f3amountField.setText("0.00");
        f3amountField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        f3amountField.setMaximumSize(new java.awt.Dimension(289, 35));
        f3amountField.setMinimumSize(new java.awt.Dimension(289, 35));
        f3amountField.setPreferredSize(new java.awt.Dimension(289, 35));
        f3amountField.setSelectionColor(new java.awt.Color(204, 204, 204));
        f3amountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f3amountFieldActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("PHP");

        trashBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/trash.png"))); // NOI18N
        trashBtn.setBorderPainted(false);
        trashBtn.setContentAreaFilled(false);
        trashBtn.setFocusPainted(false);
        trashBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trashBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(8, 8, 8)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(spinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(f3amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(trashBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(itemNameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(f3itemField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(itemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f3itemField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f3amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cartBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trashBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );

        add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, 400, 280));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Place Order");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 20, 336, 68));
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        model.setRowCount(0);
        cartList.clear();
        priceList.clear();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void deliveryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveryBtnActionPerformed
        viewCart obj24 = new viewCart();
        GlassPanePopup.showPopup(obj24);
    }//GEN-LAST:event_deliveryBtnActionPerformed

    private void f3itemFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f3itemFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_f3itemFieldActionPerformed

    private void itemNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemNameFieldActionPerformed

    private void f3amountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f3amountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_f3amountFieldActionPerformed

    private void cartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartBtnActionPerformed
        String itemData = f3itemField.getText().trim();
        String amountData = f3amountField.getText().trim();
        int quantityData = (int) spinner2.getValue();
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();

        if (isEditing) {
            itemPrice = 0;
            model.setValueAt(amountData, cartList.indexOf(itemData), 2);
            model.setValueAt(quantityData, cartList.indexOf(itemData), 1);
            
            cartBtn.setText("Add to Cart");
            f3itemField.setText(" ");
            spinner2.setValue(1);
            f3amountField.setText("0.00");
            isEditing = false;
            Form3.trashBtn.setVisible(false);
            orderTable.clearSelection();
        } else {
            
            if (!itemData.isEmpty() && !amountData.isEmpty()) {
                
                model.addRow(new Object[]{itemData, quantityData, amountData});
                cartList.add(itemData);
                priceList.add(Double.parseDouble(amountData)/quantityData);

                f3itemField.setText("");
                itemPrice = 0;
                spinner2.setValue(1);
                f3amountField.setText("0.00");
                isEditing = true;
                Form3.trashBtn.setVisible(false);
            }
        }


    }//GEN-LAST:event_cartBtnActionPerformed

    private void orderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTableMouseClicked


    }//GEN-LAST:event_orderTableMouseClicked

    private void trashBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trashBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        
        int row = orderTable.getSelectedRow();
        
        model.removeRow(row);
        
        cartList.remove(row);
        priceList.remove(row);
        orderTable.clearSelection();
        
        spinner2.setValue(1);
        f3amountField.setText("0.00");
        f3itemField.setText("");
        
        trashBtn.setVisible(false);

    }//GEN-LAST:event_trashBtnActionPerformed

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(grphcs);
    }

    public void initTable() {
        orderTable.setShowGrid(false);

        if (orderTable.getRowCount() > 0) {
            orderTable.setRowSelectionInterval(0, 0);
        }

        LeftCellRenderer LeftRenderer = new LeftCellRenderer();
        ModernCellRenderer modernRenderer = new ModernCellRenderer();
        ModernHeaderRenderer headerRenderer = new ModernHeaderRenderer();

        orderTable.getColumnModel().getColumn(0).setCellRenderer(LeftRenderer); // First column
        for (int i = 1; i < orderTable.getColumnCount(); i++) {
            orderTable.getColumnModel().getColumn(i).setCellRenderer(modernRenderer); // Other columns
        }
        orderTable.getTableHeader().setDefaultRenderer(headerRenderer); // Header

        

        orderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        orderTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int row = orderTable.getSelectedRow();
                    if (row != -1) {
                        isEditing = true;
                        Form3.trashBtn.setVisible(true);
                        System.out.println(row);
                        System.out.println("cart List: " + cartList);
                        System.out.println("price List: " + priceList);

                        spinner2.setValue(orderTable.getValueAt(row, 1));

                        String item = orderTable.getValueAt(row, 0).toString();

                        itemPrice = priceList.get(row);
                        System.out.println(itemPrice);

                        f3itemField.setText(item);

                        double newAmount = (int) spinner2.getValue() * itemPrice;
                        f3amountField.setText(decimal.format(newAmount));
                        
                        cartBtn.setText("Update");
                    }
                }
            }
        });

    }

    // Method to calculate the preferred width of a column based on its content
    private static int getColumnWidth(JTable table, int columnIndex) {
        int width = 0; // Min width
        TableColumn column = table.getColumnModel().getColumn(columnIndex);
        Component comp;
        Font font = new Font("SansSerif", Font.PLAIN, 17);
        for (int row = 0; row < table.getRowCount(); row++) {
            comp = table.prepareRenderer(table.getCellRenderer(row, columnIndex), row, columnIndex);
            comp.setFont(font); // Ensure font is set for accurate width calculation
            width = Math.max(comp.getPreferredSize().width + 10, width); // Adding padding
        }
        return width;
    }

    private static JFormattedTextField.AbstractFormatterFactory createFormatterFactory() {
        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(true);
        format.setParseIntegerOnly(true);

        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0); // Enforce non-negative values
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);

        return new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return formatter;
            }
        };
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static components.RoundedButtons cartBtn;
    private components.RoundedButtons clearBtn;
    private components.RoundedButtons deliveryBtn;
    public static javax.swing.JTextField f3amountField;
    public static javax.swing.JTextField f3itemField;
    public static javax.swing.JTextField itemNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable orderTable;
    private otherForms.PanelBorder panelBorder1;
    private components.PanelItem panelItem2;
    private components.TextFieldAnimation searchField;
    public static javax.swing.JSpinner spinner2;
    public static javax.swing.JButton trashBtn;
    // End of variables declaration//GEN-END:variables
}
