package za.ac.cput.service;

import za.ac.cput.domain.TutorSubject;

import java.util.List;

public interface ITutorSubjectService {
    TutorSubject create(TutorSubject tutorSubject);

    TutorSubject read(String studentSubjectId);

    TutorSubject update(TutorSubject tutorSubject);

    boolean delete(String studentSubjectId);

    List<TutorSubject> getAll();
}
