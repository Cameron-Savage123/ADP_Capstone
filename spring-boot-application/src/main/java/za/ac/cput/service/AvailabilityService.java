
/*  AvailabilityService.java
    Availability Service class
    Author: Hope  - 221174109
    Date: 25 May 2025
 */

package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Availability;
import za.ac.cput.repository.AvailabilityRepository;

import java.util.List;
@Service
public class AvailabilityService implements IAvailabilityService {

    private final AvailabilityRepository repository;

    @Autowired
    public AvailabilityService(AvailabilityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Availability create(Availability availability) {
        return repository.save(availability);
    }

    @Override
    public Availability read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Availability update(Availability availability) {
        return repository.save(availability);
    }

    @Override
    public boolean delete(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Availability> getAll() {
        return repository.findAll();
    }
}
