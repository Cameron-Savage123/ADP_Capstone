package za.ac.cput.service;
/*  SessionServiceTest.java
    Session Service test class
    Author: Angelo Smidt - 230688020
    Date: 25 May 2025
 */

import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Session;
import za.ac.cput.factory.SessionFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.MethodName.class)
public class SessionServiceTest {

    private SessionService service;
    LocalDateTime startTime1 = LocalDateTime.of(2025, 5, 18, 12, 0);
    LocalDateTime endTime1 = LocalDateTime.of(2025, 5, 18, 13, 0);

    private Session session = SessionFactory.createSession(startTime1, endTime1, "Library", "Physical", 25, "Underway", "None");

    @Test
    void a_create() {
        Session created = service.create(session);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        Session read = service.read(session.getSessionId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Session newSession = new Session.SessionBuilder().copy(session).location("District Six").build();
        Session updated = service.update(newSession);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void e_getAll() {
        System.out.println(service.getAll());
    }
}
