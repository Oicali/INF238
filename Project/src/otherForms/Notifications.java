/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherForms;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JDialog;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import settings.ShadowRenderer;

public class Notifications extends javax.swing.JPanel {

    private JDialog dialog;
    private Animator animator;
    private final Frame fram;
    private boolean showing;
    private Thread thread;
    private int animate = 10;
    private BufferedImage imageShadow;
    private int shadowSize = 6;
    private Type type;
    private Location location;

    public Notifications(Frame fram, Type type, Location location, String message, String submsg) {
        setBackground(new Color(0, 0, 0, 0));
        this.fram = fram;
        this.type = type;
        this.location = location;
        initComponents();
        init(message, submsg);
        initAnimator(); 
        setBackground(new Color(0, 0, 0, 0));
        setOpaque(false);
    }

    private void init(String message, String submsg) {
        
        dialog = new JDialog(fram);
        dialog.setUndecorated(true);
        dialog.setFocusableWindowState(false);
        dialog.setBackground(new Color(0, 0, 0, 0));
        dialog.add(this);
        dialog.setSize(getPreferredSize());
        if (type == Type.SUCCESS) {
            lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sucess.png")));
            lbMessage.setText(message);
        } else if (type == Type.INFO) {
            lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/info.png")));
            lbMessage.setText(message);
        } else {
            lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/warning.png")));
            lbMessage.setText(message);
        }
        lbMessageText.setText(submsg);
    }

    private void initAnimator() {
        TimingTarget target = new TimingTargetAdapter() {
            private int x;
            private int top;
            private boolean top_to_bot;

            @Override
            public void timingEvent(float fraction) {
                if (showing) {
                    float alpha = 1f - fraction;
                    int y = (int) ((1f - fraction) * animate);
                    if (top_to_bot) {
                        dialog.setLocation(x, top + y);
                    } else {
                        dialog.setLocation(x, top - y);
                    }
                    dialog.setOpacity(alpha);
                } else {
                    float alpha = fraction;
                    int y = (int) (fraction * animate);
                    if (top_to_bot) {
                        dialog.setLocation(x, top + y);
                    } else {
                        dialog.setLocation(x, top - y);
                    }
                    dialog.setOpacity(alpha);
                }
            }

            @Override
            public void begin() {
                if (!showing) {
                    dialog.setOpacity(0f);
                    int margin = 10;
                    int y = 0;
                    if (location == Location.TOP_CENTER) {
                        x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                        y = fram.getY() + 10;
                        top_to_bot = true;
                    } else if (location == Location.TOP_RIGHT) {
                        x = fram.getX() + fram.getWidth() - dialog.getWidth() - margin;
                        y = fram.getY();
                        top_to_bot = true;
                    } else if (location == Location.TOP_LEFT) {
                        x = fram.getX() + margin;
                        y = fram.getY();
                        top_to_bot = true;
                    } else if (location == Location.BOTTOM_CENTER) {
                        x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                        y = fram.getY() + fram.getHeight() - dialog.getHeight();
                        top_to_bot = false;
                    } else if (location == Location.BOTTOM_RIGHT) {
                        x = fram.getX() + fram.getWidth() - dialog.getWidth() - margin;
                        y = fram.getY() + fram.getHeight() - dialog.getHeight();
                        top_to_bot = false;
                    } else if (location == Location.BOTTOM_LEFT) {
                        x = fram.getX() + margin;
                        y = fram.getY() + fram.getHeight() - dialog.getHeight();
                        top_to_bot = false;
                    } else {
                        x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                        y = fram.getY() + ((fram.getHeight() - dialog.getHeight()) / 2);
                        top_to_bot = true;
                    }
                    top = y;
                    dialog.setLocation(x, y);
                    dialog.setVisible(true);
                }
            }

            @Override
            public void end() {
                showing = !showing;
                if (showing) {
                    thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            sleep();
                            closeNotification();
                        }
                    });
                    thread.start();
                } else {
                    dialog.dispose();
                }
            }
        };
        animator = new Animator(500, target);
        animator.setResolution(5);
    }

    public void showNotification() {
        animator.start();
    }

    private void closeNotification() {
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
        if (animator.isRunning()) {
            if (!showing) {
                animator.stop();
                showing = true;
                animator.start();
            }
        } else {
            showing = true;
            animator.start();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.drawImage(imageShadow, 0, 0, null);
        int x = shadowSize;
        int y = shadowSize;
        int width = getWidth() - shadowSize * 2;
        int height = getHeight() - shadowSize * 2;
        g2.fillRect(x, y, width, height);
        if (type == Type.SUCCESS) {
            g2.setColor(new Color(18, 163, 24));
            line1.setBackground(new Color(170,237,166));
            line2.setBackground(new Color(210,239,211));
            line3.setBackground(new Color(210,239,211));
            pnl1.setBackground(new Color(106,144,95));
        } else if (type == Type.INFO) {
            g2.setColor(new Color(28, 139, 206));
            line1.setBackground(new Color(15,106,191));
            line2.setBackground(new Color(15,106,191));
            line3.setBackground(new Color(15,106,191));
            pnl1.setBackground(new Color(15,106,191));
            
        } else {
            g2.setColor(new Color(241, 196, 15));
            line1.setBackground(Color.WHITE);
            line2.setBackground(Color.WHITE);
        }
        g2.fillRect(6, 5, 5, getHeight() - shadowSize * 2 + 1);
        g2.dispose();
        super.paint(grphcs);
    }

    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3);
        createImageShadow();
    }

    private void createImageShadow() {
        imageShadow = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imageShadow.createGraphics();
        g2.drawImage(createShadow(), 0, 0, null);
        g2.dispose();
    }

    private BufferedImage createShadow() {
        BufferedImage img = new BufferedImage(getWidth() - shadowSize * 2, getHeight() - shadowSize * 2, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.fillRect(0, 0, img.getWidth(), img.getHeight());
        g2.dispose();
        return new ShadowRenderer(shadowSize, 0.3f, new Color(100, 100, 100)).createShadow(img);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new otherForms.PanelBorder();
        line2 = new javax.swing.JPanel();
        line1 = new otherForms.PanelBorder();
        lbMessage = new javax.swing.JLabel();
        line3 = new otherForms.PanelBorder();
        lbIcon = new javax.swing.JLabel();
        lbMessageText = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(450, 100));

        pnl1.setBackground(new java.awt.Color(106, 144, 95));
        pnl1.setPreferredSize(new java.awt.Dimension(450, 100));
        pnl1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        line2.setBackground(new java.awt.Color(210, 239, 211));

        javax.swing.GroupLayout line2Layout = new javax.swing.GroupLayout(line2);
        line2.setLayout(line2Layout);
        line2Layout.setHorizontalGroup(
            line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );
        line2Layout.setVerticalGroup(
            line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        pnl1.add(line2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 42, 448, 15));

        line1.setBackground(new java.awt.Color(170, 237, 166));

        lbMessage.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(0, 0, 0));
        lbMessage.setText("Message");

        javax.swing.GroupLayout line1Layout = new javax.swing.GroupLayout(line1);
        line1.setLayout(line1Layout);
        line1Layout.setHorizontalGroup(
            line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(line1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        line1Layout.setVerticalGroup(
            line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(line1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl1.add(line1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 448, -1));

        line3.setBackground(new java.awt.Color(210, 239, 211));

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sucess.png"))); // NOI18N

        lbMessageText.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbMessageText.setText("jLabel2");

        javax.swing.GroupLayout line3Layout = new javax.swing.GroupLayout(line3);
        line3.setLayout(line3Layout);
        line3Layout.setHorizontalGroup(
            line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(line3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbMessageText)
                .addContainerGap(345, Short.MAX_VALUE))
        );
        line3Layout.setVerticalGroup(
            line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(line3Layout.createSequentialGroup()
                .addGroup(line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(line3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbIcon))
                    .addGroup(line3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbMessageText)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pnl1.add(line3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 50, 448, 49));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        closeNotification();
    }//GEN-LAST:event_cmdCloseActionPerformed

    public static enum Type {
        SUCCESS, INFO, WARNING
    }

    public static enum Location {
        TOP_CENTER, TOP_RIGHT, TOP_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT, BOTTOM_LEFT, CENTER
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbMessageText;
    private otherForms.PanelBorder line1;
    private javax.swing.JPanel line2;
    private otherForms.PanelBorder line3;
    private otherForms.PanelBorder pnl1;
    // End of variables declaration//GEN-END:variables
}
