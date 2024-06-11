/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author ASUS
 */
public class NewJFrame extends javax.swing.JFrame {

     private Map<String, categoryPnl> categoryPanels;
    public NewJFrame() {
        initComponents();

        categoryPanels = new HashMap<>();
        addCategory("Pencils");
        addCategory("Pens");
    }

    public void addCategory(String category) {
        categoryPnl panel = new categoryPnl(category);
        System.out.println(category);
        categoryPanels.put(category, panel);
        panelItem1.add(panel);

        panelItem1.repaint();
        panelItem1.revalidate();
    }
    
    public void addItemToCategory(String category, Model_Pro item) {
        categoryPnl panel = categoryPanels.get(category);
        if (panel == null) {
            addCategory(category);
            panel = categoryPanels.get(category);
        }
        panel.addItem(item);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelItem1 = new components.PanelItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportView(panelItem1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                 NewJFrame frame = new NewJFrame();
                frame.setVisible(true);
                
                frame.addItemToCategory("Pencils", new Model_Pro("Pencil A", new ImageIcon("D:\\GitHub\\INF238\\Project\\src\\resources\\logoSmall.png"), 10000, 5000.0));
                frame.addItemToCategory("Pencils", new Model_Pro("Pencil B", new ImageIcon("D:\\GitHub\\INF238\\Project\\src\\resources\\logoSmall.png"), 10000, 5000.0));
                frame.addItemToCategory("Pencils", new Model_Pro("Pencil A", new ImageIcon("D:\\GitHub\\INF238\\Project\\src\\resources\\logoSmall.png"), 10000, 5000.0));
                frame.addItemToCategory("Pencils", new Model_Pro("Pencil B", new ImageIcon("D:\\GitHub\\INF238\\Project\\src\\resources\\logoSmall.png"), 10000, 5000.0));
                frame.addItemToCategory("Pencils", new Model_Pro("Pencil A", new ImageIcon("D:\\GitHub\\INF238\\Project\\src\\resources\\logoSmall.png"), 10000, 5000.0));
                frame.addItemToCategory("Pencils", new Model_Pro("Pencil B", new ImageIcon("D:\\GitHub\\INF238\\Project\\src\\resources\\logoSmall.png"), 10000, 5000.0));
                frame.addItemToCategory("Pencils", new Model_Pro("Pencil A", new ImageIcon("D:\\GitHub\\INF238\\Project\\src\\resources\\logoSmall.png"), 10000, 5000.0));
                frame.addItemToCategory("Pencils", new Model_Pro("Pencil B", new ImageIcon("D:\\GitHub\\INF238\\Project\\src\\resources\\logoSmall.png"), 10000, 5000.0));
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private components.PanelItem panelItem1;
    // End of variables declaration//GEN-END:variables
}
