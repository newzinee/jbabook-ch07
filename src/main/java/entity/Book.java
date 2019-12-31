package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * 자식 객체
 *
 * ITEM_ID(PK, FK), AUTHOR, ISBN
 *
 * ITEM_ID -> BOOK_ID로 컬럼명 재정의
 */
@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "BOOK_ID")
@Getter @Setter
public class Book extends Item {

    private String author;

    private String isbn;

}
