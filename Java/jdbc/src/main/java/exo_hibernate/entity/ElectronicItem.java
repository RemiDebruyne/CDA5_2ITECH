package exo_hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "electronic_items")
public class ElectronicItem extends Item {
    @Column(name = "battery_life")
    private int batteryLife;

    @Override
    public String toString() {
        return "ElectronicItem {"
                + "\n  id=" + id
                + "\n  description='" + description + '\''
                + "\n  price=" + price
                + "\n  quantity=" + quantity
                + "\n  restockDate=" + restockDate
                + "\n  batteryLife=" + batteryLife
                + "\n}";
    }


}
