package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 자식 객체
 *
 * ITEM_ID(PK, FK), ARTIST
 */
@Entity
@DiscriminatorValue("A")
@Getter @Setter
public class Album extends Item {

    private String artist;

}
