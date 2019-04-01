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
    @Column(name = "recipe_name", unique = true)
    private String recipeName;

    @NotNull
    @Column(name = "recipe_description")
    private String recipeDescription;

    @NotNull
    @Column(name = "recipe_ingredients")
    private String recipeIngredients;

    @Column(name = "recipe_image")
    private String recipeImage;

    protected Recipe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public String getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    public void setRecipeIngredients(String recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    @Override
    public String toString() {
        return String.format(
                "Recipe[id=%d, recipeName='%s', recipeDescription='%s', recipeIngredients='%s']",
                id, recipeName, recipeDescription, recipeIngredients);

    }
}