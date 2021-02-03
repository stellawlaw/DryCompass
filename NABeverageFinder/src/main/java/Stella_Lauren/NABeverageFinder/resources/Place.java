package Stella_Lauren.NABeverageFinder.resources;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Place {
    private String name;
    private String type;
    private double longCoords;
    private double latCoords;

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Details details;

    protected Place(){}

    public Place(String name, String type, double longCoords, double latCoords) {
        this.name = name;
        this.type = type;
        this.longCoords = longCoords;
        this.latCoords = latCoords;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getLongCoords() {
        return longCoords;
    }

    public double getLatCoords() {
        return latCoords;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Double.compare(place.longCoords, longCoords) == 0 &&
                Double.compare(place.latCoords, latCoords) == 0 &&
                Objects.equals(name, place.name) &&
                Objects.equals(type, place.type) &&
                Objects.equals(id, place.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, longCoords, latCoords, id);
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", longCoords=" + longCoords +
                ", latCoords=" + latCoords +
                ", id=" + id +
                '}';
    }
}

