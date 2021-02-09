package Stella_Lauren.NABeverageFinder;

import Stella_Lauren.NABeverageFinder.resources.Beverages;
import Stella_Lauren.NABeverageFinder.resources.Details;
import Stella_Lauren.NABeverageFinder.resources.Place;
import Stella_Lauren.NABeverageFinder.storage.BeveragesRepository;
import Stella_Lauren.NABeverageFinder.storage.DetailsRepository;
import Stella_Lauren.NABeverageFinder.storage.PlaceRepository;
import Stella_Lauren.NABeverageFinder.storage.PlaceStorage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    private BeveragesRepository beveragesRepo;
    @Autowired
    private DetailsRepository detailsRepo;
    @Autowired
    private PlaceRepository placeRepo;
    @Autowired
    private TestEntityManager entityManager;


    private void flushAndClear(){
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    public void placeObjectShouldHaveADetailsObjectAndABeveragesObject(){
        Beverages testBeverages = new Beverages("NABev1");
        beveragesRepo.save(testBeverages);
        Place testPlace = new Place("name", "bar", 0.00, 0.00 );
        placeRepo.save(testPlace);
        Details testDetails = new Details(testPlace,"streetAddress", "cityAddress", "phone", "hours", "distance","ETA", "website", "picture", testBeverages);
        detailsRepo.save(testDetails);
        flushAndClear();
        Place retrievedPlace = placeRepo.findById(testPlace.getId()).get();
        assertThat(retrievedPlace).isEqualTo(testPlace);
    }

    @Test
    public void shouldRetrieveAllBars(){
        Place testPlace1 = new Place("", "bar", 22.22, 22.22);
        Place testPlace2 = new Place("", "brewery", 22.22, 22.22);
        placeRepo.save(testPlace1);
        placeRepo.save(testPlace2);
        flushAndClear();
        Iterable<Place> allPlaces = placeRepo.findAll();
        List<Place> bars = new ArrayList<Place>();
        for(Place place: allPlaces){
            if(place.getType() == "bar"){
                bars.add(place);
            }
        }
        assertThat(bars).contains(testPlace1);
        assertThat(bars).doesNotContain(testPlace2);

    }
}
