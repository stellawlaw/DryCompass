package Stella_Lauren.NABeverageFinder.resources;

import javax.persistence.*;

@Entity
public class Beverages {

    private String name;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Details details;


    protected Beverages(){}

    public Beverages(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
