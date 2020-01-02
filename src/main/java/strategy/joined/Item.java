package strategy.joined;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 부모 객체
 *
 * ITEM_ID(PK), NAME, PRICE
 *
 * 1. 조인전략에서는 자식 구분자로 DTYPE 컬럼 추가
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
@Getter @Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;

    private int price;

}
