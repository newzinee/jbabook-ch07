package strategy.mapped;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter @Setter
public class BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;
}
