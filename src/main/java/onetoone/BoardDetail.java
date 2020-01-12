package onetoone;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 자식
 */
@Entity
@Getter @Setter
public class BoardDetail {

    @Id
    private Long boardId;

    @MapsId // BoardDetail.boardId 매핑
    @OneToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    private String content;

}
