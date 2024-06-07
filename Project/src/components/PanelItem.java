
package components;

import java.awt.Color;
import javax.swing.JPanel;
import settings.WrapLayout;


public class PanelItem extends JPanel {
    public PanelItem(){
     setBackground(Color.WHITE);
     setLayout(new WrapLayout(WrapLayout.LEFT, 10, 10));
    }
}
