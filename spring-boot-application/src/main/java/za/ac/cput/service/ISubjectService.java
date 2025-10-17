package za.ac.cput.service;

import za.ac.cput.domain.Subject;

import java.util.List;

public interface ISubjectService {
    Subject create(Subject subject);

    Subject read(String subjectCode);

    Subject update(Subject subject);

    boolean delete(String subjectCode);

    List<Subject> getAll();
}
