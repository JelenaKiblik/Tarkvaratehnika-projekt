package ee.ttu.tarkvaratehnika.service;

import ee.ttu.tarkvaratehnika.dao.RecipeRepository;
import ee.ttu.tarkvaratehnika.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Iterable<Recipe> getAll() {

        return recipeRepository.findAll();
    }

    public Recipe getById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    /*
    public List<Recipe> getByName(String name) {
        return recipeRepository.findByName(name);
    }
    */

    public Recipe save(Recipe recipe) {
        System.out.println(recipe.toString());
        return recipeRepository.save(recipe);
    }

    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    public void deleteAll() {
        recipeRepository.deleteAll();
    }

    public List<Recipe> getRecipes(Long id) {
        List<Recipe> recipes = new ArrayList<>();
        recipeRepository.findById(id);
        return recipes;
    }
}
