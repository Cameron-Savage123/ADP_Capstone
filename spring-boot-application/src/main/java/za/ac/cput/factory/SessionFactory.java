package za.ac.cput.factory;
/*  SessionFactory.java
    Session Factory class
    Author: Angelo Smidt - 230688020
    Date: 18 May 2025
 */

import za.ac.cput.domain.Session;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

public class SessionFactory {
    public static Session createSession(LocalDateTime startTime,
                                        LocalDateTime endTime,
                                        String location,
                                        String mode,
                                        double cost,
                                        String status,
                                        String notes) {

        String sessionId = Helper.generateId();

        return new Session.SessionBuilder()
                .sessionId(sessionId)
                .startTime(startTime)
                .endTime(endTime)
                .location(location)
                .mode(mode)
                .cost(cost)
                .status(status)
                .notes(notes)
                .build();
    }
}
