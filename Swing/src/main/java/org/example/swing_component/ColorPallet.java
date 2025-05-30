package org.example.swing_component;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.util.EventObject;

public class ColorPallet extends AbstractCellEditor implements TableCellEditor
{

    private JColorChooser colorChooser;
    private JDialog colorDialog;
    private JPanel panel;

    public ColorPallet()
    {
        this.panel = new JPanel();
        this.colorChooser = new JColorChooser();
        this.colorDialog = JColorChooser.createDialog(null, "Wybierz swój kolor :)", false, this.colorChooser,
                EventHandler.create(ActionListener.class, this, "stopCellEditing"),
                EventHandler.create(ActionListener.class, this, "cancelCellEditing"));
    }

    //We allow the user to choose the color
    @Override
    public Object getCellEditorValue()
    {
        return this.colorChooser.getColor();
    }

    //We should always allow the user to change the cell if we want to add color pallet for it
    @Override
    public boolean isCellEditable(EventObject e) {
        return true;
    }

    //Here we start to edit the cell - we have to open up the dialog
    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        this.colorDialog.setVisible(true);
        return true;
    }

    //For both we should hide the dialog
    @Override
    public void cancelCellEditing() {
        this.colorDialog.setVisible(false);
        super.cancelCellEditing();
    }

    @Override
    public boolean stopCellEditing() {
        this.colorDialog.setVisible(false);
        super.stopCellEditing();
        return true; //We will save the value the user choose
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.colorChooser.setColor((Color) value);
        return this.panel;
    }
}
