package ee.ttu.tarkvaratehnika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
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

            repository.addRecipe(new Recipe("chocolate fudge cake",
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
