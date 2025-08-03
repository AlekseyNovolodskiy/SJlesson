package pet.SJlesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.SJlesson.entity.PlayerEntity;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

   Optional<PlayerEntity>  findByFirstNameAndLastName(String fn, String ln);
}
