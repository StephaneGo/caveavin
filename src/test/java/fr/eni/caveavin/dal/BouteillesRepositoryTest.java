package fr.eni.caveavin.dal;

import fr.eni.caveavin.bo.Bouteille;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest()
public class BouteillesRepositoryTest {
    @Autowired
    private BouteillesRepository bouteillesRepository;

    @Test
    void testAjoutBouteilleCasOk(){
        //Arrange
        Bouteille bouteille = new Bouteille("Château Cheval Blanc",
                2015);

        //Act
        Bouteille newBouteille = bouteillesRepository.save(bouteille);

        //Assert
        Optional<Bouteille> optBouteille = bouteillesRepository.findById(newBouteille.getId());
        assertTrue(optBouteille.isPresent());

    }


}
