
package settings;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ModernHeaderRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setFont(new Font("SansSerif", Font.BOLD, 18)); // Set font to Bold 16
        c.setBackground(new Color(40,72,134));
        c.setForeground(Color.WHITE);
        ((JComponent) c).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0)); // Remove cell border
        return c;
    }
}


