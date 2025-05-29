package org.example.enums;

import java.awt.*;

public enum ColorEnum
{
    YELLOW,
    ORANGE,
    BLUE,
    CYAN,
    RED;
    public static Color getColor(String name)
    {
        if(name.equals(YELLOW.name())) return Color.YELLOW;
        if(name.equals(ORANGE.name())) return Color.ORANGE;
        if(name.equals(BLUE.name())) return Color.BLUE;
        if(name.equals(CYAN.name())) return Color.CYAN;
        if(name.equals(RED.name())) return Color.RED;
        return Color.BLACK;
    }
}
