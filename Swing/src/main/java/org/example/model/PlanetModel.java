package org.example.model;

import org.example.PlanetDTO;
import org.example.enums.ColorEnum;
import org.example.enums.ColumnEnum;

import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Scanner;

public class PlanetModel extends AbstractTableModel {

    private java.util.List<PlanetDTO> planetDTOList = null;
    private java.util.List<String> column;

    public PlanetModel()
    {
        this.planetDTOList = new java.util.ArrayList<>();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("planet.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(fileInputStream);
        int counter = 0;
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            if(counter == 0) column = List.of(line.split(";"));
            else
            {
                String[] columns = line.split(";");
                PlanetDTO planetDTO = new PlanetDTO(columns[0], Double.parseDouble(columns[1]), Integer.parseInt(columns[2]), Boolean.parseBoolean(columns[3]), ColorEnum.getColor(columns[4]));
                this.planetDTOList.add(planetDTO);
            }
            counter++;
        }
    }

    @Override
    public int getRowCount() {
        return this.planetDTOList.size();
    }

    @Override
    public int getColumnCount() {
        return this.column.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PlanetDTO planetDTO = this.planetDTOList.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> planetDTO.getName();
            case 1 -> planetDTO.getSize();
            case 2 -> planetDTO.getMoonAmount();
            case 3 -> planetDTO.getGasPlanet();
            case 4 -> planetDTO.getColor();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int index) {
        return this.column.get(index);
    }
}
