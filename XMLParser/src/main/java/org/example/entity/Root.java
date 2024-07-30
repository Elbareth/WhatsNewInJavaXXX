package org.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Root implements XMLElement{
    private final List<Deer> deers;
    private final List<Whatever> whatevers;
    private final List<Fine> fines;

    public Root() {
        this.deers = new ArrayList<>();
        this.whatevers = new ArrayList<>();
        this.fines = new ArrayList<>();
    }

    public List<Deer> getDeers() {
        return deers;
    }

    public void addDeers(Deer deer) {
        this.deers.add(deer);
    }

    public List<Whatever> getWhatevers() {
        return whatevers;
    }

    public void addWhatevers(Whatever whatever) {
        this.whatevers.add(whatever);
    }

    public List<Fine> getFines() {
        return fines;
    }

    public void addFines(Fine fine) {
        this.fines.add(fine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Root root = (Root) o;
        return Objects.equals(deers, root.deers) && Objects.equals(whatevers, root.whatevers) && Objects.equals(fines, root.fines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deers, whatevers, fines);
    }

    @Override
    public String toString() {
        return "Root{" + "\n" +
                deers + ",\n" +
                whatevers + ",\n" +
                fines + "\n" +
                '}';
    }
}
