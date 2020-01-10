package composite2.embeddedid;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 손자 ID
 */
@Embeddable
@EqualsAndHashCode
public class GrandChildId implements Serializable {

    private ChildId childId;    // @MapsId("childId")로 매핑

    @Column(name = "GRANDCHILD_ID")
    private String id;
}
