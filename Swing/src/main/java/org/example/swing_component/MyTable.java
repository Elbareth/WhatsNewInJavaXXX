package org.example.swing_component;

import org.example.enums.ColumnEnum;
import org.example.model.PlanetModel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.print.PrinterException;
import java.util.Comparator;

public class MyTable extends JFrame
{
    public void draw(Object[][] content, Object[] column)
    {
        JTable table = new JTable(content, column);
        //Thanks to it we are able to order the column ASC DESC
        table.setAutoCreateRowSorter(true);
        //We are able to scroll the results
        add(new JScrollPane(table), BorderLayout.CENTER);
        JButton button = new JButton("Drukuj");
        button.addActionListener(event -> {
            try {
                table.print();
            } catch (PrinterException e) {
                throw new RuntimeException(e);
            }
        });
        JPanel panel = new JPanel();
        panel.add(button);
        add(panel, BorderLayout.SOUTH);
        pack();
    }
    public void draw()
    {
        PlanetModel planetModel = new PlanetModel();
        JTable table = new JTable(planetModel);
        //Thanks to it we are able to order the column ASC DESC
        table.setAutoCreateRowSorter(true);
        //We are able to scroll the results
        add(new JScrollPane(table), BorderLayout.CENTER);
        JButton button = new JButton("Drukuj");
        button.addActionListener(event -> {
            try {
                table.print();
            } catch (PrinterException e) {
                throw new RuntimeException(e);
            }
        });
        JPanel panel = new JPanel();
        panel.add(button);
        add(panel, BorderLayout.SOUTH);

        //Sort the column
        //We have to declare, what table model we want to sort
        TableRowSorter<PlanetModel> sorter = new TableRowSorter<>(planetModel);
        //We have to inject the sorter into table
        table.setRowSorter(sorter);

        //We can declare any sorter we want for specific column
        sorter.setComparator(ColumnEnum.SIZE.getIndex(), (Comparator<Double>) Double::compareTo);
        sorter.setComparator(ColumnEnum.MOON_AMOUNT.getIndex(), (Comparator<Integer>) Integer::compareTo);
        sorter.setSortable(ColumnEnum.COLOR.getIndex(), false);//We disable sorting for specific column
        //We can create filer for specific column - right now we will filter planets that haven't any moon
        sorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.NOT_EQUAL, 0, ColumnEnum.MOON_AMOUNT.getIndex()));
        //We create a filter. We can filter names that end up with letter a
        sorter.setRowFilter(RowFilter.regexFilter(".*a$", ColumnEnum.NAME.getIndex()));
        //We can also create our own RowFilter
        var rowFilter = new RowFilter<PlanetModel, Integer>() {
            @Override
            public boolean include(Entry<? extends PlanetModel, ? extends Integer> entry) {
                //We want to filter even records
                return entry.getIdentifier()%2==0;
            }
        };
        sorter.setRowFilter(rowFilter);
        sorter.setRowFilter(null);
        //We can also hide the column from the table (without deleting it from table model!)
        TableColumnModel tableColumnModel = table.getColumnModel();
        TableColumn colorColumn = tableColumnModel.getColumn(ColumnEnum.COLOR.getIndex());
        table.removeColumn(colorColumn);
        //We can also show it again. The column will be added at the end of the table - moveColumn
        table.addColumn(colorColumn);
        //We can also change the way we render the column.
        table.getColumnModel().getColumn(ColumnEnum.COLOR.getIndex()).setCellRenderer(new ColorTableCellRender());
        //We can add our own call editor - this time it will be color pallet
        table.getColumnModel().getColumn(ColumnEnum.COLOR.getIndex()).setCellEditor(new ColorPallet());
        pack();
    }
}
