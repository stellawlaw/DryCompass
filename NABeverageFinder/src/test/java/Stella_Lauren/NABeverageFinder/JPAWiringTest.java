package Stella_Lauren.NABeverageFinder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

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
        Beverages testBeverages = new Beverages("NABev1", "NABev2", "NABev3");
        beveragesRepo.save(testBeverages);
        Details testDetails = new Details("streetAddress", "cityAddress", "phone", "hours", "distance","ETA", "website", "picture");
        detailsRepo.save(testDetails);
        Place testPlace = new Place("name", 0.00, 0.00, testDetails, testBeverages);
        placeRepo.save(testPlace);
        flushAndClear();
        Place retrievedPlace = placeRepo.findById(testPlace.getId()).get();
        assertThat(retrievedPlace).isEqualTo(testPlace);
    }

}
