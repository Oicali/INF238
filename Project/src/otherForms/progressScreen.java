package otherForms;

import java.awt.Color;
import javax.swing.JDialog;

public class progressScreen extends javax.swing.JDialog {

    public progressScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getContentPane().setBackground(new Color(15, 106, 191));
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    }

    private void loading(String status, int progress) throws Exception {
        lblStatus.setText(status);
        Thread.sleep(150);
        bar.setValue(progress);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        curvesPanel1 = new components.CurvesPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        bar = new components.ProgressBarCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 350));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        curvesPanel1.setBackground(new java.awt.Color(204, 204, 204));
        curvesPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logoSmall.png"))); // NOI18N
        curvesPanel1.add(jLabel1);
        jLabel1.setBounds(220, 50, 100, 100);

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mark-It!");
        curvesPanel1.add(jLabel2);
        jLabel2.setBounds(180, 150, 190, 50);

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Inventory System");
        curvesPanel1.add(jLabel3);
        jLabel3.setBounds(188, 200, 170, 22);

        lblStatus.setBackground(new java.awt.Color(255, 255, 255));
        lblStatus.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("Status ...");
        curvesPanel1.add(lblStatus);
        lblStatus.setBounds(120, 260, 320, 15);

        bar.setBackground(new java.awt.Color(204, 204, 204));
        bar.setForeground(new java.awt.Color(255, 255, 255));
        bar.setOpaque(false);
        curvesPanel1.add(bar);
        bar.setBounds(120, 245, 310, 5);

        getContentPane().add(curvesPanel1);
        curvesPanel1.setBounds(0, 0, 550, 350);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    loading("Connecting to Database . . .", 1);
                    loading("Connecting to Database . . .", 2);
                    loading("Connecting to Database . . .", 3);
                    loading("Connecting to Database . . .", 4);
                    loading("Connecting to Database . . .", 5);
                    loading("Connecting to Database . . .", 7);
                    loading("Connecting to Database . . .", 8);
                    loading("Connecting to Database . . .", 9);
                    loading("Connecting to Database . . .", 10);
                    loading("Loading product data . . .", 20);
                    loading("Loading product data . . .", 20);
                    loading("Loading product data . . .", 21);
                    loading("Loading product data . . .", 21);
                    loading("Loading product data . . .", 22);
                    loading("Loading product data . . .", 22);
                    loading("Loading product data . . .", 23);
                    loading("Loading product data . . .", 23);
                    loading("Loading product data . . .", 24);
                    loading("Loading product data . . .", 24);
                    loading("Loading product data . . .", 25);
                    loading("Loading product data . . .", 25);
                    loading("Fetching supplier information . . .", 30);
                    loading("Fetching supplier information . . .", 31);
                    loading("Fetching supplier information . . .", 32);
                    loading("Fetching supplier information . . .", 33);
                    loading("Initializing user accounts . . .", 40);
                    loading("Initializing user accounts . . .", 41);
                    loading("Initializing user accounts . . .", 42);
                    loading("Initializing user accounts . . .", 43);
                    loading("Initializing user accounts . . .", 44);
                    loading("Initializing user accounts . . .", 45);
                    loading("Configuring dashboard . . .", 56);
                    loading("Configuring dashboard . . .", 57);
                    loading("Configuring dashboard . . .", 58);
                    loading("Configuring dashboard . . .", 59);
                    loading("Configuring dashboard . . .", 60);
                    loading("Configuring dashboard . . .", 61);
                    loading("Configuring dashboard . . .", 62);
                    loading("Configuring dashboard . . .", 63);
                    loading("Configuring dashboard . . .", 64);
                    loading("Configuring dashboard . . .", 65);
                    loading("Preparing inventory counts . . .", 70);
                    loading("Preparing inventory counts . . .", 70);
                    loading("Preparing inventory counts . . .", 71);
                    loading("Preparing inventory counts . . .", 72);
                    loading("Preparing inventory counts . . .", 73);
                    loading("Finalizing setup . . .", 90);
                    loading("Finalizing setup . . .", 91);
                    loading("Finalizing setup . . .", 92);
                    loading("Finalizing setup . . .", 93);
                    loading("Finalizing setup . . .", 94);
                    loading("Finalizing setup . . .", 95);
                    loading("Finalizing setup . . .", 96);
                    loading("Finalizing setup . . .", 97);
                    loading("Finalizing setup . . .", 98);
                    loading("Finalizing setup . . .", 99);
                    loading("Finalizing setup . . .", 100);
                    dispose();
                    curvesPanel1.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(progressScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(progressScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(progressScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(progressScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                progressScreen dialog = new progressScreen(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.ProgressBarCustom bar;
    private components.CurvesPanel curvesPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}
