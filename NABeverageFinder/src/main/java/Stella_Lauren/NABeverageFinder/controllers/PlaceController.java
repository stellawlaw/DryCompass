package Stella_Lauren.NABeverageFinder.controllers;

import Stella_Lauren.NABeverageFinder.resources.Place;
import Stella_Lauren.NABeverageFinder.storage.DetailsRepository;
import Stella_Lauren.NABeverageFinder.storage.PlaceStorage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceController {
    private PlaceStorage placeStorage;
    private DetailsRepository detailsRepo;

    public PlaceController(PlaceStorage placeStorage, DetailsRepository detailsRepo) {
        this.placeStorage = placeStorage;
        this.detailsRepo = detailsRepo;
    }

    @GetMapping("/api/places")
    public Iterable<Place> retrieveAllPlaces(){
        return placeStorage.retrieveAllPlaces();
    }

    @GetMapping("/api/places/{id}")
    public Place retrievePlaceById(@PathVariable Long id){
        return placeStorage.retrievePlaceById(id);
    }

    @GetMapping("/api/bars")
    public Iterable<Place> retrieveAllBars(){
        return placeStorage.retrieveAllBars();
    }

    @GetMapping("/api/restaurants")
    public Iterable<Place> retrieveAllRestaurants(){
        return placeStorage.retrieveAllRestaurants();
    }

    @GetMapping("/api/breweries")
    public Iterable<Place> retrieveAllBreweries(){
        return placeStorage.retrieveAllBreweries();
    }





}
