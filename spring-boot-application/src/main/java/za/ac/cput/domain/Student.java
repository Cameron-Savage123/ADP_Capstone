package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.ZonedDateTime;

/* Student.java
      Tutor POJO class
     Author: Henzley Spogter (230013309)
     Date: 11 May 2025
     */
@Entity
public class Student extends User {

    private String studentID;
    private String studentNumber;
    private String studentCourse;
    private String yearOfStudy;

    public Student() {
        super();
    }

    private Student(StudentBuilder builder) {
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.password = builder.password;
        this.createdAt = builder.createdAt;
        this.studentID = builder.studentId;
        this.studentNumber = builder.studentNumber;
        this.studentCourse = builder.studentCourse;
        this.yearOfStudy = builder.yearOfStudy;
    }

    public String getStudentId() {
        return studentID;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    @Override
    public String toString() {
        return
                "userId='" + userId + '\'' +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", phoneNumber='" + phoneNumber + '\'' +
                        ", email='" + email + '\'' +
                        ", password='" + password + '\'' +
                        ", createdAt=" + createdAt + '}' +
                        "Student{" +
                        "studentID='" + studentID + '\'' +
                        ", studentNumber='" + studentNumber + '\'' +
                        ", studentCourse='" + studentCourse + '\'' +
                        ", yearOfStudy='" + yearOfStudy + '\'';
    }

    //Implementation of the builder class
    public static class StudentBuilder {

        //User attributes
        private String userId;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String email;
        private String password;
        private ZonedDateTime createdAt;

        //Student attributes
        private String studentId;
        private String studentNumber;
        private String studentCourse;
        private String yearOfStudy;

        public StudentBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public StudentBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public StudentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public StudentBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public StudentBuilder setCreatedAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public StudentBuilder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public StudentBuilder setStudentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        public StudentBuilder setStudentCourse(String studentCourse) {
            this.studentCourse = studentCourse;
            return this;
        }

        public StudentBuilder setYearOfStudy(String yearOfStudy) {
            this.yearOfStudy = yearOfStudy;
            return this;
        }

        public StudentBuilder copy(Student student) {
            this.userId = student.userId;
            this.firstName = student.firstName;
            this.lastName = student.lastName;
            this.phoneNumber = student.phoneNumber;
            this.email = student.email;
            this.password = student.password;
            this.createdAt = student.createdAt;
            this.studentId = student.studentID;
            this.studentNumber = student.studentNumber;
            this.studentCourse = student.studentCourse;
            this.yearOfStudy = student.yearOfStudy;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}


