package org.example.entity;

import java.util.Objects;

public class Fine implements XMLElement{
    private String value;

    public Fine(String value) {
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
        Fine fine = (Fine) o;
        return Objects.equals(value, fine.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "\t" + "Fine{" + "\n" +
                "\t" + "value='" + value + '\'' + "\n" +
                '}';
    }
}
