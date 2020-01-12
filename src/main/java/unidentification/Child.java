package unidentification;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 자식
 */
@Entity(name = "CHILD_UN")
@Table(name = "CHILD_UN")
@Getter @Setter
public class Child {

    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Parent parent;
}
