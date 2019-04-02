package ee.ttu.tarkvaratehnika.controller;

import ee.ttu.tarkvaratehnika.model.Recipe;
import ee.ttu.tarkvaratehnika.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping(value = "/recipes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Recipe> getAll() {
        return recipeService.getAll();
    }

    @GetMapping(value = "/recipes/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Recipe> getByName(@PathVariable String name) {
        return recipeService.getByName(name);
    }

    @GetMapping(value = "/recipes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Recipe getById(@PathVariable Long id) {
        return recipeService.getById(id);
    }

    @PostMapping(value = "/recipes")
    public Recipe postRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }

    @PutMapping(value = "/recipes/{id}")
    public void updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        Recipe foundRecipe = recipeService.getById(id);
        foundRecipe.setRecipeName(recipe.getRecipeName());
        foundRecipe.setRecipeDescription(recipe.getRecipeDescription());
        foundRecipe.setRecipeIngredients(recipe.getRecipeIngredients());
        recipeService.addRecipe(foundRecipe);
    }

    @DeleteMapping(value = "/recipes/{id}")
    public void deleteById(@PathVariable Long id) {
        recipeService.deleteById(id);
    }

    @DeleteMapping(value = "/recipes")
    public void deleteAll() {
        recipeService.deleteAll();
    }

}