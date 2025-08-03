package pet.SJlesson.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pet.SJlesson.entity.PlayerEntity;
import pet.SJlesson.repository.PlayerRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    public String registrationPlayer(String player1FN, String player1LN, String player2FN, String player2LN){

        Optional<PlayerEntity> player1Entity = playerRepository.findByFirstNameAndLastName(player1FN, player1LN);
        Optional<PlayerEntity> player2Entity = playerRepository.findByFirstNameAndLastName(player2FN, player2LN);
        PlayerEntity player1 =new PlayerEntity();
        PlayerEntity player2 = new PlayerEntity();

        player1.setFirstName(player1FN);
        player1.setLastName(player1LN);
        player2.setFirstName(player2FN);
        player2.setLastName(player2LN);

        playerRepository.save(player1);
        playerRepository.save(player2);

        return "game";
    }
}
