/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import Main.Main;
import Main.home;
import Pages.Form2;
import static Pages.Form2.spinner;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.NumberFormatter;
import settings.GlassPanePopup;

/**
 *
 * @author ASUS
 */
public class addNewProduct extends javax.swing.JPanel {

    private JFileChooser file = new JFileChooser();

    public addNewProduct() {
        initComponents();
        setOpaque(false);
        addCategoryChoices();

        spinner.addChangeListener(e -> {
            int value = (int) spinner.getValue();
            if (value < 0) {
                spinner.setValue(0);
            }
        });
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
    
    private void addCategoryChoices() {
        categoryChoices.removeAllItems();

        try {
            Statement s = Main.getDbCon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM category");

            while (rs.next()) {
                categoryChoices.addItem(rs.getString("label"));
                System.out.println(rs.getString("label"));
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

    private static void resizeAndCopyImage(File sourceFile, File destFile, int width, int height) throws IOException {
        // Read the source image
        BufferedImage originalImage = ImageIO.read(sourceFile);

        // Create a new buffered image with the desired dimensions
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Draw the original image into the new image with the new dimensions
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();

        // Extract the file extension
        String formatName = destFile.getName().substring(destFile.getName().lastIndexOf(".") + 1);

        // Write the resized image to the destination file
        ImageIO.write(resizedImage, formatName, destFile);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        itemNameField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        ErrorMessage = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        spinner = new javax.swing.JSpinner();
        categoryChoices = new components.Combobox();
        jLabel9 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        uploadBtn = new javax.swing.JButton();
        generateBtn = new components.RoundedButtons();
        jLabel24 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add New Item");

        itemNameField.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        itemNameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        itemNameField.setSelectionColor(new java.awt.Color(204, 204, 204));
        itemNameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemNameFieldMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Item Name:");

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 51, 51));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("*");

        ErrorMessage.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ErrorMessage.setForeground(new java.awt.Color(255, 51, 51));
        ErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        priceField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        priceField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(178, 178, 178)), javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        priceField.setMaximumSize(new java.awt.Dimension(16, 27));
        priceField.setSelectionColor(new java.awt.Color(204, 204, 204));
        priceField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                priceFieldMouseClicked(evt);
            }
        });
        priceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFieldActionPerformed(evt);
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

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setText("Price:");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("PHP");

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 51, 51));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("*");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setText("Quantity:");

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 51, 51));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("*");

        spinner.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        spinner.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(178, 178, 178)));
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) spinner.getEditor();
        editor.getTextField().setHorizontalAlignment(JTextField.CENTER);

        JFormattedTextField textField = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
        textField.setFormatterFactory(createFormatterFactory());
        spinner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spinnerMouseClicked(evt);
            }
        });

        categoryChoices.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item Category" }));
        categoryChoices.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        categoryChoices.setLabelText("");
        categoryChoices.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setText("Category:");

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 51, 51));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("*");

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel11.setText("Image:");

        uploadBtn.setBackground(new java.awt.Color(15, 106, 191));
        uploadBtn.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        uploadBtn.setForeground(new java.awt.Color(255, 255, 255));
        uploadBtn.setText("Upload Image");
        uploadBtn.setBorderPainted(false);
        uploadBtn.setFocusPainted(false);
        uploadBtn.setPreferredSize(new java.awt.Dimension(29, 25));
        uploadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadBtnActionPerformed(evt);
            }
        });

        generateBtn.setForeground(new java.awt.Color(255, 255, 255));
        generateBtn.setText("Add Item");
        generateBtn.setBorderColor(new java.awt.Color(70, 191, 50));
        generateBtn.setBorderPainted(false);
        generateBtn.setColor(new java.awt.Color(70, 191, 50));
        generateBtn.setColorClick(new java.awt.Color(70, 191, 50));
        generateBtn.setColorOver(new java.awt.Color(70, 191, 50));
        generateBtn.setFocusPainted(false);
        generateBtn.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        generateBtn.setPreferredSize(new java.awt.Dimension(97, 40));
        generateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBtnActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 51, 51));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdCancel))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel8)
                                        .addGap(3, 3, 3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(itemNameField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(categoryChoices, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(priceField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(spinner)
                                    .addComponent(uploadBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(ErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(generateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel21))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryChoices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uploadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24)))
                .addGap(33, 33, 33)
                .addComponent(ErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(generateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Changes you made will not be save.\nClick Yes to close.", "Close Task", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            GlassPanePopup.closePopupLast();
        }
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void itemNameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemNameFieldMouseClicked
        ErrorMessage.setText(" ");
    }//GEN-LAST:event_itemNameFieldMouseClicked

    private void priceFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_priceFieldMouseClicked
        ErrorMessage.setText(" ");
    }//GEN-LAST:event_priceFieldMouseClicked

    private void priceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFieldActionPerformed

    private void priceFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceFieldKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE && !priceField.getText().isEmpty()) {

            if (priceField.getText().equals("0.")) {
                priceField.setText("");
            }

            priceField.setCaretPosition(priceField.getText().length());
        }
    }//GEN-LAST:event_priceFieldKeyPressed

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

    private void spinnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spinnerMouseClicked
        ErrorMessage.setText(" ");
    }//GEN-LAST:event_spinnerMouseClicked

    private void uploadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadBtnActionPerformed

        file.setCurrentDirectory(new File("user.dir"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("All Pic", "png", "jpg");
        file.setFileFilter(filter);

        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            if (!filePath.toLowerCase().endsWith(".png") && !filePath.toLowerCase().endsWith(".jpg")) {
                JOptionPane.showMessageDialog(null, "Please select a valid image file (PNG, JPG).", "Invalid File", JOptionPane.ERROR_MESSAGE);
            } else {

                // Destination directory
                String destinationDir = "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\Inventory_System\\Products";
                File destinationFile = new File(destinationDir, selectedFile.getName());

                try {
                    resizeAndCopyImage(selectedFile, destinationFile, 150, 150);

                    System.out.println(destinationFile.getName());
                    String file = destinationFile.getName();

                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "File upload failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }


    }//GEN-LAST:event_uploadBtnActionPerformed

    private void generateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBtnActionPerformed
        String item = itemNameField.getText().trim();
        String price = priceField.getText().trim();

        if (item.isEmpty() || price.isEmpty()) {
            ErrorMessage.setText("Please complete all required fields with *");
        } else if (file.getSelectedFile() == null) {
            ErrorMessage.setText("Please upload an image!");
        } else {

            int choice = JOptionPane.showConfirmDialog(this, "Click yes to confirm.", "Add New Item", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {

                try {
                    Statement s = Main.getDbCon().createStatement();

                    String newCategory = (String) categoryChoices.getSelectedItem();
                    String catID = "";
                    ResultSet rs = s.executeQuery("select * from category where label = '" + newCategory + "'");

                    while (rs.next()) {
                        catID = rs.getString("category_ID");
                    }

                    Connection con = Main.getDbCon();

                    File selectedFile = file.getSelectedFile();

                    String destinationDir = "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\Inventory_System\\Products";
                    File destinationFile = new File(destinationDir, selectedFile.getName());

                    try {
                        resizeAndCopyImage(selectedFile, destinationFile, 150, 150);
                        System.out.println(destinationFile.getName());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "File upload failed!", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    String query = "INSERT INTO products (item_Image, item_Name, quantity, price, category_fk) "
                            + " VALUES (LOAD_FILE(?), ?, ?, ?, ?)";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, destinationFile.getAbsolutePath());
                    ps.setString(2, item);
                    ps.setString(3, String.valueOf(spinner.getValue()));
                    ps.setString(4, price);
                    ps.setString(5, catID);

                    ErrorMessage.setText(" ");

                    ps.close();
                    con.close();

                    GlassPanePopup.closePopupLast();
                    home.form2Products = new Form2();
                    home.setForm(home.form2Products);
                    home.successAddItem.showNotification();

                } catch (SQLException e) {
                    e.printStackTrace(); // Print the exception details for debugging
                    JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    Main.closeCon();
                }

               

            }
        }

    }//GEN-LAST:event_generateBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrorMessage;
    public static components.Combobox categoryChoices;
    private javax.swing.JButton cmdCancel;
    private components.RoundedButtons generateBtn;
    private javax.swing.JTextField itemNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField priceField;
    public static javax.swing.JSpinner spinner;
    private javax.swing.JButton uploadBtn;
    // End of variables declaration//GEN-END:variables
}
