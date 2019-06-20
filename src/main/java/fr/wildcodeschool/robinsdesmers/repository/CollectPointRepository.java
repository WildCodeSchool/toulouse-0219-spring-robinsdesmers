package fr.wildcodeschool.robinsdesmers.repository;

import fr.wildcodeschool.robinsdesmers.model.CollectPointItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectPointRepository extends JpaRepository<CollectPointItem, Long> {
}
