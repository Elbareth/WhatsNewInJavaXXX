package org.example.dao;

import java.util.Objects;

public class Bottom {
    private Come come;
    private Evidence evidence;

    public Bottom() {
    }

    public Bottom(Come come, Evidence evidence) {
        this.come = come;
        this.evidence = evidence;
    }

    public Come getCome() {
        return come;
    }

    public void setCome(Come come) {
        this.come = come;
    }

    public Evidence getEvidence() {
        return evidence;
    }

    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bottom bottom = (Bottom) o;
        return Objects.equals(come, bottom.come) && Objects.equals(evidence, bottom.evidence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(come, evidence);
    }

    @Override
    public String toString() {
        return "Bottom{" +
                "come=" + come +
                ", evidence=" + evidence +
                '}';
    }
}
