package org.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Deer implements XMLElement{
    private List<Recent> recents;
    private List<Highway> highways;
    private List<Pipe> pipes;

    public Deer() {
        this.recents = new ArrayList<>();
        this.highways = new ArrayList<>();
        this.pipes = new ArrayList<>();
    }

    public List<Recent> getRecents() {
        return recents;
    }

    public void addRecents(Recent recent) {
        this.recents.add(recent);
    }

    public List<Highway> getHighways() {
        return highways;
    }

    public void addHighways(Highway highway) {
        this.highways.add(highway);
    }

    public List<Pipe> getPipes() {
        return pipes;
    }

    public void addPipes(Pipe pipe) {
        this.pipes.add(pipe);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deer deer = (Deer) o;
        return Objects.equals(recents, deer.recents) && Objects.equals(highways, deer.highways) && Objects.equals(pipes, deer.pipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recents, highways, pipes);
    }

    @Override
    public String toString() {
        return "\t" + "Deer{" + "\n" +
                "\t" + recents + ",\n" +
                "\t" + highways + ",\n" +
                "\t" + pipes + "\n" +
                "\t" + '}';
    }
}
