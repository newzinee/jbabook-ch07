package ototable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 일대일 조인 테이블 부모
 */
@Entity(name = "OTO_PARENT")
@Getter @Setter
public class Parent {

    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;

    private  String name;

    @OneToOne
    @JoinTable(name = "PARENT_CHILD",
            joinColumns = @JoinColumn(name = "PARENT_ID"),
        inverseJoinColumns = @JoinColumn(name = "CHILD_ID"))
    private Child child;
}
