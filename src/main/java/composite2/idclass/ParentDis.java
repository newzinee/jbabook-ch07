package composite2.idclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 복합 키 : 식별 관계
 * 부모
 */
@Entity
@Getter @Setter
public class ParentDis {

    @Id @Column(name = "PARENT_ID")
    private String id;

    private String name;

}
