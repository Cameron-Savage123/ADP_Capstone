package za.ac.cput.repository;
/*  UniversityRepository.java
    University Repository interface
    Author: Angelo Smidt - 230688020
    Date: 25 May 2025
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.University;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, String> {

}
