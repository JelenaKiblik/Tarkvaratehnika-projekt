package ee.ttu.tarkvaratehnika.controller;

import ee.ttu.tarkvaratehnika.model.User;
import ee.ttu.tarkvaratehnika.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable("id") long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping(value = "/register")
    public void registerUser(@RequestBody User user) {
        System.out.printf("Running registration " + user.toString());
        if (!userService.existsByUsername(user.getUsername())
                && !userService.existsByEmail(user.getEmail())) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userService.addUser(user);
            System.out.printf("User registered " + user.toString());
        } else {
            System.out.println("Registration failed");
        }
    }
}
