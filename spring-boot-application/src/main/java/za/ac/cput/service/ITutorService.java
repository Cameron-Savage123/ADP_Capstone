package za.ac.cput.service;
/* ITutorService.java
      ITutor Service Interface
     Author: Henzley Spogter (230013309)
     Date: 23 August 2025
     */

import za.ac.cput.domain.Tutor;

import java.util.List;

public interface ITutorService {
    Tutor create(Tutor tutor);

    Tutor read(String tutorID);

    Tutor update(Tutor tutor);

    boolean delete(String tutorID);

    List<Tutor> getAll();
}
