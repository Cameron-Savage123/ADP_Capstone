package za.ac.cput.service;

import za.ac.cput.domain.Availability;

import java.util.List;

public interface IAvailabilityService {
    Availability create(Availability availability);

    Availability read(Long id);

    Availability update(Availability availability);

    boolean delete(Long id);

    List<Availability> getAll();
}
