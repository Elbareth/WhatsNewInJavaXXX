package org.example.swing_component;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ColorTableCellRender extends JPanel implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setBackground((Color) value);
        /*if(hasFocus) setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
        else setBorder(null);*/
        return this;
    }
}
