package ee.ttu.tarkvaratehnika.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "recipe_name")
    private String recipeName;

    @NotNull
    @Column(name = "recipe_description")
    private String recipeDescription;

    @NotNull
    @Column(name = "recipe_ingredients")
    private String recipeIngredients;

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeName='" + recipeName + '\'' +
                ", recipeDescription='" + recipeDescription + '\'' +
                ", recipeIngredients='" + recipeIngredients + '\'' +
                '}';
    }
}