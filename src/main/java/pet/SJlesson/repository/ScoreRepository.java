package pet.SJlesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pet.SJlesson.entity.ScoredEntity;

public interface ScoreRepository extends JpaRepository<ScoredEntity, Long> {

    @Query(value = "select s from ScoredEntity s where s.playerEntity.id = :playerId")
    ScoredEntity findByPlayerID(Long playerId);
}
