package org.example.dao;

import java.util.Objects;

public class
Yard {
    private String value;
    private String attr;

    public Yard(String value, String attr) {
        this.value = value;
        this.attr = attr;
    }

    public Yard(String attr) {
        this.attr = attr;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Yard yard = (Yard) o;
        return Objects.equals(value, yard.value) && Objects.equals(attr, yard.attr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, attr);
    }

    @Override
    public String toString() {
        return "Yard{" +
                "value='" + value + '\'' +
                ", attr='" + attr + '\'' +
                '}';
    }
}
