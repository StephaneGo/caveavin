package fr.eni.caveavin.dal;

import fr.eni.caveavin.bo.Bouteille;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BouteillesRepository extends MongoRepository<Bouteille,String> {
    void deleteByNom(String nom);
}
