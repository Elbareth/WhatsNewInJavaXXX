package org.example;

import java.awt.*;
import java.util.Objects;

public class PlanetDTO
{
    private String name;
    private Double size;
    private Integer moonAmount;
    private Boolean isGasPlanet;
    private Color color;

    public PlanetDTO() {
    }

    public PlanetDTO(String name, Double size, Integer moonAmount, Boolean isGasPlanet, Color color) {
        this.name = name;
        this.size = size;
        this.moonAmount = moonAmount;
        this.isGasPlanet = isGasPlanet;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Integer getMoonAmount() {
        return moonAmount;
    }

    public void setMoonAmount(Integer moonAmount) {
        this.moonAmount = moonAmount;
    }

    public Boolean getGasPlanet() {
        return isGasPlanet;
    }

    public void setGasPlanet(Boolean gasPlanet) {
        isGasPlanet = gasPlanet;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetDTO planetDTO = (PlanetDTO) o;
        return Objects.equals(name, planetDTO.name) && Objects.equals(size, planetDTO.size) && Objects.equals(moonAmount, planetDTO.moonAmount) && Objects.equals(isGasPlanet, planetDTO.isGasPlanet) && Objects.equals(color, planetDTO.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, moonAmount, isGasPlanet, color);
    }

    @Override
    public String toString() {
        return "PlanetDTO{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", moonAmount=" + moonAmount +
                ", isGasPlanet=" + isGasPlanet +
                ", color=" + color +
                '}';
    }
}
