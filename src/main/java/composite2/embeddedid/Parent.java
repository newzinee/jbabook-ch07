package composite2.embeddedid;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 부모
 */
@Entity
@Getter @Setter
public class Parent {

    @Id @Column(name = "PARENT_ID")
    private String id;

    private String name;
}
