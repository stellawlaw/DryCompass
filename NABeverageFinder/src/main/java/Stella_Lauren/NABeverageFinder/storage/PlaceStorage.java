package Stella_Lauren.NABeverageFinder.storage;

import Stella_Lauren.NABeverageFinder.resources.Place;
import Stella_Lauren.NABeverageFinder.storage.PlaceRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaceStorage {
    private PlaceRepository placeRepo;

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


}
