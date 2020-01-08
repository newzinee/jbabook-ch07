package composite.embeddedId;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PARENT_EMB")
@Getter @Setter
public class ParentEmb {

    @EmbeddedId
    private ParentEmbId id;

    private String name;
}
