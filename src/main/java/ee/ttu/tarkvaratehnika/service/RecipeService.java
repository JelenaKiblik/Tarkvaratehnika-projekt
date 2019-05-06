package ee.ttu.tarkvaratehnika.service;

import ee.ttu.tarkvaratehnika.repository.RecipeRepository;
import ee.ttu.tarkvaratehnika.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }

    public Recipe getById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    public List<Recipe> getByName(String name) {
        return recipeRepository.findByName(name);
    }

    public Recipe addRecipe(Recipe recipe) {
        System.out.println("Adding recipe  " + recipe.toString());
        return recipeRepository.save(recipe);
    }

    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    public void deleteAll() {
        recipeRepository.deleteAll();
    }

    public List<Recipe> searchRecipesByName(String searchStr) {
        return recipeRepository.findByName(searchStr);
    }

}
