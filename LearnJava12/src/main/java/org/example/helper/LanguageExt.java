package org.example.helper;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Objects;

public class LanguageExt implements Externalizable {
    private String name;
    private Integer level;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
        out.writeInt(this.level);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.level = in.readInt();
    }

    public LanguageExt(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    public LanguageExt() {
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
        LanguageExt that = (LanguageExt) o;
        return Objects.equals(name, that.name) && Objects.equals(level, that.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level);
    }

    @Override
    public String toString() {
        return "LanguageExt{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
