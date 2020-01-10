package composite2.embeddedid;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 자식 ID
 */
@Embeddable
@EqualsAndHashCode
public class ChildId implements Serializable {

    private String parentId;    // @MapsId("parentId")로 매핑

    @Column(name = "CHILD_ID")
    private String id;
}
