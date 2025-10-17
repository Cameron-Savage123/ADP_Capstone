/* StudentFactory.java
      Student Factory class
     Author: Henzley Spogter (230013309)
     Date: 18 May 2025
     */

package za.ac.cput.factory;

import za.ac.cput.domain.Student;
import za.ac.cput.util.Helper;

import java.time.ZonedDateTime;

public class StudentFactory {
    public static Student createStudent(String firstName,
                                        String lastName,
                                        String phoneNumber,
                                        String email,
                                        String password,
                                        String studentNumber,
                                        String studentCourse,
                                        String yearOfStudy) {

        // check for null or empty
        if (Helper.isNullOrEmpty(studentNumber) ||
                Helper.isNullOrEmpty(studentCourse) ||
                Helper.isNullOrEmpty(yearOfStudy)) {
            throw new IllegalArgumentException("Missing student-specific fields");
        }

        //validate studentNumber
        if (!Helper.isValidStudentNumber(studentNumber)) {
            throw new IllegalArgumentException("Invalid student number");
        }

        // validate studentCourse
        if (!Helper.isValidStudentCourse(studentCourse)) {
            throw new IllegalArgumentException("Invalid student course");
        }

        // validate yearOfStudy
        if (!Helper.isValidYearOfStudy(yearOfStudy)) {
            throw new IllegalArgumentException("Invalid year of study");
        }

        //User factory
        String userId = UserFactory.validateCommonAndGenerateId(
                firstName, lastName, phoneNumber, email, password);

        // generate unique studentID
        String studentID = Helper.generateId();

        return new Student.StudentBuilder()
                .setUserId(userId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setPassword(password)
                .setCreatedAt(ZonedDateTime.now())
                .setStudentId(studentID)
                .setStudentNumber(studentNumber)
                .setStudentCourse(studentCourse)
                .setYearOfStudy(yearOfStudy)
                .build();
    }
}
