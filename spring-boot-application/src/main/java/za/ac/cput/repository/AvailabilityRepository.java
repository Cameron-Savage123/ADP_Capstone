package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Availability;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
}
