package exo_hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "item_type")
public class Item {
    @Id
    protected int id;
    protected String description;
    protected float price;
    protected int quantity;
    @Column(name = "restock_date")
    protected Date restockDate;

    @Override
    public String toString() {
        return "Item {"
                + "\n  id=" + id
                + "\n  description='" + description + '\''
                + "\n  price=" + price
                + "\n  quantity=" + quantity
                + "\n  restockDate=" + restockDate
                + "\n}";
    }

}
