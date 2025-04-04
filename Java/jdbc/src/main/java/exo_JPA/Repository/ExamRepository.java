package exo_JPA.Repository;

import exo_JPA.Entity.Exam;
import exo_JPA.Entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ExamRepository extends BaseRepository<Exam> {
    @Override
    protected Class defineRepositoryType() {
        return Exam.class;
    }
    public List<Exam> getAllByStudentAndSubject(int studentId, String subject){
        Query query = entityManager.createQuery("SELECT e FROM Exam e WHERE e.student.id = " +
                ":studentId " +
                "AND subject = :subject", Exam.class);
        query.setParameter("studentId", studentId);
        query.setParameter("subject", subject);

        return query.getResultList();
    };
}
