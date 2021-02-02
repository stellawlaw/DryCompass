package Stella_Lauren.NABeverageFinder;

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

}
