package pet.SJlesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.SJlesson.entity.PlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

   PlayerEntity  findByFirstNameAndLastName(String fn, String ln);
   PlayerEntity findByFirstName(String fn);
}
