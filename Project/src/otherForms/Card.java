
package otherForms;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import settings.Model_User;


public class Card extends javax.swing.JPanel {

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

    public Card() {
        initComponents();
        setOpaque(false);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userID = new javax.swing.JLabel();
        pic = new components.ImageAvatar();
        userFNameLbl = new javax.swing.JLabel();
        userLNameLbl = new javax.swing.JLabel();
        RoleLbl = new javax.swing.JLabel();
        userNameLbl = new javax.swing.JLabel();
        statusPnl = new otherForms.CircularPanel();

        userID.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        userID.setText("jLabel1");

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logInUser.png"))); // NOI18N

        userFNameLbl.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        userFNameLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userFNameLbl.setText("First Name");

        userLNameLbl.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(RoleLbl))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 51, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(statusPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(userLNameLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userFNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userID)
                    .addComponent(statusPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userFNameLbl)
                .addGap(3, 3, 3)
                .addComponent(userLNameLbl)
                .addGap(20, 20, 20)
                .addComponent(userNameLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RoleLbl)
                .addContainerGap(15, Short.MAX_VALUE))
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
    private otherForms.CircularPanel circularPanel1;
    private otherForms.CircularPanel circularPanel2;
    private otherForms.CircularPanel circularPanel3;
    private otherForms.CircularPanel circularPanel4;
    private otherForms.CircularPanel circularPanel5;
    private otherForms.CircularPanel circularPanel6;
    private otherForms.CircularPanel circularPanel8;
    private otherForms.CircularPanel circularPanel9;
    private components.ImageAvatar pic;
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
