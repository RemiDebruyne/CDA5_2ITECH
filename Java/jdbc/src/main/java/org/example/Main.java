package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "root";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            if (connection != null) {
                System.out.println("Vous etes connecté");
            }

            // Select all
            String selectAllRequest = "select * from students";
            PreparedStatement selectAllPreparedStatement = connection.prepareStatement(selectAllRequest, Statement.RETURN_GENERATED_KEYS);
            ResultSet selectAllResultSet = selectAllPreparedStatement.executeQuery();
            List<Student> students = new ArrayList();
            while (selectAllResultSet.next()) {
                students.add(new Student(
                        selectAllResultSet.getInt("id"),
                        selectAllResultSet.getString("first_name"),
                        selectAllResultSet.getString("last_name"),
                        selectAllResultSet.getInt("class_number"),
                        selectAllResultSet.getDate("graduation_date")
                ));
            }

            for (Student student : students) {
                System.out.println(student);
            }

            // Select by class
            String selectByClassRequest = "select * from students where class_number = ?";
            PreparedStatement selectByClassPreparedStatement = connection.prepareStatement(selectByClassRequest);
            selectByClassPreparedStatement.setInt(1, 101);
            ResultSet selectByclassSet = selectByClassPreparedStatement.executeQuery();

//            List<Student> students = new ArrayList();
//            while(selectByclassSet.next()) {
//                students.add(new Student(
//                        selectByclassSet.getInt("id"),
//                        selectByclassSet.getString("first_name"),
//                        selectByclassSet.getString("last_name"),
//                        selectByclassSet.getInt("class_number"),
//                        selectByclassSet.getDate("graduation_date")
//                ));
//            }
//
//            for(Student student : students) {
//                System.out.println(student);
//            }

            // Delete
            String deleteStudentByIdRequest = "delete from students where id = ?";
            PreparedStatement deleteStudentByIdPreparedStatement = connection.prepareStatement(deleteStudentByIdRequest);
            deleteStudentByIdPreparedStatement.setInt(1, 1);
//            deleteStudentByIdPreparedStatement.executeUpdate();


            selectByClassPreparedStatement.setInt(1, 1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


    }
}