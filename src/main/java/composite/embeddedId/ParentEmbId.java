package composite.embeddedId;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
public class ParentEmbId implements Serializable {

    @Column(name = "PARENT_ID1")
    private String name;

    @Column(name = "PARENT_ID2")
    private String id2;
}
