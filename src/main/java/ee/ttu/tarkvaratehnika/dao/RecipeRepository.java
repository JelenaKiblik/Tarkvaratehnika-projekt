package ee.ttu.tarkvaratehnika.dao;

import ee.ttu.tarkvaratehnika.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "recipe", path = "recipe")
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    /*
    List<Recipe> findByName (@Param("name") String name);
    */
    Iterable<Recipe> findAll();

    Optional<Recipe> findById(Long id);

    Recipe save(Recipe recipe);

    void deleteAll();

}