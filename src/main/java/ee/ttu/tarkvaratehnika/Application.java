package ee.ttu.tarkvaratehnika;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(RecipeRepository repository) {
        return (args) -> {
            // save a couple of recipes
            repository.save(new Recipe("kotletid", "Sega hakkliha maitseainetega. Pane pannile kuni muutub pruuniks.", "hakkliha, maitseained", 5, 1));

            // fetch all recipes
            log.info("Recipes found with findAll():");
            log.info("-------------------------------");
            for (Recipe recipe : repository.findAll()) {
                log.info(recipe.toString());
            }
            log.info("");

            // fetch an individual recipe by ID
            repository.findById(1L)
                    .ifPresent(recipe -> {
                        log.info("Recipe found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(recipe.toString());
                        log.info("");
                    });

            // fetch recipes by name
            log.info("Recipe found with findByName('klassikaline võileib'):");
            log.info("--------------------------------------------");
            repository.findByName("klassikaline võileib").forEach(võiku -> {
                log.info(võiku.toString());
            });
            // for (Recipe võiku: repository.findByName("klassikaline võileib")) {
            // 	log.info(võiku.toString());
            // }
            log.info("");
        };
	/*	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		// *** URL below needs to match the Vue client URL and port ***
		config.setAllowedOrigins(Collections.singletonList("http://localhost:9000"));
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;*/
    }
}
