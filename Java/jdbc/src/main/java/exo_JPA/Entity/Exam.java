package exo_JPA.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Exam extends BaseEntity {
    private Date date;
    private double grade;
    private String subject;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Override
    public String toString() {
        return "Exam{" + "\n" +
                "date=" + date + "\n" +
                "grade=" + grade + "\n" +
                "subject='" + subject + '\n' +
                '}';
    }
}
