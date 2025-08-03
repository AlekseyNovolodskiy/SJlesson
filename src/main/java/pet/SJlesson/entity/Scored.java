package pet.SJlesson.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name="scored")
public class Scored {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int score;

    @OneToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity playerEntity;
}
