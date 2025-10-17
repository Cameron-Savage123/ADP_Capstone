package za.ac.cput.factory;
/*  StudentFactoryTest.java
    Student Factory test class
    Author: Henzley Spogter - 230013309
    Date: 29 August 2025
 */


import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

    @Test
    void createStudent_withValidData_returnsStudent() {
        Student student = StudentFactory.createStudent(
                "John",
                "Doe",
                "0685050842",
                "johndoe@gmail.com",
                "Password123!",
                "230013309",
                "DPICT: Applications Development",
                "3"
        );

        // user fields
        assertNotNull(student.getUserId());
        assertEquals("John", student.getFirstName());
        assertEquals("Doe", student.getLastName());
        assertEquals("0685050842", student.getPhoneNumber());
        assertEquals("johndoe@gmail.com", student.getEmail());
        assertEquals("Password123!", student.getPassword());
        assertNotNull(student.getCreatedAt());

        // student fields
        assertNotNull(student.getStudentId());
        assertEquals("230013309", student.getStudentNumber());
        assertEquals("DPICT: Applications Development", student.getStudentCourse());
        assertEquals("3", student.getYearOfStudy());

        System.out.println(student);
    }

    @Test
    void createStudent_withInvalidStudentNumber_shouldThrow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> StudentFactory.createStudent(
                "Jane",
                "Doe",
                "0685050842",
                "janedoe@gmail.com",
                "Password123!",
                "INVALID#",       // invalid format
                "DPICT: Applications Development",
                "3"
        ));
        assertTrue(exception.getMessage().contains("Invalid student number"));
    }

    @Test
    void createStudent_withEmptyCourse_shouldThrow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> StudentFactory.createStudent(
                "Jane",
                "Doe",
                "0685050842",
                "janedoe@gmail.com",
                "Password123!",
                "ST12345",
                "",                // empty course
                "3"
        ));
        assertTrue(exception.getMessage().contains("Missing student-specific fields"));
    }
}
