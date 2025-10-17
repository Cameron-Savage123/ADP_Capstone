package za.ac.cput.repository;
/* Subject.java

     SubjectRepository POJO class

     Author: Keewan Titus (230778577)

     Date: 04 May 2025 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Subject;
import za.ac.cput.service.SubjectService;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
}
