package composite2.idclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 복합 키 : 식별 관계
 * 자식
 */
@Entity
@IdClass(GrandChildId.class)
@Getter @Setter
public class GrandChildDis {

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID"),
            @JoinColumn(name = "CHILD_ID")
    })
    private ChildDis child;

    @Id @Column(name = "GRANDCHILD_ID")
    private String id;

    private String name;
}
