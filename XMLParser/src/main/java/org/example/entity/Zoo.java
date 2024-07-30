package org.example.entity;

import java.util.Objects;

public class Zoo implements XMLElement{
    private Long value;

    public Zoo(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zoo zoo = (Zoo) o;
        return Objects.equals(value, zoo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "\t\t\t" +"Zoo{" + "\n" +
                "\t\t\t" +"value=" + value + "\n" +
                "\t\t\t" +'}';
    }
}
