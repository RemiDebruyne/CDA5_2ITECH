package exo_JPA.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.sql.Time;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Course extends BaseEntity {
    private String subject;
    private String professor;
    private int classroom;
    @Column(name = "start_time")
    private Time startTime;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    @Override
    public String toString() {
        return "Course{" +
                "subject='" + subject +  "\n" +
                ", professor='" + professor +  "\n" +
                ", classroom=" + classroom + "\n" +
                ", startTime=" + startTime + "\n" +
                '}';
    }
}
