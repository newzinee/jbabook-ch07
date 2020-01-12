package unidentification;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 부모
 */
@Entity(name = "PARENT_UN")
@Getter @Setter
@Table(name = "PARENT_UN")
public class Parent {

    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;

    private String name;
}
