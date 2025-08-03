package pet.SJlesson.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PlayerExceptionHandler {
    @ExceptionHandler(PlayerException.class)
    public String catchPlayerException (PlayerException p){
      return p.getMessage();
    }

    @ExceptionHandler(ScoredException.class)
    public String catchScoredException (ScoredException s){
        return s.getMessage();
    }
}
