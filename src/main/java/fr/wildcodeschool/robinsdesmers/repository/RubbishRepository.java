package fr.wildcodeschool.robinsdesmers.repository;

import fr.wildcodeschool.robinsdesmers.model.RubbishItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubbishRepository extends JpaRepository<RubbishItem, Long> {
}
