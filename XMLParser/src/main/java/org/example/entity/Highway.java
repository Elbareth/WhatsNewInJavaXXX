package org.example.entity;

import java.util.Objects;

public class Highway implements XMLElement{
    private Gas gas;
    private Low low;
    private Zoo zoo;

    public Highway(Gas gas, Low low, Zoo zoo) {
        this.gas = gas;
        this.low = low;
        this.zoo = zoo;
    }
    public Highway()
    {
        this.gas = null;
        this.low = null;
        this.zoo = null;
    }

    public Gas getGas() {
        return gas;
    }

    public void setGas(Gas gas) {
        this.gas = gas;
    }

    public Low getLow() {
        return low;
    }

    public void setLow(Low low) {
        this.low = low;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Highway highway = (Highway) o;
        return Objects.equals(gas, highway.gas) && Objects.equals(low, highway.low) && Objects.equals(zoo, highway.zoo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gas, low, zoo);
    }

    @Override
    public String toString() {
        return "\t\t" +"Highway{" + "\n" +
                "\t\t" +gas + ",\n" +
                "\t\t" +low + ",\n" +
                "\t\t" +zoo + "\n" +
                "\t\t" +'}';
    }
}
