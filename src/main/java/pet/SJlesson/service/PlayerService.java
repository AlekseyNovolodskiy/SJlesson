package pet.SJlesson.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pet.SJlesson.entity.PlayerEntity;
import pet.SJlesson.exception.PlayerException;
import pet.SJlesson.model.PlayerDto;
import pet.SJlesson.repository.PlayerRepository;

import static java.util.Objects.isNull;

@Slf4j
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;


    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public String registrationPlayer(String player1FN, String player1LN, String player2FN, String player2LN, Model model) {

        PlayerEntity player1NameAndLastName = playerRepository.findByFirstNameAndLastName(player1FN, player1LN);
        PlayerEntity player2tNameAndLastName = playerRepository.findByFirstNameAndLastName(player2FN, player2LN);

        if(!isNull(player1NameAndLastName)){
            throw new PlayerException("Player one is already played");
        }
        if(!isNull(player2tNameAndLastName)){
            throw new PlayerException("Player two is already played");
        }
        PlayerEntity player1 = new PlayerEntity();
        PlayerEntity player2 = new PlayerEntity();

        player1.setFirstName(player1FN);
        player1.setLastName(player1LN);
        player2.setFirstName(player2FN);
        player2.setLastName(player2LN);

        model.addAttribute("playerOneName", player1FN);
        model.addAttribute("playerOneLastName",player1LN);
        model.addAttribute("playerTwoName", player2FN);
        model.addAttribute("playerTwoLastName",player2LN);

        playerRepository.save(player1);
        playerRepository.save(player2);

        PlayerDto playerDto = new PlayerDto();
        playerDto.setFirstNamePlayer1(player1FN);
        playerDto.setLastNamePlayer1(player1LN);
        playerDto.setFirstNamePlayer2(player2FN);
        playerDto.setLastNamePlayer2(player2LN);

        return "new_game";
    }
}
