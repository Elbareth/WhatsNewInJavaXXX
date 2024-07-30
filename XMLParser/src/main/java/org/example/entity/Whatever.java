package org.example.entity;

import java.util.Objects;

public class Whatever implements XMLElement{
    private String attr;
    private String value;

    public Whatever(String attr, String value) {
        this.attr = attr;
        this.value = value;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Whatever whatever = (Whatever) o;
        return Objects.equals(attr, whatever.attr) && Objects.equals(value, whatever.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attr, value);
    }

    @Override
    public String toString() {
        return "\t" + "Whatever{" + "\n" +
                "\t" + "attr='" + attr + '\'' + ",\n" +
                "\t" + "value='" + value + '\'' + "\n" +
                '}';
    }
}
