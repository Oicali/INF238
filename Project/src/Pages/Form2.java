package Pages;

import Main.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import components.ScrollBarCustom;
import interfaces.EventCallBack;
import interfaces.EventTextField;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;
import popUps.*;
import settings.GlassPanePopup;
import model.Model_Products;
import otherForms.addNewProducts;
import otherForms.categoryPanel;

public class Form2 extends javax.swing.JPanel {

    private Map<String, categoryPanel> categoryPanels;
    public static String oldItemName = "";
    private static final String DESTINATION_DIRECTORY = "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\Inventory_System\\Documents";

    public Form2() {
        initComponents();
        setOpaque(false);

        categoryPanels = new HashMap<>();

        getCategory();
        editCatBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exportBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        impBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        impBtn.setVisible(false);

        if (Main.userPosition.equals("Administrator") || Main.userPosition.equals("Supervisor")) {
            editCatBtn.setVisible(true);
            itemNameField.setEditable(true);
        } else {
            editCatBtn.setVisible(false);
        }

        picLbl.setBorderSize(1);

        spinner.addChangeListener(e -> {
            int value = (int) spinner.getValue();
            if (value < 0) {
                spinner.setValue(0);
            }
        });

        initData();

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
        boolean itemsChecker = false;
        try {
            panelItem1.removeAll();
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

            panelItem1.repaint();
            panelItem1.revalidate();

            rs = s.executeQuery("select count(quantity) from products inner join category on products.category_fk = category_ID where quantity <= " + Main.lowerLimit);
            rs.next();
            int userCount = rs.getInt(1);

            if (userCount > 0) {
                itemsChecker = true;
            }

            // Close the ResultSet
            rs.close();
            s.close();

            Timer itemNotif = new Timer(3200, new MyActionListener(itemsChecker));

            itemNotif.setRepeats(false);
            itemNotif.start();

        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception details for debugging
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            Main.closeCon();
        }
    }

    public void searchData() {
        try {
            panelItem1.removeAll();

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

            panelItem1.repaint();
            panelItem1.revalidate();
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

    private void getCategory() {
        categoryField.removeAllItems();

        try {
            Statement s = Main.getDbCon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM category");

            while (rs.next()) {
                categoryField.addItem(rs.getString("label"));
                addPanelCategory(rs.getString("label"));
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

    public void addPanelCategory(String category) {
        categoryPanel panel = new categoryPanel(category);
        categoryPanels.put(category, panel);
        panelItem1.add(panel);

        panelItem1.repaint();
        panelItem1.revalidate();
    }

    public void addItemToCategory(String category, Model_Products item) {
        categoryPanel panel = categoryPanels.get(category);
        if (panel == null) {
            addPanelCategory(category);
            panel = categoryPanels.get(category);
        }
        panel.addItem(item);
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

    private static void processCSV(java.io.File csvFile) throws FileNotFoundException, IOException, CsvValidationException {
        // Define the expected column count
        int EXPECTED_COLUMN_COUNT = 6;

        CSVReader csvReader = null;
        PreparedStatement ps = null;

        Connection con = Main.getDbCon();
        try {
            // Establish database connection

            // Create a BufferedReader to read the CSV file
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));

            // Create a CSVReader using the BufferedReader
            csvReader = new CSVReader(reader);

            // Read the CSV file
            String[] headers = csvReader.readNext();

            // Validate headers
            if (headers == null || headers.length != EXPECTED_COLUMN_COUNT) {
                throw new IllegalArgumentException("CSV file has incorrect headers or column count.");
            }

            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                // Validate row length
                if (nextLine.length != EXPECTED_COLUMN_COUNT) {
                    throw new IllegalArgumentException("CSV file has rows with incorrect column count.");
                }

                // Assume the CSV columns are in the order: column1, column2, id
                String column1 = nextLine[0];
                String column2 = nextLine[1];
                String column3 = nextLine[2];
                String column4 = nextLine[3];
                String column5 = nextLine[4];
                String column6 = nextLine[5];

                // Prepare SQL update statement
                ps = con.prepareStatement("UPDATE products SET item_Name = ?, quantity = ?, price = ?, category_fk = ? WHERE product_pk = ?");

                // Set the parameters for the update statement
                ps.setString(1, column2);
                ps.setString(2, column3);
                ps.setString(3, column4);
                ps.setString(4, column5);
                ps.setString(5, column1);

                // Add to batch
                ps.executeUpdate();
            }

            // Save file to destination directory
            saveFileToDirectory(csvFile);

            home.form2Products = new Form2();
            home.setForm(home.form2Products);
            home.form3Order = new Form3();
            home.successUpdateItem.showNotification();

        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception details for debugging
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                // Close resources in the reverse order of opening
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
                if (csvReader != null) {
                    csvReader.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void saveFileToDirectory(File csvFile) throws IOException {
        // Create destination directory if it doesn't exist
        Path destinationDirectory = Paths.get(DESTINATION_DIRECTORY);
        if (!Files.exists(destinationDirectory)) {
            Files.createDirectories(destinationDirectory);
        }

        // Prepare destination file path
        String fileName = csvFile.getName();
        Path destinationFilePath = destinationDirectory.resolve(fileName);

        // Copy CSV file to destination directory
        Files.copy(csvFile.toPath(), destinationFilePath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

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

        jLabel1 = new javax.swing.JLabel();
        editCatBtn = new components.RoundedButtons();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelItem1 = new components.PanelItem();
        addBtn = new components.RoundedButtons();
        exportBtn = new components.RoundedButtons();
        itemDataPanel = new otherForms.PanelBorder();
        picLbl = new components.RoundCornerImageAvatar();
        priceField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        categoryField = new components.Combobox();
        saveBtn = new components.RoundedButtons();
        jLabel7 = new javax.swing.JLabel();
        spinner = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        IDField = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        f2ErrorMessage = new javax.swing.JLabel();
        itemNameField = new javax.swing.JTextField();
        searchField = new components.SearchFieldAnimation();
        impBtn = new components.RoundedButtons();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Products and Stocks");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 20, 1070, 68));

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
        add(editCatBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 176, 38));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane3.setViewportView(panelItem1);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 172, 730, 580));

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
        add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 159, 38));

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
        add(exportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 110, 100, 38));

        itemDataPanel.setMaximumSize(null);

        picLbl.setForeground(new java.awt.Color(204, 204, 204));

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

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setText("Price:");

        categoryField.setBackground(new java.awt.Color(238, 238, 238));
        categoryField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item Category" }));
        categoryField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        categoryField.setLabelText("");
        categoryField.setOpaque(false);

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

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setText("Category:");

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

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setText("Stocks:");

        IDField.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        IDField.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        IDField.setText("Item ID:");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("PHP");

        f2ErrorMessage.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        f2ErrorMessage.setForeground(new java.awt.Color(255, 51, 51));
        f2ErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f2ErrorMessage.setText("    ");
        f2ErrorMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        itemNameField.setEditable(false);
        itemNameField.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        itemNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemNameField.setText("  ");
        itemNameField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        itemNameField.setMaximumSize(new java.awt.Dimension(16, 27));
        itemNameField.setOpaque(false);
        itemNameField.setSelectionColor(new java.awt.Color(204, 204, 204));
        itemNameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemNameFieldMouseClicked(evt);
            }
        });
        itemNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNameFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout itemDataPanelLayout = new javax.swing.GroupLayout(itemDataPanel);
        itemDataPanel.setLayout(itemDataPanelLayout);
        itemDataPanelLayout.setHorizontalGroup(
            itemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemDataPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(picLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(itemDataPanelLayout.createSequentialGroup()
                .addGroup(itemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(itemDataPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(itemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(IDField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemNameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(itemDataPanelLayout.createSequentialGroup()
                                .addGroup(itemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(itemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(spinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priceField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(saveBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(itemDataPanelLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(f2ErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        itemDataPanelLayout.setVerticalGroup(
            itemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemDataPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(picLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(itemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(itemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(IDField)
                .addGap(30, 30, 30)
                .addComponent(f2ErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        add(itemDataPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 325, 580));

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

        impBtn.setForeground(new java.awt.Color(255, 255, 255));
        impBtn.setText("Import");
        impBtn.setBorderColor(new java.awt.Color(15, 106, 191));
        impBtn.setBorderPainted(false);
        impBtn.setColor(new java.awt.Color(15, 106, 191));
        impBtn.setColorClick(new java.awt.Color(15, 106, 191));
        impBtn.setColorOver(new java.awt.Color(15, 106, 191));
        impBtn.setFocusPainted(false);
        impBtn.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        impBtn.setMaximumSize(new java.awt.Dimension(85, 38));
        impBtn.setMinimumSize(new java.awt.Dimension(85, 38));
        impBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                impBtnActionPerformed(evt);
            }
        });
        add(impBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 110, 100, 38));
    }// </editor-fold>//GEN-END:initComponents

    private void editCatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCatBtnActionPerformed
        f2ErrorMessage.setText(" ");
        editCategories obj23 = new editCategories();
        GlassPanePopup.showPopup(obj23);
    }//GEN-LAST:event_editCatBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        f2ErrorMessage.setText(" ");
        placeholder obj24 = new placeholder();
        GlassPanePopup.showPopup(obj24);
        new addNewProducts(null, true).show();
    }//GEN-LAST:event_addBtnActionPerformed

    private void exportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBtnActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Get a copy of products information?", "Export Products", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            try {
                Statement s = Main.getDbCon().createStatement();

                ResultSet rs = s.executeQuery("select product_pk, item_Name, quantity, price, category_ID, label FROM products INNER JOIN category ON products.category_fk = category.category_ID;");
                // Determine the path to the Downloads folder
                String userHome = System.getProperty("user.home");
                String downloadsPath = Paths.get(userHome, "Downloads", "Copy of Mark-It Products.csv").toString();

                // Ensure the Downloads folder exists (it should by default on most systems)
                Files.createDirectories(Paths.get(userHome, "Downloads"));

                writeResultSetToCSV(rs, downloadsPath);

                rs.close();
                s.close();

//                home.form2Products = new Form2();
//                home.setForm(home.form2Products);
                home.successPrintUsers.showNotification();
                impBtn.setVisible(true);

            } catch (SQLException e) {
                e.printStackTrace(); // Print the exception details for debugging
                JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(Form2.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                Main.closeCon();
            }

        }

    }//GEN-LAST:event_exportBtnActionPerformed

    private void impBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_impBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select CSV File");
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Get selected file
            java.io.File csvFile = fileChooser.getSelectedFile();

            try {
                // Process selected file
                processCSV(csvFile);

            } catch (IOException ex) {
                Logger.getLogger(Form2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CsvValidationException ex) {
                Logger.getLogger(Form2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_impBtnActionPerformed

    private void priceFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_priceFieldMouseClicked
        f2ErrorMessage.setText(" ");
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
        f2ErrorMessage.setText(" ");

        String item = itemNameField.getText().trim();
        String price = priceField.getText().trim();

        if (price.isEmpty() || item.isEmpty()) {
            f2ErrorMessage.setText("Incomplete Data!");
        } else {
            try {
                Statement s = Main.getDbCon().createStatement();

                String newCategory = (String) categoryField.getSelectedItem();
                String catID = "";
                ResultSet rs = s.executeQuery("select * from category where label = '" + newCategory + "'");

                while (rs.next()) {
                    catID = rs.getString("category_ID");
                }

                Connection con = Main.getDbCon();

                PreparedStatement ps = con.prepareStatement("UPDATE products SET item_Name = ?, quantity = ?, price = ?, category_fk = ? where item_Name = ?");
                ps.setString(1, item);
                ps.setString(2, String.valueOf(spinner.getValue()));
                ps.setString(3, priceField.getText());
                ps.setString(4, catID);
                ps.setString(5, oldItemName);
                ps.executeUpdate();

                f2ErrorMessage.setText(" ");

                home.form2Products = new Form2();
                home.setForm(home.form2Products);
                home.form3Order = new Form3();
                home.successUpdateItem.showNotification();

                // Close the ResultSet
                ps.close();
                con.close();
                rs.close();
                s.close();

            } catch (SQLException e) {
                e.printStackTrace(); // Print the exception details for debugging
                JOptionPane.showMessageDialog(null, "An error occurred. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                Main.closeCon();
            }
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void itemNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemNameFieldActionPerformed

    private void priceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFieldActionPerformed

    private void spinnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spinnerMouseClicked
        f2ErrorMessage.setText(" ");
    }//GEN-LAST:event_spinnerMouseClicked

    private void itemNameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemNameFieldMouseClicked
        f2ErrorMessage.setText(" ");
    }//GEN-LAST:event_itemNameFieldMouseClicked

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void importBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exportBtn1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel IDField;
    private components.RoundedButtons addBtn;
    public static components.Combobox categoryField;
    private components.RoundedButtons editCatBtn;
    private components.RoundedButtons exportBtn;
    public static javax.swing.JLabel f2ErrorMessage;
    private components.RoundedButtons impBtn;
    public static otherForms.PanelBorder itemDataPanel;
    public static javax.swing.JTextField itemNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private components.PanelItem panelItem1;
    public static components.RoundCornerImageAvatar picLbl;
    public static javax.swing.JTextField priceField;
    private components.RoundedButtons saveBtn;
    private components.SearchFieldAnimation searchField;
    public static javax.swing.JSpinner spinner;
    // End of variables declaration//GEN-END:variables
}

class MyActionListener implements ActionListener {

    private boolean itemsChecker;

    public MyActionListener(boolean itemsChecker) {
        this.itemsChecker = itemsChecker;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (itemsChecker) {
            home.itemWarning.showNotification();
        }
    }
}
