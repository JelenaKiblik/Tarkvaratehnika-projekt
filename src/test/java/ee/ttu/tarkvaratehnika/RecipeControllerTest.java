package ee.ttu.tarkvaratehnika;

import ee.ttu.tarkvaratehnika.controller.RecipeController;
import ee.ttu.tarkvaratehnika.model.Recipe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeControllerTest {

    @Autowired
    private RecipeController recipeController;

    @Test
    public void shouldLoadController() {
        assertThat(recipeController).isNotNull();
    }

    @Test
    public void postsShouldNotBeEmpty() {
        new Recipe();
        List<Recipe> recipes = recipeController.getRecipes(0);
        assertTrue(recipes.size() != 0);
    }
}