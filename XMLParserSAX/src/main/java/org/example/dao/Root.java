package org.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Root {
    private List<Bottom> bottoms;
    private List<Yard> yards;

    public Root() {
        this.bottoms = new ArrayList<>();
        this.yards = new ArrayList<>();
    }

    public List<Bottom> getBottoms() {
        return bottoms;
    }

    public List<Yard> getYards() {
        return yards;
    }
    public void addBottoms(Bottom bottom)
    {
        this.bottoms.add(bottom);
    }
    public void addYards(Yard yard)
    {
        this.yards.add(yard);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Root root = (Root) o;
        return Objects.equals(bottoms, root.bottoms) && Objects.equals(yards, root.yards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bottoms, yards);
    }

    @Override
    public String toString() {
        return "Root{" +
                "bottoms=" + bottoms +
                ", yards=" + yards +
                '}';
    }
}
