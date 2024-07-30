package org.example.entity;

import java.util.Objects;

public class Low implements XMLElement{
    private Long value;

    public Low(Long value) {
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
        Low low = (Low) o;
        return Objects.equals(value, low.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "\t\t\t" +"Low{" + "\n" +
                "\t\t\t" +"value=" + value + "\n" +
                "\t\t\t" +'}';
    }
}
