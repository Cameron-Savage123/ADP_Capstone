package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.ZonedDateTime;

/* Tutor.java
      Tutor POJO class
     Author: Henzley Spogter (230013309)
     Date: 11 May 2025
     */
@Entity
public class Tutor extends User {

    private String tutorID;
    private double hourlyRate;
    private String bio;
    private double averageRating;
    private boolean verificationStatus;

    //Default constructor
    public Tutor() {
        super();
    }

    //Parameterised constructor
    private Tutor(TutorBuilder builder) {
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.password = builder.password;
        this.createdAt = builder.createdAt;
        this.tutorID = builder.tutorID;
        this.hourlyRate = builder.hourlyRate;
        this.bio = builder.bio;
        this.averageRating = builder.averageRating;
        this.verificationStatus = builder.verificationStatus;
    }

    public String getTutorID() {
        return tutorID;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public String getBio() {
        return bio;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public boolean isVerificationStatus() {
        return verificationStatus;
    }

    @Override
    public String toString() {
        return "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                "Tutor{" +
                "tutorID='" + tutorID + '\'' +
                ", hourlyRate=" + hourlyRate +
                ", bio='" + bio + '\'' +
                ", averageRating=" + averageRating +
                ", verificationStatus=" + verificationStatus +
                '}';
    }

    // Implementation of builder class
    public static class TutorBuilder {
        //User attributes
        private String userId;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String email;
        private String password;
        private ZonedDateTime createdAt;

        //Student attributes
        private String tutorID;
        private double hourlyRate;
        private String bio;
        private double averageRating;
        private boolean verificationStatus;

        public TutorBuilder(String tutorID,
                            double hourlyRate,
                            String bio,
                            double averageRating,
                            boolean verificationStatus) {
            this.tutorID = tutorID;
            this.hourlyRate = hourlyRate;
            this.bio = bio;
            this.averageRating = averageRating;
            this.verificationStatus = verificationStatus;
        }

        public TutorBuilder() {

        }

        public TutorBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public TutorBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public TutorBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public TutorBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public TutorBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public TutorBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public TutorBuilder setCreatedAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public TutorBuilder setTutorID(String tutorID) {
            this.tutorID = tutorID;
            return this;
        }

        public TutorBuilder setHourlyRate(double hourlyRate) {
            this.hourlyRate = hourlyRate;
            return this;
        }

        public TutorBuilder setBio(String bio) {
            this.bio = bio;
            return this;
        }

        public TutorBuilder setAverageRating(double averageRating) {
            this.averageRating = averageRating;
            return this;
        }

        public TutorBuilder setVerificationStatus(boolean verificationStatus) {
            this.verificationStatus = verificationStatus;
            return this;
        }

        public TutorBuilder copy(Tutor tutor) {
            this.userId = tutor.userId;
            this.firstName = tutor.firstName;
            this.lastName = tutor.lastName;
            this.phoneNumber = tutor.phoneNumber;
            this.email = tutor.email;
            this.password = tutor.password;
            this.createdAt = tutor.createdAt;
            this.tutorID = tutor.tutorID;
            this.hourlyRate = tutor.hourlyRate;
            this.bio = tutor.bio;
            this.averageRating = tutor.averageRating;
            this.verificationStatus = tutor.verificationStatus;
            return this;
        }

        public Tutor build() {
            return new Tutor(this);
        }
    }
}
