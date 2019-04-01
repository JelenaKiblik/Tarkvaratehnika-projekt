package ee.ttu.tarkvaratehnika.controller;

import ee.ttu.tarkvaratehnika.controller.RecipeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeControllerTest {

    @Autowired
    private RecipeController recipeController;

    @Test
    public void shouldLoadController() {
        assertThat(recipeController).isNotNull();
    }

//    @Test
//    public void postsShouldNotBeEmpty() {
//        new Recipe(1, "Name", "Description", "Ingredients", null);
//        List<Recipe> recipes = recipeController.getRecipes(1);
//        assertTrue(recipes.size() != 0);
//    }
}