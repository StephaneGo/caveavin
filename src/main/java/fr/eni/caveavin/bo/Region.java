package fr.eni.caveavin.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor
@Document("regions")
public class Region {
    @Id
    private String id;
    @NonNull private String nom;
}
