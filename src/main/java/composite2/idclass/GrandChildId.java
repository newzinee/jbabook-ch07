package composite2.idclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 손자 ID
 */
@EqualsAndHashCode
@Getter @Setter
public class GrandChildId implements Serializable {

    private ChildId child;  // GrandChild.child 매핑
    private String id;      // GrandChild.id 매핑

}
