package strategy.mapped;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

/*
create table Seller (
   SELLER_ID bigint not null,
    SELLER_NAME varchar(255),
    shopName varchar(255),
    primary key (SELLER_ID)
)
 */
@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "SELLER_ID")),
        @AttributeOverride(name = "name", column = @Column(name = "SELLER_NAME"))
})
@Getter @Setter
public class Seller extends BaseEntity{

    private String shopName;
}
