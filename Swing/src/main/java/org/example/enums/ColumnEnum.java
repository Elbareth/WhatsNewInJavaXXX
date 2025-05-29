package org.example.enums;

import java.awt.*;
import java.util.Arrays;

public enum ColumnEnum
{
    NAME("name", 0),
    SIZE("size", 1),
    MOON_AMOUNT("moonAmount", 2),
    IS_GAS_PLANET("isGasPlanet", 3),
    COLOR("color", 4);

    private String name;
    private Integer index;

    ColumnEnum(String name, Integer index)
    {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public Integer getIndex() {
        return index;
    }
}
