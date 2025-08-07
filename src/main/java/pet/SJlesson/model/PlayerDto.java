package pet.SJlesson.model;

import lombok.Data;


public class PlayerDto {
    private String firstNamePlayer1;
    private String lastNamePlayer1;
    private String firstNamePlayer2;
    private String lastNamePlayer2;

    public String getFirstNamePlayer1() {
        return firstNamePlayer1;
    }

    public void setFirstNamePlayer1(String firstNamePlayer1) {
        this.firstNamePlayer1 = firstNamePlayer1;
    }

    public String getLastNamePlayer1() {
        return lastNamePlayer1;
    }

    public void setLastNamePlayer1(String lastNamePlayer1) {
        this.lastNamePlayer1 = lastNamePlayer1;
    }

    public String getFirstNamePlayer2() {
        return firstNamePlayer2;
    }

    public void setFirstNamePlayer2(String firstNamePlayer2) {
        this.firstNamePlayer2 = firstNamePlayer2;
    }

    public String getLastNamePlayer2() {
        return lastNamePlayer2;
    }

    public void setLastNamePlayer2(String lastNamePlayer2) {
        this.lastNamePlayer2 = lastNamePlayer2;
    }
}
