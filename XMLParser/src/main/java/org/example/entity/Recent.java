package org.example.entity;

import java.util.Objects;

public class Recent implements XMLElement{
    private String attr;
    private Double value;

    public Recent(String attr, Double value) {
        this.attr = attr;
        this.value = value;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recent recent = (Recent) o;
        return Objects.equals(attr, recent.attr) && Objects.equals(value, recent.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attr, value);
    }

    @Override
    public String toString() {
        return "\t\t" + "Recent{" + "\n" +
                "\t\t" +"attr='" + attr + '\'' + ",\n" +
                "\t\t" +"value=" + value + "\n" +
                "\t\t" +'}';
    }
}
