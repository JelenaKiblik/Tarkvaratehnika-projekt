package ee.ttu.tarkvaratehnika;

import ee.ttu.tarkvaratehnika.dao.RecipeRepository;
//import ee.ttu.tarkvaratehnika.model.Ingredient;
import ee.ttu.tarkvaratehnika.model.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {
    //private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*
    @Bean
    public CommandLineRunner demo(RecipeRepository repository) {
        List<Ingredient> ings = new ArrayList<>(0);
        ings.add(new Ingredient("Cocoa powder"));
        ings.add(new Ingredient("Self-raising flour"));
        ings.add(new Ingredient("Caster sugar"));
        ings.add(new Ingredient("Eggs"));
        return (args) -> {

            repository.save(new Recipe("chocolate fudge cake",
                    "Sandwich the two cakes together with the butter icing and cover the sides and the top of the cake with more butter icing.",
                    ings));

            log.info("Recipes found with findAll():");
            log.info("-------------------------------");
            for (Recipe recipe : repository.findAll()) {
                log.info(recipe.toString());
            }
            log.info("");

            repository.findById(1L)
                    .ifPresent(recipe -> {
                        log.info("Recipe found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(recipe.toString());
                        log.info("");
                    });

            log.info("Recipe found with findByName('chocolate fudge cake'):");
            log.info("--------------------------------------------");
            repository.findByName("chocolate fudge cake").forEach(chocolate -> {
                log.info(chocolate.toString());
            });
            log.info("");
        };
    }
    */
}
