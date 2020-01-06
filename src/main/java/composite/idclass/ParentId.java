package composite.idclass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
식별자 클래스
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ParentId implements Serializable {
    private String id1; // Parent.id1 매핑
    private String id2; // Parent.id2 매핑
}
