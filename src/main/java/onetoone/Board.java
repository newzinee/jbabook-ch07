package onetoone;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 부모
 */
@Entity
@Getter @Setter
public class Board {

    @Id @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long id;

    private String title;

    @OneToOne(mappedBy = "board")
    private BoardDetail boardDetail;
}
