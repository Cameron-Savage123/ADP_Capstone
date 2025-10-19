package za.ac.cput.controller;
/*  SessionController.java
    Session Controller class
    Author: Angelo Smidt - 230688020
    Date: 18 September 2025
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Session;
import za.ac.cput.service.SessionService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/session")

public class SessionController {
    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping("/create")
    public Session createSession(@RequestBody Session session) {
        return sessionService.createSession(session);
    }

    @GetMapping("/read/{sessionId}")
    public Session readSession(@PathVariable String sessionId) {
        return sessionService.readSession(sessionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Session not found"));
    }

    @PutMapping("/update")
    public Session updateSession(@RequestBody Session session) {
        return sessionService.updateSession(session);
    }

    @DeleteMapping("/delete/{sessionId}")
    public void deleteSession(@PathVariable String sessionId) {
        sessionService.deleteSession(sessionId);
    }

    @GetMapping("/all")
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @GetMapping("/test")
    public String test() {
        return "Session controller works!";
    }
}
