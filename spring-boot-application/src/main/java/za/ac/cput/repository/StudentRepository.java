package za.ac.cput.repository;
/* StudentRepository.java
      Student Repository class
     Author: Henzley Spogter (230013309)
     Date: 23 August 2025
     */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    // custom queries can be added here
}
