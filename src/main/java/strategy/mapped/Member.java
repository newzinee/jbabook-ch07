package strategy.mapped;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

/*
create table Member (
   MEMBER_ID bigint not null,
    name varchar(255),
    email varchar(255),
    primary key (MEMBER_ID)
)
*/
@Entity
@AttributeOverride(name = "id", column = @Column(name = "MEMBER_ID"))
@Getter @Setter
public class Member extends BaseEntity{

    private String email;

}
