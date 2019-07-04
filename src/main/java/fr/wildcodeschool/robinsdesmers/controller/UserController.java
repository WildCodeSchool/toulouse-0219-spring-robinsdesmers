package fr.wildcodeschool.robinsdesmers.controller;

import fr.wildcodeschool.robinsdesmers.model.Authentication;
import fr.wildcodeschool.robinsdesmers.model.User;
import fr.wildcodeschool.robinsdesmers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> readAllUser() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{userId}")
    public User readOneUser(@PathVariable Long userId) {
        return userRepository.findById(userId).get();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }

    @PutMapping("/users/{userId}/score")
    public User updateUserScore(@PathVariable Long userId) {
        User userToUpdate = userRepository.findById(userId).get();
        userToUpdate.setScore(userToUpdate.getScore() + 10);
        return userRepository.save(userToUpdate);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        User userToUpdate = userRepository.findById(userId).get();
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setGender(user.getGender());
        userToUpdate.setDateOfBirth(user.getDateOfBirth());
        userToUpdate.setDepartment(user.getDepartment());
        userToUpdate.setCategory(user.getCategory());
        userToUpdate.setPseudo(user.getPseudo());
        userToUpdate.setDescription(user.getDescription());
        userToUpdate.setAvatar(user.getAvatar());
        userToUpdate.setScore(user.getScore());
        userToUpdate.setLatitude(user.getLatitude());
        userToUpdate.setLongitude(user.getLongitude());
        userToUpdate.setConnected(user.isConnected());
        return userRepository.save(userToUpdate);
    }

    @GetMapping("/users/{email}/{password}")
    public Authentication signIn(@PathVariable String email, @PathVariable String password) {
        User user = userRepository.findUserByEmailIgnoreCase(email);
        Authentication authentication = new Authentication();
        if (user == null) {
            authentication.setError("ERROR_EMAIL");
            return authentication;
        } else if (!user.getPassword().equals(password)) {
            authentication.setError("ERROR_PASSWORD");
            return authentication;
        }
        authentication.setUser(user);
        return authentication;
    }
}

