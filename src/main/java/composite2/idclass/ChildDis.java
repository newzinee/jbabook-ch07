package composite2.idclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 복합 키 : 식별 관계
 * 자식
 */
@Entity
@IdClass(ChildId.class)
@Getter @Setter
public class ChildDis {

    @Id
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public ParentDis parent;

    @Id @Column(name = "CHILD_ID")
    private String childId;

    private String name;

}
