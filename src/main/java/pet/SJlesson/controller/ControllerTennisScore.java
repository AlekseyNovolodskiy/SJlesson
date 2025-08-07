package pet.SJlesson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pet.SJlesson.service.PlayerService;
import pet.SJlesson.service.ScoreService;

@Controller

public class ControllerTennisScore {
    private final PlayerService playerService;
    private final ScoreService scoreService;

    public ControllerTennisScore(PlayerService playerService, ScoreService scoreService) {
        this.playerService = playerService;
        this.scoreService = scoreService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/tennis/start")
    public String startGame() {
        return "start";

    }

    @GetMapping("/tennis/newgame")
    public String newGame(@RequestParam String p1FN, @RequestParam String p1LN, @RequestParam String p2FN, @RequestParam String p2LN, Model model) {
        return playerService.registrationPlayer(p1FN, p1LN, p2FN, p2LN, model);
    }

    @GetMapping("/tennis/play")
    public String play(@RequestParam String p1FN, @RequestParam String p1LN, @RequestParam String p2FN, @RequestParam String p2LN, Model model) {
        return scoreService.gameService(p1FN,p1LN,p2FN,p2LN,model);
    }
    @GetMapping("/save-winner")
    public void saveWinner(@RequestParam String winner){
        scoreService.saveWinner(winner);
    }
}

//