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

        Beverages testBeverages = new Beverages("NABev1");
        beveragesRepo.save(testBeverages);
        Place testPlace = new Place("name", 0.00, 0.00);
        placeRepo.save(testPlace);
        Details testDetails = new Details(testPlace,"streetAddress", "cityAddress", "phone", "hours", "distance","ETA", "website", "picture", testBeverages);
        detailsRepo.save(testDetails);

        flushAndClear();
        Place retrievedPlace = placeRepo.findById(testPlace.getId()).get();
        assertThat(retrievedPlace).isEqualTo(testPlace);
    }

}
