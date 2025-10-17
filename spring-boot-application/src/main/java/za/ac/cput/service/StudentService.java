package za.ac.cput.service;
/* StudentService.java
      Student Service class
     Author: Henzley Spogter (230013309)
     Date: 23 August 2025
     */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private static IStudentService service;

    private StudentRepository repository;

    @Override
    public Student create(Student student) {
        return this.repository.save(student);
    }

    @Override
    public Student read(String studentID) {
        return this.repository.findById(studentID).orElse(null);
    }

    @Override
    public Student update(Student student) {
        return this.repository.save(student);
    }

    @Override
    public boolean delete(String studentID) {
        this.repository.deleteById(studentID);
        return true;
    }

    @Override
    public List<Student> getAll() {
        return this.repository.findAll();
    }
}
