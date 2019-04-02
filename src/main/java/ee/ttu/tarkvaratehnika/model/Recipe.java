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
    @Column(name = "name")//(name = "recipe_name")
    private String name;

    @NotNull
    @Column(name = "description")//(name = "recipe_description")
    private String description;

    @NotNull
    @Column(name = "ingredients")//(name = "recipe_ingredients")
    private String ingredients;

    /*
    @Column(name = "recipe_image")
    private String recipeImage;


     */
    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients='" + ingredients + '\'' +
                '}';
    }
}