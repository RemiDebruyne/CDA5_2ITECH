package exo_hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Sale {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name = "purchase_date")
    private Date purchaseDate;
    @ManyToMany
    @JoinTable(
            name = "sale_item",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items;
    private Status status;

    @Override
    public String toString() {
        return "Sale {"
                + "\n  id=" + id
                + "\n  clientId=" + client.getId()
                + "\n  purchaseDate=" + purchaseDate
                + "\n}";
    }

}
