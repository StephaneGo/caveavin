package fr.eni.caveavin.bo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Document("bouteilles")
public class Bouteille {
    @Id
    private String id;

    @NonNull private  String nom;
    @NonNull  private Integer millesime;

}
