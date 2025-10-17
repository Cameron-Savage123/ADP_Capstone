package za.ac.cput.service;
/* IStudentService.java
      IStudent Service Interface
     Author: Henzley Spogter (230013309)
     Date: 23 August 2025
     */

import za.ac.cput.domain.Student;

import java.util.List;

public interface IStudentService {
    Student create(Student student);

    Student read(String studentID);

    Student update(Student student);

    boolean delete(String studentID);

    List<Student> getAll();
}
