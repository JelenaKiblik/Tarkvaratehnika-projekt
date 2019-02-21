package ee.ttu.tarkvaratehnika.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
    @SequenceGenerator(name = "seq1", sequenceName = "recipe_sequence", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "recipe_name")
    private String recipeName;


    @NotNull
    @Column(name = "recipe_description")
    private String recipeDescription;

    /*
    @Valid
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "ingredients",
            joinColumns = @JoinColumn(name = "recipe_id",
                    referencedColumnName = "id")
    )
    private List<Ingredient> ingredients;
    */

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeName='" + recipeName + '\'' +
                ", recipeDescription='" + recipeDescription + '\'' +
                '}';
    }
}