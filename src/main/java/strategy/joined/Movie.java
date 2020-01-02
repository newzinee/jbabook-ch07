package strategy.joined;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 자식 객체
 *
 * ITEM_ID(PK, FK), DIRECTOR, ACTOR
 */
@Entity
@DiscriminatorValue("M")
@Getter @Setter
public class Movie extends Item {

    private String director;

    private String actor;

}
