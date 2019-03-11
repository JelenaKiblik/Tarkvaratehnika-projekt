package ee.ttu.tarkvaratehnika.controller;

import ee.ttu.tarkvaratehnika.model.Recipe;
import ee.ttu.tarkvaratehnika.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping(value = "/recipes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recipe> getRecipes(@PathVariable Long id) {
        return recipeService.getRecipes(id);
    }

    @GetMapping(value = "/recipes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Recipe> getAll() {
        for (Recipe r : recipeService.getAll()) {
            System.out.println(r);
        }
        return recipeService.getAll();
    }

    @GetMapping(value = "/recipes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Recipe getById(@PathVariable Long id) {
        return recipeService.getById(id);
    }

    @PostMapping(value = "/recipes")
    public Recipe postRecipe(@RequestBody Recipe recipe) {
        System.out.println(recipe.toString());
        return recipeService.save(recipe);
    }

    @DeleteMapping(value = "/recipes/{id}")
    public void deleteById(@PathVariable Long id) {
        recipeService.deleteById(id);
    }

    @DeleteMapping(value = "/recipes")
    public void deleteAll() {
        recipeService.deleteAll();
    }

    @PutMapping(value = "/recipes/{id}")
    public void changeRecipe(@RequestBody Recipe recipe) {
    }
}