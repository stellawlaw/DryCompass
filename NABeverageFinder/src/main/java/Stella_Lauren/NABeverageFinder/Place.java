package Stella_Lauren.NABeverageFinder;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Place {
    private String name;
    private double longCoords;
    private double latCoords;

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Details details;

    protected Place(){}

    public Place(String name, double longCoords, double latCoords) {
        this.name = name;
        this.longCoords = longCoords;
        this.latCoords = latCoords;

    }

    public String getName() {
        return name;
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
                Objects.equals(id, place.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, longCoords, latCoords, id);
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", longCoords=" + longCoords +
                ", latCoords=" + latCoords +
                ", id=" + id +
                '}';
    }
}

