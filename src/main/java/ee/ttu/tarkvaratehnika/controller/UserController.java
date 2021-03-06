package ee.ttu.tarkvaratehnika.controller;

import ee.ttu.tarkvaratehnika.model.User;
import ee.ttu.tarkvaratehnika.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
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
    public User registerUser(@RequestBody User user) {
        System.out.printf("Running registration " + user.toString());
        if (!userService.existsByUsername(user.getUsername())
                && !userService.existsByEmail(user.getEmail())) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            User newUser = userService.addUser(user);
            System.out.printf("User registered " + user.toString());
            return newUser;
        } else {
            System.out.println("Registration failed");
            return null;
        }
    }

    @GetMapping(value= "/loggedIn")
    public Optional<User> getLoggedInUser(Principal principal) {
        String username = principal.getName();
        if(!userService.existsByUsername(username)) return null;
        return userService.getUserByUsername(username);
    }
}
