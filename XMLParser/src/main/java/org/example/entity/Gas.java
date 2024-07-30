package org.example.entity;

import java.util.Objects;

public class Gas implements XMLElement{
    private String value;

    public Gas(String value) {
        this.value = value;
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
        Gas gas = (Gas) o;
        return Objects.equals(value, gas.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "\t\t\t" +"Gas{" + "\n" +
                "\t\t\t" +"value='" + value + '\'' + "\n" +
                "\t\t\t" +'}';
    }
}
