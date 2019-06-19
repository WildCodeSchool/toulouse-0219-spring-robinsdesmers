package fr.wildcodeschool.robinsdesmers.controller;

import fr.wildcodeschool.robinsdesmers.model.Rubbish;
import fr.wildcodeschool.robinsdesmers.model.User;
import fr.wildcodeschool.robinsdesmers.repository.RubbishRepository;
import fr.wildcodeschool.robinsdesmers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RubbishController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RubbishRepository rubbishRepository;

    @GetMapping("/rubbishes")
    public List<Rubbish> readAllRubbishes() {
        return rubbishRepository.findAll();
    }

    @GetMapping("/rubbishes/{rubbishId}")
    public Rubbish readOneRubbish(@PathVariable Long rubbishId) {
        return rubbishRepository.findById(rubbishId).get();
    }

    @PostMapping("/users/{userId}/rubbishes")
    public Rubbish createRubbish(@PathVariable Long userId,
                       @RequestBody Rubbish rubbish) {
        User user = userRepository.findById(userId).get();
        rubbish.setUser(user);
        return rubbishRepository.save(rubbish);
    }

    @PutMapping("/rubbishes/{rubbishId}")
    public Rubbish updateRubbish(@PathVariable Long rubbishId, @RequestBody Rubbish rubbish) {
        Rubbish rubbishToUpdate = rubbishRepository.findById(rubbishId).get();
            rubbishToUpdate.setName(rubbish.getName());
        return rubbishRepository.save(rubbishToUpdate);
    }

    @DeleteMapping("/rubbishes/{rubbishId}")
    public void deleteRubbish(@PathVariable Long rubbishId) {
        rubbishRepository.deleteById(rubbishId);
    }
}
