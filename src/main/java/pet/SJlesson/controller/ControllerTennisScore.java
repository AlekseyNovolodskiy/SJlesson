package pet.SJlesson.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pet.SJlesson.model.PlayerDto;
import pet.SJlesson.service.PlayerService;

@Controller
@RequiredArgsConstructor
public class ControllerTennisScore {
    private final PlayerService playerService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("tennis/start")
    public String startGame(@RequestParam String player1FN, @RequestParam String player1LN,@RequestParam String player2FN,@RequestParam String player2LN) {
        return  playerService.registrationPlayer(player1FN, player1LN, player2FN, player2LN);

    }
}