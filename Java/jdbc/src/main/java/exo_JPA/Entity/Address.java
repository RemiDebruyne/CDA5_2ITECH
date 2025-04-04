package exo_JPA.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Address extends BaseEntity {
    private int number;
    private String street;
    private String city;
    @Column(name = "postal_code")
    private String postalCode;
    @OneToOne(mappedBy = "address")
    private Student student;

    @Override
    public String toString() {
        return "Address{" +
                "number=" + number + "\n" +
                ", street='" + street + "\n" +
                ", city='" + city  + "\n" +
                ", postalCode='" + postalCode +  "\n" +
                '}';
    }
}

