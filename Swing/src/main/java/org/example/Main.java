package org.example;

import org.example.swing_component.MyTable;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args)
    {
        Object[][] content = {
                {"Merkury", 2440.0, 0, false, Color.YELLOW},
                {"Wenus", 6052.0, 0, false, Color.ORANGE},
                {"Ziemia", 6378.0, 1, false, Color.BLUE},
                {"Mars", 3397.0, 2, false, Color.RED},
                {"Jowisz", 71492.0, 16, true, Color.ORANGE},
                {"Saturn", 60268.0, 18, true, Color.ORANGE},
                {"Uran", 25559.0, 17, true, Color.CYAN},
                {"Neptun", 24766.0, 8, true, Color.BLUE},
        };
        Object[] columns = {"Nazwa", "Promień", "Liczba księżyców", "Czy planeta jest gazowa", "Kolor"};
        MyTable myTable = new MyTable();
        myTable.setTitle("Platetki");
        myTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //myTable.draw(content,columns);
        myTable.draw();
        myTable.setVisible(true);
    }
}