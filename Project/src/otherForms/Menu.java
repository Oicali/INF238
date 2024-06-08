package otherForms;

import interfaces.EventMenuSelected;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import settings.Model_Menu;
import Main.*;

public class Menu extends javax.swing.JPanel {

    public EventMenuSelected event;

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }

    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }

    private void init() {

        if (Main.userPosition.equalsIgnoreCase("Administrator")) {
            listMenu1.addItem(new Model_Menu("1", "Dashboard", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("2", "Categories", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("3", "Products", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("4", "Order", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("5", "View Order", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("6", "Customers", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("7", "Users", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("8", "My Profile", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("9", "Log Out", Model_Menu.MenuType.MENU));

        } else if (Main.userPosition.equalsIgnoreCase("Supervisor")) {
            listMenu1.addItem(new Model_Menu("1", "Dashboard", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("2", "Categories", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("3", "Products", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("4", "Order", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("5", "View Order", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("6", "Customers", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("8", "My Profile", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("9", "Log Out", Model_Menu.MenuType.MENU));

        } else if (Main.userPosition.equalsIgnoreCase("Sales Associate")) {
            listMenu1.addItem(new Model_Menu("1", "Dashboard", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("4", "Order", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("5", "View Order", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("6", "Customers", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("8", "My Profile", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("9", "Log Out", Model_Menu.MenuType.MENU));
            
        } else if (Main.userPosition.equalsIgnoreCase("Warehouse Staff")) {
            listMenu1.addItem(new Model_Menu("1", "Dashboard", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("2", "Categories", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("3", "Products", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("5", "View Order", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("8", "My Profile", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
            listMenu1.addItem(new Model_Menu("9", "Log Out", Model_Menu.MenuType.MENU));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        listMenu1 = new settings.ListMenu<>();

        setPreferredSize(new java.awt.Dimension(250, 700));

        PanelMoving.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mark-It!");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logoSmall.png"))); // NOI18N

        javax.swing.GroupLayout PanelMovingLayout = new javax.swing.GroupLayout(PanelMoving);
        PanelMoving.setLayout(PanelMovingLayout);
        PanelMovingLayout.setHorizontalGroup(
            PanelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMovingLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(PanelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMovingLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMovingLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(86, 86, 86))))
        );
        PanelMovingLayout.setVerticalGroup(
            PanelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMovingLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Designs the Menu bar
    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#187CD9"), 0, getHeight(), Color.decode("#284866"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

    private int x, y;

    public void initMoving(JFrame f) {
        PanelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }
        });
        PanelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                f.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelMoving;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private settings.ListMenu<String> listMenu1;
    // End of variables declaration//GEN-END:variables
}
