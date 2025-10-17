package za.ac.cput.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Subject;
import za.ac.cput.repository.SubjectRepository;

import java.util.List;

/*Keewan Titus
230778577
 */
@Service
public class SubjectService implements ISubjectService {


    public final SubjectRepository repository;

    @Autowired
    public SubjectService(SubjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subject create(Subject subject) {
        return this.repository.save(subject);
    }

    @Override
    public Subject read(String subjectCode) {
        return this.repository.findById(subjectCode).orElse(null);
    }

    @Override
    public Subject update(Subject subject) {
        return this.repository.save(subject);
    }

    @Override
    public boolean delete(String subjectCode) {
        this.repository.deleteById(subjectCode);
        return true;
    }

    @Override
    public List<Subject> getAll() {
        return  this.repository.findAll();
    }
}
