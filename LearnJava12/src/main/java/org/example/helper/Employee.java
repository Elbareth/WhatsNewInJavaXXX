package org.example.helper;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
    private String name;
    private String team;
    private Language language;

    public Employee(String name, String team, Language language) {
        this.name = name;
        this.team = team;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(team, employee.team) && Objects.equals(language, employee.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, team, language);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", language=" + language +
                '}';
    }
}
