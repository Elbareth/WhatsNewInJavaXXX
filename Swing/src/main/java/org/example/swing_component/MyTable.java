package org.example.swing_component;

import org.example.enums.ColumnEnum;
import org.example.model.PlanetModel;

import javax.swing.*;
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
        TableRowSorter<PlanetModel> sorter = new TableRowSorter<>(planetModel);
        table.setRowSorter(sorter);
        sorter.setComparator(ColumnEnum.SIZE.getIndex(), (Comparator<Double>) Double::compareTo);
        sorter.setComparator(ColumnEnum.MOON_AMOUNT.getIndex(), (Comparator<Integer>) Integer::compareTo);
        pack();
    }
}
