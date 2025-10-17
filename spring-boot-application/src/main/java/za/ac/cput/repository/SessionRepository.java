package za.ac.cput.repository;
/*  SessionRepository.java
    Session Repository interface
    Author: Angelo Smidt - 230688020
    Date: 25 May 2025
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, String> {
}
