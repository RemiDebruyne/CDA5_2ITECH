package org.example;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    public int id;
    public String firstName;
    public String lastName;
    public int classNumber;
    public Date graduationDate;

    @Override
    public String toString() {
        return "Student{" + '\n' +
                "id=" + id + '\n' +
                "firstName='" + firstName + '\n' +
                "lastName='" + lastName + '\n' +
                "classNumber=" + classNumber + '\n' +
                "graduationDate=" + graduationDate + '\n' +
                '}';
    }
}
