package Stella_Lauren.NABeverageFinder.storage;

import Stella_Lauren.NABeverageFinder.resources.Beverages;
import org.springframework.data.repository.CrudRepository;

public interface BeveragesRepository extends CrudRepository<Beverages, Long> {
}
