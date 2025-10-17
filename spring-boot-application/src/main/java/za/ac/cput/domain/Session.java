package za.ac.cput.domain;
/*  Session.java
    Session Domain class
    Author: Angelo Smidt - 230688020
    Date: 11 May 2025
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;
@Entity
public class Session {
    @Id
    private String sessionId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    private String mode;
    private double cost;
    private String status;
    private String notes;

    //Default constructor
    public Session() {
    }

    //Constructor with parameters
    public Session(String sessionId, LocalDateTime startTime, LocalDateTime endTime, String location, String mode, double cost, String status, String notes) {
        this.sessionId = sessionId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.mode = mode;
        this.cost = cost;
        this.status = status;
        this.notes = notes;
    }

    //Constructor for SessionBuilder
    public Session(SessionBuilder builder) {
        this.sessionId = builder.sessionId;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.location = builder.location;
        this.mode = builder.mode;
        this.cost = builder.cost;
        this.status = builder.status;
        this.notes = builder.notes;
    }

    //Getters
    public String getSessionId() {
        return sessionId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getLocation() {
        return location;
    }

    public String getMode() {
        return mode;
    }

    public double getCost() {
        return cost;
    }

    public String getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    //Overridden toString
    @Override
    public String toString() {
        return "Session{" +
                "sessionId='" + sessionId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", location='" + location + '\'' +
                ", mode='" + mode + '\'' +
                ", cost=" + cost +
                ", status='" + status + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }

    //Session builder class
    public static class SessionBuilder {
        private String sessionId;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private String location;
        private String mode;
        private double cost;
        private String status;
        private String notes;

        public SessionBuilder sessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        public SessionBuilder startTime(LocalDateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public SessionBuilder endTime(LocalDateTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public SessionBuilder location(String location) {
            this.location = location;
            return this;
        }

        public SessionBuilder mode(String mode) {
            this.mode = mode;
            return this;
        }

        public SessionBuilder cost(double cost) {
            this.cost = cost;
            return this;
        }

        public SessionBuilder status(String status) {
            this.status = status;
            return this;
        }

        public SessionBuilder notes(String notes) {
            this.notes = notes;
            return this;
        }

        /*build() method that returns a Session object
            calling constructor of outer class
            and supplying an object of this class (SessionBuilder)
            which is passed to the outer constructor to define all  the instance variables*/
        public Session build() {
            return new Session(this);
        }

        public SessionBuilder copy(Session session) {
            this.sessionId = session.sessionId;
            this.startTime = session.startTime;
            this.endTime = session.endTime;
            this.location = session.location;
            this.mode = session.mode;
            this.cost = session.cost;
            this.status = session.status;
            this.notes = session.notes;
            return null;
        }
    }

}
