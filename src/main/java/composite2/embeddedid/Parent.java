package composite2.embeddedid;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 부모
 */
@Entity(name = "PARENT_COM_EMB")
@Getter @Setter
@Table(name = "PARENT_COM_EMB")
public class Parent {

    @Id @Column(name = "PARENT_ID")
    private String id;

    private String name;
}
