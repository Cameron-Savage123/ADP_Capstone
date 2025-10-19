package za.ac.cput.controller;
/*  SessionControllerTest.java
    Session Controller test class
    Author: Angelo Smidt - 230688020
    Date: 18 September 2025
 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import za.ac.cput.domain.Session;
import za.ac.cput.factory.SessionFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SessionControllerTest {

    private static Session session;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getBaseUrl() {
        return "http://localhost:" + port + "/TutorMe-ADP3-Capstone/spring-boot-application/payment";
    }

    @BeforeAll
    public static void setup() {
        LocalDateTime startTime1 = LocalDateTime.of(2025, 5, 18, 12, 0);
        LocalDateTime endTime1 = LocalDateTime.of(2025, 5, 18, 13, 0);
        session = SessionFactory.createSession(
                "sess02",               // sessionId
                startTime1,             // startTime
                endTime1,               // endTime
                "Bellville Library",    // location
                "In-person",            // mode
                20.50,                  // cost
                "Pending",              // status
                "None",                 // notes
        );
    }

    @Test
    @Order(1)
    void createSession() {
        String url = getBaseUrl() + "/create";
        ResponseEntity<Session> response = restTemplate.postForEntity(url, session, Session.class);
        assertNotNull(response.getBody());
        session = response.getBody();
        System.out.println("Created_Session: " + session);
    }

    @Test
    @Order(2)
    void readSession() {
        String url = getBaseUrl() + "/read/" + session.getSessionId();
        ResponseEntity<Session> response = restTemplate.getForEntity(url, Session.class);
        assertNotNull(response.getBody());
        assertEquals(session.getSessionId(), response.getBody().getSessionId());
        System.out.println("Read_Session: " + response.getBody());
    }

    @Test
    @Order(3)
    void updateSession() {
        Session updatedSession = new Session.SessionBuilder()
                .copy(session)
                .setStatus("Complete")
                .build();

        String url = getBaseUrl() + "/update";
        ResponseEntity<Session> response = restTemplate.exchange(
                url, HttpMethod.PUT, new HttpEntity<>(updatedSession), Session.class);

        assertNotNull(response.getBody());
        assertEquals(updatedSession.getLocation(), response.getBody().getLocation());
        System.out.println("Updated_Session: " + response.getBody());
    }

    @Test
    @Order(4)
    void deleteSession() {
        String url = getBaseUrl() + "/delete/" + session.getSessionId();
        restTemplate.delete(url);

        ResponseEntity<Session> response = restTemplate.getForEntity(getBaseUrl() + "/read/" + session.getSessionId(), Session.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        System.out.println("Deleted_Session: Status " + response.getStatusCode());
    }
}