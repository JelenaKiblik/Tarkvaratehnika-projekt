package ee.ttu.tarkvaratehnika;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/hello-world")
    @CrossOrigin(origins = "http://localhost:9000")
    public String getHelloWorld() {
        return "Hello world!";
    }
}