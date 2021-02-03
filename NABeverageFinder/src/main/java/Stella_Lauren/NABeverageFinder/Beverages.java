package Stella_Lauren.NABeverageFinder;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

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
