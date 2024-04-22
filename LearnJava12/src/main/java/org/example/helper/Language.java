package org.example.helper;

import java.io.Serializable;
import java.util.Objects;

public class Language implements Serializable {
    private String name;
    private Integer level;

    public Language(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Objects.equals(name, language.name) && Objects.equals(level, language.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level);
    }

    @Override
    public String toString() {
        return "Language{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
