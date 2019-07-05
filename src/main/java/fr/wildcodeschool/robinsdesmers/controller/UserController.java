package fr.wildcodeschool.robinsdesmers.controller;

import fr.wildcodeschool.robinsdesmers.model.Authentication;
import fr.wildcodeschool.robinsdesmers.model.Stats;
import fr.wildcodeschool.robinsdesmers.model.User;
import fr.wildcodeschool.robinsdesmers.repository.CollectPointRepository;
import fr.wildcodeschool.robinsdesmers.repository.RubbishRepository;
import fr.wildcodeschool.robinsdesmers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class UserController {
    @Autowired
    private CollectPointRepository collectPointRepository;

    @Autowired
    private RubbishRepository rubbishRepository;

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
        user.setToken(generateToken());
        return userRepository.save(user);
    }

    public String generateToken() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 20;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    @GetMapping("/users/token/{token}")
    public User signByToken(@PathVariable String token) {
        User user = userRepository.findUserByToken(token);
        return user;
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

    @GetMapping("/stats")
    public Stats getStats(){
        Stats stats = new Stats();
        stats.setNbUsers(userRepository.findAll().size());
        stats.setNbCollectPoints(collectPointRepository.findAll().size());
        stats.setNbRubbishes(rubbishRepository.findAll().size());
        return stats;
    }
}

