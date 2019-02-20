package ee.ttu.tarkvaratehnika;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/hello-world")
    public String getHelloWorld() {
        return "Tere tulemast!";
    }
}