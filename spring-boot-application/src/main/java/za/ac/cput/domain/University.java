package za.ac.cput.domain;
/*  University.java
    University Domain class
    Author: Angelo Smidt - 230688020
    Date: 11 May 2025
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class University {
    @Id
    private String universityId;
    private String universityName;
    private String location;
    private String domain;

    //Default constructor
    public University() {
    }

    //Constructor with parameters
    public University(String universityId, String domain, String location, String universityName) {
        this.universityId = universityId;
        this.domain = domain;
        this.location = location;
        this.universityName = universityName;
    }

    //Constructor for UniversityBuilder
    public University(UniversityBuilder builder) {
        this.universityId = builder.universityId;
        this.universityName = builder.universityName;
        this.location = builder.location;
        this.domain = builder.domain;
    }

    //Getters
    public String getUniversityId() {
        return universityId;
    }

    public String getDomain() {
        return domain;
    }

    public String getLocation() {
        return location;
    }

    public String getUniversityName() {
        return universityName;
    }

    //Overridden toString
    @Override
    public String toString() {
        return "University{" +
                "universityId='" + universityId + '\'' +
                ", universityName='" + universityName + '\'' +
                ", location='" + location + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }

    //University builder class
    public static class UniversityBuilder {
        private String universityId;
        private String universityName;
        private String location;
        private String domain;

        public UniversityBuilder universityId(String universityId) {
            this.universityId = universityId;
            return this;
        }

        public UniversityBuilder universityName(String universityName) {
            this.universityName = universityName;
            return this;
        }

        public UniversityBuilder location(String location) {
            this.location = location;
            return this;
        }

        public UniversityBuilder domain(String domain) {
            this.domain = domain;
            return this;
        }

        /*build() method that returns a University object
        calling constructor of outer class
        and supplying an object of this class (UniversityBuilder)
        which is passed to the outer constructor to define all  the instance variables*/
        public University build() {
            return new University(this);
        }

        public UniversityBuilder copy(University university) {
            this.universityId = university.universityId;
            this.universityName = university.universityName;
            this.location = university.location;
            this.domain = university.domain;
            return null;
        }
    }
}
