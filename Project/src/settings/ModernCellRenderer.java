
package settings;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ModernCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (isSelected) {
            c.setBackground(new Color(24,124,217));
            c.setForeground(Color.WHITE);
        } else {
            c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 240));
            c.setForeground(Color.BLACK);
        }

        if (c instanceof JComponent) {
            ((JComponent) c).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Remove cell border
        }

        return c;
    }
}

