package pet.SJlesson.service;


import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pet.SJlesson.entity.PlayerEntity;
import pet.SJlesson.entity.ScoredEntity;
import pet.SJlesson.exception.PlayerException;
import pet.SJlesson.repository.PlayerRepository;
import pet.SJlesson.repository.ScoreRepository;

import static java.util.Objects.isNull;

@Service

public class ScoreService {

    private final ScoreRepository scoreRepository;
    private final PlayerRepository playerRepository;

    public ScoreService(ScoreRepository scoreRepository, PlayerRepository playerRepository) {
        this.scoreRepository = scoreRepository;
        this.playerRepository = playerRepository;
    }

    public String gameService(String p1FN, String p1LN, String p2FN, String p2LN, Model model) {
        PlayerEntity playerOneFirstNameAndLastName = playerRepository.findByFirstNameAndLastName(p1FN, p1LN);
        PlayerEntity playerTwoFirstNameAndLastName = playerRepository.findByFirstNameAndLastName(p2FN, p2LN);
        if (isNull(playerOneFirstNameAndLastName) || isNull(playerTwoFirstNameAndLastName)) {
            throw new PlayerException("Игроки не зарегестрированы");
        }
        if (playerOneFirstNameAndLastName.getFirstName().equals(playerTwoFirstNameAndLastName.getFirstName()) &&
                playerTwoFirstNameAndLastName.getLastName().equals(playerOneFirstNameAndLastName.getLastName())) {
            throw new PlayerException("Имена игроков совпадают");
        }


        model.addAttribute("playerOneName", p1FN);
        model.addAttribute("playerTwoName", p2FN);
        model.addAttribute("playerOneLastName", p1LN);
        model.addAttribute("playerTwoLastName", p2LN);

        return "play";
    }

    public void saveWinner(String winner) {
        // 1. Находим игрока
        PlayerEntity player = playerRepository.findByFirstName(winner);
        if (player == null) {
            throw new IllegalArgumentException("Player not found with name: " + winner);
        }

        // 2. Создаем новую запись счета
        ScoredEntity scoredEntity = new ScoredEntity();
        scoredEntity.setPlayerEntity(player);
        scoredEntity.setScore(1);

        // 3. Устанавливаем двустороннюю связь
        player.setScored(scoredEntity);

        // 4. Сохраняем (каскадирование сохранит и ScoredEntity)
        playerRepository.save(player);
    }
}
