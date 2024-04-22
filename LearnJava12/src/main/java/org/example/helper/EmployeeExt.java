package org.example.helper;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Objects;

//It allows me implement my own read/write object system
public class EmployeeExt implements Externalizable {
    private String name;
    private String team;
    private LanguageExt language;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
        out.writeUTF(this.team);
        out.writeObject(this.language);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.team = in.readUTF();
        this.language = (LanguageExt) in.readObject();
    }

    public EmployeeExt(String name, String team, LanguageExt language) {
        this.name = name;
        this.team = team;
        this.language = language;
    }

    public EmployeeExt() {
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

    public LanguageExt getLanguage() {
        return language;
    }

    public void setLanguage(LanguageExt language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeExt that = (EmployeeExt) o;
        return Objects.equals(name, that.name) && Objects.equals(team, that.team) && Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, team, language);
    }

    @Override
    public String toString() {
        return "EmployeeExt{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", language=" + language +
                '}';
    }
}
