package org.example.dao;

import java.util.Objects;

public class Come {
    private String value;

    public Come() {
    }

    public Come(String value) {
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
        Come come = (Come) o;
        return Objects.equals(value, come.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Come{" +
                "value='" + value + '\'' +
                '}';
    }
}
