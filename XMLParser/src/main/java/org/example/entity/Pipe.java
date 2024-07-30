package org.example.entity;

import java.util.Objects;

public class Pipe implements XMLElement{
    private String value;

    public Pipe(String value) {
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
        Pipe pipe = (Pipe) o;
        return Objects.equals(value, pipe.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "\t\t" +"Pipe{" + "\n" +
                "\t\t" +"value='" + value + '\'' + "\n" +
                "\t\t" +'}';
    }
}
