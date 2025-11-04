package fr.eni.caveavin.dal;

import fr.eni.caveavin.bo.Bouteille;
import fr.eni.caveavin.bo.Region;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegionsRepository
        extends MongoRepository<Region,String> {

}
