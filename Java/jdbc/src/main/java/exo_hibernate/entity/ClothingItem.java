package exo_hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "clothing_items")
public class ClothingItem extends Item {
    private String category;
    private String size;

    @Override
    public String toString() {
        return "ClothingItem {"
                + "\n  id=" + id
                + "\n  description='" + description + '\''
                + "\n  price=" + price
                + "\n  quantity=" + quantity
                + "\n  restockDate=" + restockDate
                + "\n  category='" + category + '\''
                + "\n  size='" + size + '\''
                + "\n}";
    }

}
