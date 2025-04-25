package student_exo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import student_exo.model.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
