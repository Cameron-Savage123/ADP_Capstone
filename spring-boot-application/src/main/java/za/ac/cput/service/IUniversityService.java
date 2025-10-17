package za.ac.cput.service;

import za.ac.cput.domain.University;

import java.util.List;

/*  IUniversityService.java
    University Service interface
    Author: Angelo Smidt - 230688020
    Date: 25 May 2025
 */
public interface IUniversityService {
    University create(University university);

    University read(String universityId);

    University update(University university);

    boolean delete(String universityId);

    List<University> getAll();
}
