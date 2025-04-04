package exo_JPA.Repository;

import exo_JPA.Entity.BaseEntity;
import exo_JPA.Entity.Student;
import lombok.ToString;

public class StudentRepository extends BaseRepository<Student> {

    @Override
    protected Class defineRepositoryType() {
        return Student.class;
    }
}
