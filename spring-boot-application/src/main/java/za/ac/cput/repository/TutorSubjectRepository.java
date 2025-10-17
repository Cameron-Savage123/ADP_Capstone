package za.ac.cput.repository;
/* Subject.java

     TutorSubjectRepository POJO class

     Author: Keewan Titus (230778577)

     Date: 25 May 2025 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.TutorSubject;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorSubjectRepository extends JpaRepository<TutorSubject, String> {
}
