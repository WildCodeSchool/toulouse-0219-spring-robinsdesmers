package fr.wildcodeschool.robinsdesmers.controller;

import fr.wildcodeschool.robinsdesmers.model.CollectPointItem;
import fr.wildcodeschool.robinsdesmers.model.User;
import fr.wildcodeschool.robinsdesmers.repository.CollectPointRepository;
import fr.wildcodeschool.robinsdesmers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CollectPointController {

    @Autowired
    private CollectPointRepository collectPointRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/collectPoints")
    public List<CollectPointItem> readAllCollectPointItems() {
        return collectPointRepository.findAll();
    }

    @GetMapping("/collectPoints/{collectPointId}")
    public CollectPointItem readOneCollectPointItem(@PathVariable Long collectPointId) {
        return collectPointRepository.findById(collectPointId).get();
    }

    @PostMapping("/users/{userId}/collectPoints")
    public CollectPointItem createCollectPointItem(@PathVariable Long userId, @RequestBody CollectPointItem collectPointItem) {
        User user = userRepository.findById(userId).get();
        collectPointItem.setUser(user);
        return collectPointRepository.save(collectPointItem);
    }

    @PutMapping("/collectPoints/{collectPointId}")
    public CollectPointItem updateCollectPoint(@PathVariable Long collectPointId, @RequestBody CollectPointItem collectPointItem) {
        CollectPointItem collectPointItemToUpdate = collectPointRepository.findById(collectPointId).get();
        collectPointItemToUpdate.setTitle(collectPointItem.getTitle());
        collectPointItemToUpdate.setDescription(collectPointItem.getDescription());
        collectPointItemToUpdate.setSommePoubelle(collectPointItem.getSommePoubelle());
        collectPointItemToUpdate.setLatitude(collectPointItem.getLatitude());
        collectPointItemToUpdate.setLongitude(collectPointItem.getLongitude());
        return collectPointRepository.save(collectPointItemToUpdate);
    }

    @DeleteMapping("/collectPoints/{collectPointId}")
    public boolean deleteCollectPoint(@PathVariable Long collectPointId) {
        collectPointRepository.deleteById(collectPointId);
        return true;
    }
}
