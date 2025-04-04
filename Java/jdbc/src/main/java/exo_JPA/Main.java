package exo_JPA;

import exo_JPA.Entity.Exam;
import exo_JPA.Entity.Student;
import exo_JPA.Repository.ExamRepository;
import exo_JPA.Repository.StudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var repo = new StudentRepository();
        var examRepository = new ExamRepository();
        List<Exam> exams = examRepository.getAllByStudentAndSubject(3,"Literature");

        for (Exam exam : exams) {
            System.out.println(exam);
        }
    }
}