package ee.ttu.tarkvaratehnika.service;

import ee.ttu.tarkvaratehnika.model.Recipe;
import ee.ttu.tarkvaratehnika.repository.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RecipeServiceTest {

    @Autowired
    RecipeRepository recipeRepository;

    @Before
    public void before() {
        List<Recipe> recipeList = new ArrayList<>();
        Recipe r1 = new Recipe(null, "recipe1", "desc1", "ings1");
        Recipe r2 = new Recipe(null, "recipe2", "desc1", "ings1");
        Recipe r3 = new Recipe(null, "recipe3", "desc1", "ings1");
        Recipe r4 = new Recipe(null, "recipe4", "desc1", "ings1");
        recipeList.add(r1);
        recipeList.add(r2);
        recipeList.add(r3);
        recipeList.add(r4);
        recipeRepository.saveAll(recipeList);
    }

    @Test
    public void getAllTest() throws Exception {

    }

    @Test
    public void getById() throws Exception {

    }

    @Test
    public void getByNonExistantId() throws Exception {

    }

    @Test
    public void getByName() throws Exception {

    }

    @Test
    public void getByNonExistantName() throws Exception {

    }
}
