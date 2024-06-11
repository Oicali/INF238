package Pages;

import Main.*;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;
import popUps.*;
import settings.GlassPanePopup;

public class Form2 extends javax.swing.JPanel {

    public Form2() {
        initComponents();
        getCategory();
        editCatBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        if (Main.userPosition.equals("Administrator") || Main.userPosition.equals("Supervisor")) {
            editCatBtn.setVisible(true);
        } else {
            editCatBtn.setVisible(false);
        }

        pic.setBorderSize(1);

        spinner.addChangeListener(e -> {
                int value = (int) spinner.getValue();
                if(value<0){
                    spinner.setValue(0);
                }
            });
        
    }

    private void getCategory() {
        categories.removeAllItems();

        try {
            Statement s = Main.getDbCon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM category");

            while (rs.next()) {
                categories.addItem(rs.getString("label"));
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

    private static AbstractFormatterFactory createFormatterFactory() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        editCatBtn = new components.RoundedButtons();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelItem1 = new components.PanelItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        card5 = new otherForms.Card();
        card4 = new otherForms.Card();
        card2 = new otherForms.Card();
        card3 = new otherForms.Card();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        card6 = new otherForms.Card();
        card7 = new otherForms.Card();
        card8 = new otherForms.Card();
        card9 = new otherForms.Card();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        card10 = new otherForms.Card();
        card11 = new otherForms.Card();
        card12 = new otherForms.Card();
        card13 = new otherForms.Card();
        jLabel4 = new javax.swing.JLabel();
        addBtn = new components.RoundedButtons();
        exportBtn = new components.RoundedButtons();
        panelBorder1 = new otherForms.PanelBorder();
        pic = new components.RoundCornerImageAvatar();
        priceField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        categories = new components.Combobox();
        saveBtn = new components.RoundedButtons();
        jLabel7 = new javax.swing.JLabel();
        spinner = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ErrorMessage = new javax.swing.JLabel();
        itemNameField = new javax.swing.JTextField();
        exportBtn1 = new components.RoundedButtons();
        searchField = new components.TextFieldAnimation();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Products");

        editCatBtn.setForeground(new java.awt.Color(255, 255, 255));
        editCatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/2.png"))); // NOI18N
        editCatBtn.setBorderColor(new java.awt.Color(15, 106, 191));
        editCatBtn.setBorderPainted(false);
        editCatBtn.setColor(new java.awt.Color(15, 106, 191));
        editCatBtn.setColorClick(new java.awt.Color(15, 106, 191));
        editCatBtn.setColorOver(new java.awt.Color(15, 106, 191));
        editCatBtn.setFocusPainted(false);
        editCatBtn.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        editCatBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        editCatBtn.setLabel("Categories");
        editCatBtn.setMaximumSize(new java.awt.Dimension(65, 38));
        editCatBtn.setMinimumSize(new java.awt.Dimension(65, 38));
        editCatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCatBtnActionPerformed(evt);
            }
        });

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelItem1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 300));

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));
        jPanel3.add(card5);
        jPanel3.add(card4);
        jPanel3.add(card2);
        jPanel3.add(card3);

        jScrollPane2.setViewportView(jPanel3);

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(697, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelItem1.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(750, 300));

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));
        jPanel4.add(card6);
        jPanel4.add(card7);
        jPanel4.add(card8);
        jPanel4.add(card9);

        jScrollPane4.setViewportView(jPanel4);

        jLabel3.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelItem1.add(jPanel2);

        jPanel5.setBackground(new java.awt.Color(153, 153, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(750, 300));

        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));
        jPanel6.add(card10);
        jPanel6.add(card11);
        jPanel6.add(card12);
        jPanel6.add(card13);

        jScrollPane5.setViewportView(jPanel6);

        jLabel4.setText("jLabel2");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelItem1.add(jPanel5);

        jScrollPane3.setViewportView(panelItem1);

        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("New Item");
        addBtn.setBorderColor(new java.awt.Color(15, 106, 191));
        addBtn.setBorderPainted(false);
        addBtn.setColor(new java.awt.Color(15, 106, 191));
        addBtn.setColorClick(new java.awt.Color(15, 106, 191));
        addBtn.setColorOver(new java.awt.Color(15, 106, 191));
        addBtn.setFocusPainted(false);
        addBtn.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        addBtn.setMaximumSize(new java.awt.Dimension(65, 38));
        addBtn.setMinimumSize(new java.awt.Dimension(65, 38));
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
        exportBtn.setMaximumSize(new java.awt.Dimension(85, 38));
        exportBtn.setMinimumSize(new java.awt.Dimension(85, 38));
        exportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBtnActionPerformed(evt);
            }
        });

        pic.setForeground(new java.awt.Color(102, 102, 102));
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/school_items.jpg"))); // NOI18N

        priceField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        priceField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(178, 178, 178)), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        priceField.setMaximumSize(new java.awt.Dimension(16, 27));
        priceField.setSelectionColor(new java.awt.Color(204, 204, 204));
        priceField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                priceFieldMouseClicked(evt);
            }
        });
        priceField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                priceFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priceFieldKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel6.setText("Price:");

        categories.setBackground(new java.awt.Color(238, 238, 238));
        categories.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item Category" }));
        categories.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        categories.setLabelText("");
        categories.setOpaque(false);

        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.setBorderColor(new java.awt.Color(15, 106, 191));
        saveBtn.setBorderPainted(false);
        saveBtn.setColor(new java.awt.Color(15, 106, 191));
        saveBtn.setColorClick(new java.awt.Color(15, 106, 191));
        saveBtn.setColorOver(new java.awt.Color(15, 106, 191));
        saveBtn.setFocusPainted(false);
        saveBtn.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        saveBtn.setMaximumSize(new java.awt.Dimension(65, 38));
        saveBtn.setMinimumSize(new java.awt.Dimension(65, 38));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel7.setText("Category:");

        spinner.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        spinner.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(178, 178, 178)));
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) spinner.getEditor();
        editor.getTextField().setHorizontalAlignment(JTextField.CENTER);

        JFormattedTextField textField = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
        textField.setFormatterFactory(createFormatterFactory());

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel8.setText("Quantity:");

        jLabel9.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("jLabel9");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("PHP");

        ErrorMessage.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ErrorMessage.setForeground(new java.awt.Color(255, 51, 51));
        ErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorMessage.setText("    ");
        ErrorMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        itemNameField.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        itemNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemNameField.setText("Scientific Calculator");
        itemNameField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        itemNameField.setMaximumSize(new java.awt.Dimension(16, 27));
        itemNameField.setOpaque(false);
        itemNameField.setSelectionColor(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(itemNameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelBorder1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(categories, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(ErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGap(57, 57, 57)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(itemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(32, 32, 32)
                .addComponent(ErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        exportBtn1.setForeground(new java.awt.Color(255, 255, 255));
        exportBtn1.setText("Import");
        exportBtn1.setBorderColor(new java.awt.Color(15, 106, 191));
        exportBtn1.setBorderPainted(false);
        exportBtn1.setColor(new java.awt.Color(15, 106, 191));
        exportBtn1.setColorClick(new java.awt.Color(15, 106, 191));
        exportBtn1.setColorOver(new java.awt.Color(15, 106, 191));
        exportBtn1.setFocusPainted(false);
        exportBtn1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        exportBtn1.setMaximumSize(new java.awt.Dimension(85, 38));
        exportBtn1.setMinimumSize(new java.awt.Dimension(85, 38));
        exportBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBtn1ActionPerformed(evt);
            }
        });

        searchField.setBackground(new java.awt.Color(240, 240, 240));
        searchField.setAnimationColor(new java.awt.Color(15, 106, 191));
        searchField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        searchField.setHintText("Search an item");
        searchField.setSelectionColor(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(editCatBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(exportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exportBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(399, 399, 399)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editCatBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editCatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCatBtnActionPerformed
        editCategories obj23 = new editCategories();
        GlassPanePopup.showPopup(obj23);
    }//GEN-LAST:event_editCatBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

    }//GEN-LAST:event_addBtnActionPerformed

    private void exportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBtnActionPerformed


    }//GEN-LAST:event_exportBtnActionPerformed

    private void exportBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exportBtn1ActionPerformed

    private void priceFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_priceFieldMouseClicked

    }//GEN-LAST:event_priceFieldMouseClicked

    private void priceFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceFieldKeyTyped
        char c = evt.getKeyChar();
                String textValue = priceField.getText();
                int dotIndex = textValue.indexOf('.');
                boolean moreThan2Dec = dotIndex != -1 && textValue.substring(dotIndex).length() > 2;

                if (!(Character.isDigit(c) || c == '.')) {
                    evt.consume();
                    return;
                } else {
                    priceField.setCaretPosition(priceField.getText().length());
                    if (c == '0' && priceField.getText().isEmpty()) {
                        evt.consume();
                        
                        priceField.setText("0.");
                    } 
                }

                if (c == '.' && priceField.getText().contains(".")) {
                    evt.consume();
                    return;
                } else if (c == '.' && priceField.getText().isEmpty()) {
                    
                    priceField.setCaretPosition(priceField.getText().length());
                    priceField.setText("0.");
                    evt.consume();
                } 

                // allow only 2 digits after decimal
                if (moreThan2Dec) {
                    evt.consume();
                    return;
                }
            
    }//GEN-LAST:event_priceFieldKeyTyped

    private void priceFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceFieldKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE && !priceField.getText().isEmpty()) {
                  
                    if (priceField.getText().equals("0.")) {
                        priceField.setText("");
                    }

                    priceField.setCaretPosition(priceField.getText().length());
                }
    }//GEN-LAST:event_priceFieldKeyPressed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        String price = priceField.getText().trim();
        String item = itemNameField.getText().trim();
        int qty = (int)spinner.getValue();
        
        if(item.isEmpty() || price.isEmpty() || qty < 0){
            ErrorMessage.setText("Invalid Data!");
        } else {
        
        }
    }//GEN-LAST:event_saveBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrorMessage;
    private components.RoundedButtons addBtn;
    private otherForms.Card card10;
    private otherForms.Card card11;
    private otherForms.Card card12;
    private otherForms.Card card13;
    private otherForms.Card card2;
    private otherForms.Card card3;
    private otherForms.Card card4;
    private otherForms.Card card5;
    private otherForms.Card card6;
    private otherForms.Card card7;
    private otherForms.Card card8;
    private otherForms.Card card9;
    private components.Combobox categories;
    private components.RoundedButtons editCatBtn;
    private components.RoundedButtons exportBtn;
    private components.RoundedButtons exportBtn1;
    private javax.swing.JTextField itemNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private otherForms.PanelBorder panelBorder1;
    private components.PanelItem panelItem1;
    private components.RoundCornerImageAvatar pic;
    private javax.swing.JTextField priceField;
    private components.RoundedButtons saveBtn;
    private components.TextFieldAnimation searchField;
    private javax.swing.JSpinner spinner;
    // End of variables declaration//GEN-END:variables
}
