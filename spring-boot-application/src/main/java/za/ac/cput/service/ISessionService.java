package za.ac.cput.service;

import za.ac.cput.domain.Session;

import java.util.List;

/*  ISessionService.java
    Session Service interface
    Author: Angelo Smidt - 230688020
    Date: 25 May 2025
 */
public interface ISessionService {
    Session create(Session session);

    Session read(String sessionId);

    Session update(Session session);

    boolean delete(String sessionId);

    List<Session> getAll();
}
