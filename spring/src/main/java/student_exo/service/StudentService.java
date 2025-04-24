package student_exo.service;

import lombok.Data;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.stereotype.Service;
import student_exo.model.Student;
import student_exo.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Data
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    List<Student> students = new ArrayList<>(List.of(
            Student.builder().id(0).firstName("jean").lastName("paul").age(21).email("test@mail.com").build(),
            Student.builder().id(1).firstName("tom").lastName("dupont").age(21).email("test@mail.com").build(),
            Student.builder().id(2).firstName("Manu").lastName("max").age(21).email("test@mail.com").build()
    ));

    public void addOrUpdate(Student student) {
//        if(student.getId() == 0){
//            student.setId(students.size());
//            students.add(student);
//        } else {
//            update(student.getId(), student);
//        }
        studentRepository.save(student);
    }


    public void update(int id, Student student) {
        Student studentToUpdate = get(id);
        studentToUpdate.setFirstName(student.getFirstName());
        studentToUpdate.setLastName(student.getLastName());
        studentToUpdate.setAge(student.getAge());
        studentToUpdate.setEmail(student.getEmail());
    }

    public Student get(int id) {
//        return students.stream()
//                .filter(student -> student.getLastName().equals(lastName))
//                .findFirst()
//                .orElse(null);

        return studentRepository.findById(id).orElse(null);
    }

    public Iterable<Student> getAll() {
        return studentRepository.findAll();
    }

    public void delete(Student student){
//        students.remove(student);
        studentRepository.delete(student);
    }
}
