package pet.SJlesson.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "players_info")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToOne(mappedBy = "playerEntity", cascade = CascadeType.ALL)
    private ScoredEntity scored;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ScoredEntity getScored() {
        return scored;
    }

    public void setScored(ScoredEntity scored) {
        this.scored = scored;
    }
}
