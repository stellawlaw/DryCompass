package Stella_Lauren.NABeverageFinder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Place {
    private String name;
    private double longCoords;
    private double latCoords;
    protected Details details;
    protected Beverages beverages;
    @Id
    @GeneratedValue
    private Long id;

    protected Place(){}

    public Place(String name, double longCoords, double latCoords, Details details, Beverages beverages) {
        this.name = name;
        this.longCoords = longCoords;
        this.latCoords = latCoords;
        this.details = details;
        this.beverages = beverages;
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
}
