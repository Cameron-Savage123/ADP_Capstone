package za.ac.cput.service;
/* Subject.java

     TutorSubjectSubject POJO class

     Author: Keewan Titus (230778577)

     Date: 25 May 2025 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.TutorSubject;
import za.ac.cput.repository.TutorSubjectRepository;

import java.util.List;


@Service
public class TutorSubjectService implements ITutorSubjectService {

    @Autowired
    private static ITutorSubjectService service;

    private TutorSubjectRepository repository;

    @Override
    public TutorSubject create(TutorSubject tutorSubject) {
        return this.repository.save(tutorSubject);
    }

    @Override
    public TutorSubject read(String subjectCode) {
        return this.repository.findById(subjectCode).orElse(null);
    }

    @Override
    public TutorSubject update(TutorSubject subjectName) {
        return this.repository.save(subjectName);
    }

    @Override
    public boolean delete(String subjectCode) {
        this.repository.deleteById(subjectCode);
        return true;
    }

    @Override
    public List<TutorSubject> getAll() {
        return this.repository.findAll();
    }
}










