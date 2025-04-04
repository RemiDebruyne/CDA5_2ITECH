package exo_hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Client {
    @Id
    private int id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "client")
    private List<Sale> purchases;

    @Override
    public String toString() {
        return "Client {"
                + "\n  id=" + id
                + "\n  name='" + name + '\''
                + "\n  email='" + email + '\''
                + "\n}";
    }
}

