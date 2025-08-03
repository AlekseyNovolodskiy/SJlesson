package pet.SJlesson.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "players_info")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToOne(mappedBy = "playerEntity", cascade = CascadeType.ALL)
    private Scored scored;
}
