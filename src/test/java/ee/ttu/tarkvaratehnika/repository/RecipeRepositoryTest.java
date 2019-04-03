package ee.ttu.tarkvaratehnika.repository;

import ee.ttu.tarkvaratehnika.model.Recipe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RecipeRepositoryTest {

    @Autowired
    RecipeRepository recipeRepository;

    @Test
    public void addsRecipeWithNullId() throws Exception {
        Recipe recipe = new Recipe(null, "Name", "Description", "Ingredients");
        recipeRepository.save(recipe);
    }

    @Test
    public void findsByName() throws Exception {
        Recipe recipe = new Recipe(null, "SearchingName", "Description", "Ingredients");
        recipeRepository.save(recipe);
        List<Recipe> foundRecipes = recipeRepository.findByName("SearchingName");
        Assert.notEmpty(foundRecipes, "Not empty");
    }
}
