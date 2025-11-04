package fr.eni.caveavin.dal;

import com.mongodb.DuplicateKeyException;
import fr.eni.caveavin.bo.Bouteille;
import fr.eni.caveavin.bo.Couleur;
import fr.eni.caveavin.bo.Region;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest()
public class BouteillesRepositoryTest {
    @Autowired
    private BouteillesRepository bouteillesRepository;

    @Test
    @DisplayName("test d'ajout d'une bouteille dont le nom est déjà présent en base")
    void testAjoutBouteilleCasNomBouteilleDejaExistante(){
        //Arrange
        bouteillesRepository.deleteAll();
        Bouteille bouteille = new Bouteille("Laurent Perrier",
                2020);
        bouteillesRepository.save(bouteille);
        Bouteille bouteille2 = new Bouteille("Laurent Perrier", 2020);

        //Act
        try{
            bouteillesRepository.save(bouteille2);
            fail();
        }catch(DuplicateKeyException e){

        }

        //Assert

    }


    @Test
    void testAjoutBouteilleCasOk(){
        //Arrange
        bouteillesRepository.deleteAll();
        Bouteille bouteille = new Bouteille("Château Cheval Blanc",
                2015);
        bouteille.setRegion(new Region("Bordeaux"));
        bouteille.setCouleur(new Couleur("Rouge"));

        //Act
        Bouteille newBouteille = bouteillesRepository.save(bouteille);
        //Assert
        Optional<Bouteille> optBouteille = bouteillesRepository.findById(newBouteille.getId());
        assertTrue(optBouteille.isPresent());
        assertNotNull(optBouteille.get().getRegion());
        assertEquals(newBouteille.getRegion(), optBouteille.get().getRegion());

    }


}
