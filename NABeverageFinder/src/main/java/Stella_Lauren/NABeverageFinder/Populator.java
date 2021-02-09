package Stella_Lauren.NABeverageFinder;

import Stella_Lauren.NABeverageFinder.resources.Beverages;
import Stella_Lauren.NABeverageFinder.resources.Details;
import Stella_Lauren.NABeverageFinder.resources.Place;
import Stella_Lauren.NABeverageFinder.storage.BeveragesRepository;
import Stella_Lauren.NABeverageFinder.storage.DetailsRepository;
import Stella_Lauren.NABeverageFinder.storage.PlaceStorage;
import org.springframework.stereotype.Component;

@Component
public class Populator {

    private PlaceStorage placeStorage;
    private BeveragesRepository beveragesRepo;
    private DetailsRepository detailsRepo;

    public Populator(PlaceStorage placeStorage, BeveragesRepository beveragesRepo, DetailsRepository detailsRepo) {
        this.placeStorage = placeStorage;
        this.beveragesRepo = beveragesRepo;
        this.detailsRepo = detailsRepo;
    }

    
    public void run(String... args) throws Exception{

        Place brewDogSN = new Place("BrewDog Short North", "Brewery", 22.22, 22.22);
        Beverages brewDogBevs1 = new Beverages("Hazy AF");
        Beverages brewDogBevs2 = new Beverages("Nanny State");
        Details brewDogSNDetails = new Details(brewDogSN, "1175 North High Street", "Columbus, Ohio 43201", "614-908-3053", "Monday-Sunday 11AM - 9PM", 19.2, 24, "https://www.brewdog.com/usa/locations/brewery/columbus","./NABeerFinder/brewdog.jpg", brewDogBevs1, brewDogBevs2);

        Place lincolnSocial = new Place("Lincoln Social Rooftop", "Bar", 22.22, 22.22);
        Beverages lincolnSocialBevs1 = new Beverages("Fresh Ginger Soda");
        Beverages lincolnSocialBevs2 = new Beverages("Cucumber Lemonade");
        Beverages lincolnSocialBevs3 = new Beverages("Strawberry Almond Limeade");
        Beverages lincolnSocialBevs4 = new Beverages("Herbal Activity");
        Beverages lincolnSocialBevs5 = new Beverages("Bartender Roulette");
        Details lincolnSocialDetails = new Details(lincolnSocial, "711 North High Street 9th Floor", "Columbus, Ohio 43215", "614-300-9494", "Wednesday-Thursday 4-10PM || Friday 4-11PM || Saturday 3-11PM || Sunday 3-9PM ", 19.2, 24, "https://lincolnsocialrooftop.com/","./NABeerFinder/brewdog.jpg", lincolnSocialBevs1, lincolnSocialBevs2, lincolnSocialBevs3, lincolnSocialBevs4, lincolnSocialBevs5);

        Place guildhouse = new Place("The Guild House", "Restaurant", 22.22, 22.22);
        Beverages guildHouseBevs1 = new Beverages("Lemon Tonic");
        Beverages guildHouseBevs2 = new Beverages("Cherry Ginger");
        Details guildHouseDetails = new Details(guildhouse, "624 North High Street", "Columbus, Ohio 43215", "614-280-9780", "Wednesday-Thursday 4-9PM || Friday-Saturday 4-10PM || Sunday 4-8PM", 19.2, 24, "https://theguildhousecolumbus.com/","./NABeerFinder/brewdog.jpg", guildHouseBevs1, guildHouseBevs2);


    }
}
