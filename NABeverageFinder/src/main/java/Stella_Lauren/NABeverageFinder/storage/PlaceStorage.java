package Stella_Lauren.NABeverageFinder.storage;

import Stella_Lauren.NABeverageFinder.resources.Place;
import Stella_Lauren.NABeverageFinder.storage.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceStorage {
    protected PlaceRepository placeRepo;

    public PlaceStorage(PlaceRepository placeRepo) {
        this.placeRepo = placeRepo;
    }

    public Place retrievePlaceById(Long id){
        return placeRepo.findById(id).get();
    }

    public void savePlace (Place placeToSave) {
        placeRepo.save(placeToSave);}

    public Iterable<Place> retrieveAllPlaces() {
        return placeRepo.findAll();
    }

    public Iterable<Place> retrieveAllBars() {
        Iterable<Place> allPlaces = placeRepo.findAll();
        List<Place> bars = new ArrayList<Place>();
        for(Place place: allPlaces){
            if(place.getType() == "bar"){
                bars.add(place);
            }
        }
        return bars;
    }

    public Iterable<Place> retrieveAllRestaurants() {
        Iterable<Place> allPlaces = placeRepo.findAll();
        List<Place> restaurants = new ArrayList<Place>();
        for(Place place: allPlaces){
            if(place.getType() == "restaurant"){
                restaurants.add(place);
            }
        }
        return restaurants;
    }

    public Iterable<Place> retrieveAllBreweries() {
        Iterable<Place> allPlaces = placeRepo.findAll();
        List<Place> breweries = new ArrayList<Place>();
        for(Place place: allPlaces){
            if(place.getType() == "brewery"){
                breweries.add(place);
            }
        }
        return breweries;
    }
}
