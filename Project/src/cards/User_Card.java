
package cards;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import model.Model_User;

public class User_Card extends javax.swing.JPanel {

    private boolean selected;
    private Model_User data;
    
    public boolean isSelected(){
        return selected;
    }
    
    public void setSelected(boolean selected){
        this.selected = selected;
        repaint();
    }
    
    public void setData(Model_User data){
        this.data = data;
        pic.setIcon(data.getImage());
        userID.setText(data.getCardID());
        userFNameLbl.setText(data.getUserFName());
        userLNameLbl.setText(data.getUserLName());
        userNameLbl.setText(data.getUserName());
        RoleLbl.setText(data.getRole());
        if(data.getStatus().equals("Active")){
            statusPnl.setBackground(new Color(70,191,50));
        } else statusPnl.setBackground(new Color(191,50,50));
                
        
    }

    public User_Card() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userID = new javax.swing.JLabel();
        pic = new components.CircleImageAvatar();
        userFNameLbl = new javax.swing.JLabel();
        userLNameLbl = new javax.swing.JLabel();
        RoleLbl = new javax.swing.JLabel();
        userNameLbl = new javax.swing.JLabel();
        statusPnl = new otherForms.CircularPanel();

        userID.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        userID.setText("jLabel1");

        pic.setForeground(new java.awt.Color(15, 106, 191));
        pic.setBorderSize(2);
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logInUser.png"))); // NOI18N

        userFNameLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        userFNameLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userFNameLbl.setText("First Name");

        userLNameLbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        userLNameLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLNameLbl.setText("Last Name");

        RoleLbl.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        RoleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RoleLbl.setText("Role");

        userNameLbl.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        userNameLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userNameLbl.setText("username");

        statusPnl.setBackground(new java.awt.Color(70, 191, 50));

        javax.swing.GroupLayout statusPnlLayout = new javax.swing.GroupLayout(statusPnl);
        statusPnl.setLayout(statusPnlLayout);
        statusPnlLayout.setHorizontalGroup(
            statusPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        statusPnlLayout.setVerticalGroup(
            statusPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statusPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(userLNameLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userFNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(RoleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userID)
                    .addComponent(statusPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(userFNameLbl)
                .addGap(1, 1, 1)
                .addComponent(userLNameLbl)
                .addGap(16, 16, 16)
                .addComponent(userNameLbl)
                .addGap(3, 3, 3)
                .addComponent(RoleLbl)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paint(Graphics grphcs){
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242, 242, 242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight() , 20, 20);
        if(selected){
            g2.setColor(new Color(94, 156, 255));
            g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        }
        g2.dispose();
        super.paint(grphcs);
    } 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RoleLbl;
    private components.CircleImageAvatar pic;
    private otherForms.CircularPanel statusPnl;
    private javax.swing.JLabel userFNameLbl;
    private javax.swing.JLabel userID;
    private javax.swing.JLabel userLNameLbl;
    private javax.swing.JLabel userNameLbl;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the data
     */
    public Model_User getData() {
        return data;
    }
    
    
}
