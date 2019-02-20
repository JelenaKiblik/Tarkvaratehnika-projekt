package ee.ttu.tarkvaratehnika;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "recipe", path = "recipe")
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    List<Recipe> findByName (@Param("name") String name);
}