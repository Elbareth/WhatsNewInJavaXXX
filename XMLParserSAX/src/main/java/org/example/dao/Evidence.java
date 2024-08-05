package org.example.dao;

import java.util.Objects;

public class Evidence {
    private String value;

    public Evidence() {
    }

    public Evidence(String value) {
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
        Evidence evidence = (Evidence) o;
        return Objects.equals(value, evidence.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Evidence{" +
                "value='" + value + '\'' +
                '}';
    }
}
