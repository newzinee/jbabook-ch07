package composite2.idclass;

import java.io.Serializable;

/**
 * 자식 ID
 */
public class ChildId implements Serializable {
    private String parent; // Child.parent; // 매핑
    private String childId; // Child.childId // 매핑
}
