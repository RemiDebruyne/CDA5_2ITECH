package exo_hibernate.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "food_items")
public class FoodItem extends Item {
    @Column(name = "expiration_date")
    private Date expirationDate;

    @Override
    public String toString() {
        return "FoodItem {"
                + "\n  id=" + id
                + "\n  description='" + description + '\''
                + "\n  price=" + price
                + "\n  quantity=" + quantity
                + "\n  restockDate=" + restockDate
                + "\n  expirationDate=" + expirationDate
                + "\n}";
    }

}

