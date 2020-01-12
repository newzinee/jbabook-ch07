package composite2.embeddedid;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 자식
 */
@Entity(name = "CHILD_COM_EMB")
@Getter @Setter
@Table(name = "CHILD_COM_EMB")
public class Child {

    @EmbeddedId
    private ChildId id;

    @MapsId("parentId") // ChildId.parentId 매핑
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public Parent parent;

    private String name;
}
