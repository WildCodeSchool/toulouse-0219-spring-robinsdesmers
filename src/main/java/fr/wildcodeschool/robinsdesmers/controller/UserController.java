package fr.wildcodeschool.robinsdesmers.controller;

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
        return userRepository.save(userToUpdate);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }
}

