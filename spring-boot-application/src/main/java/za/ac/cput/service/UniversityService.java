package za.ac.cput.service;
/*  UniversityService.java
    University Service class
    Author: Angelo Smidt - 230688020
    Date: 25 May 2025
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.University;
import za.ac.cput.repository.UniversityRepository;

import java.util.List;

@Service
public class UniversityService implements IUniversityService {
    @Autowired
    private static IUniversityService service;
    private UniversityRepository repository;

    @Override
    public University create(University university) {
        return this.repository.save(university);
    }

    @Override
    public University read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public University update(University university) {
        return this.repository.save(university);
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        return true;
    }

    @Override
    public List<University> getAll() {
        return this.repository.findAll();
    }
}
