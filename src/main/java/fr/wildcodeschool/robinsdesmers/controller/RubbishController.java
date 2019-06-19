package fr.wildcodeschool.robinsdesmers.controller;

import fr.wildcodeschool.robinsdesmers.model.RubbishItem;
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
    public List<RubbishItem> readAllRubbishes() {
        return rubbishRepository.findAll();
    }

    @GetMapping("/rubbishes/{rubbishId}")
    public RubbishItem readOneRubbish(@PathVariable Long rubbishId) {
        return rubbishRepository.findById(rubbishId).get();
    }

    @PostMapping("/users/{userId}/rubbishes")
    public RubbishItem createRubbish(@PathVariable Long userId,
                                     @RequestBody RubbishItem rubbishItem) {
        User user = userRepository.findById(userId).get();
        rubbishItem.setUser(user);
        return rubbishRepository.save(rubbishItem);
    }

    @PutMapping("/rubbishes/{rubbishId}")
    public RubbishItem updateRubbish(@PathVariable Long rubbishId, @RequestBody RubbishItem rubbishItem) {
        RubbishItem rubbishItemToUpdate = rubbishRepository.findById(rubbishId).get();
            rubbishItemToUpdate.setName(rubbishItem.getName());
        return rubbishRepository.save(rubbishItemToUpdate);
    }

    @DeleteMapping("/rubbishes/{rubbishId}")
    public void deleteRubbish(@PathVariable Long rubbishId) {
        rubbishRepository.deleteById(rubbishId);
    }
}
