package za.ac.cput.service;
/*  SessionService.java
    Session Service class
    Author: Angelo Smidt - 230688020
    Date: 25 May 2025
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Session;
import za.ac.cput.repository.SessionRepository;

import java.util.List;

@Service
public class SessionService implements ISessionService {

    @Autowired
    private static ISessionService service;

    private SessionRepository repository;

    @Override
    public Session create(Session session) {
        return this.repository.save(session);
    }

    @Override
    public Session read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Session update(Session session) {
        return this.repository.save(session);
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        return true;
    }

    @Override
    public List<Session> getAll() {
        return this.repository.findAll();
    }
}
