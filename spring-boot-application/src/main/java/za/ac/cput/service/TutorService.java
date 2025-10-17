package za.ac.cput.service;
/* TutorService.java
      TutorService class
     Author: Henzley Spogter (230013309)
     Date: 23 August 2025
     */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Tutor;
import za.ac.cput.repository.TutorRepository;

import java.util.List;

@Service
public class TutorService implements ITutorService {

    @Autowired
    private static ITutorService service;

    private TutorRepository repository;

    @Override
    public Tutor create(Tutor tutor) {
        return this.repository.save(tutor);
    }

    @Override
    public Tutor read(String tutorID) {
        return this.repository.findById(tutorID).orElse(null);
    }

    @Override
    public Tutor update(Tutor tutor) {
        return this.repository.save(tutor);
    }

    @Override
    public boolean delete(String tutorID) {
        this.repository.deleteById(tutorID);
        return true;
    }

    @Override
    public List<Tutor> getAll() {
        return this.repository.findAll();
    }
}
