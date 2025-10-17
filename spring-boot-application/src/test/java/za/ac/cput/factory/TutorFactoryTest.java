package za.ac.cput.factory;
/*  TutorFactoryTest.java
    Tutor Factory test class
    Author: Henzley Spogter - 230013309
    Date: 29 August 2025
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Tutor;

import static org.junit.jupiter.api.Assertions.*;

class TutorFactoryTest {

    @Test
    void createTutor_withValidData_returnsTutor() {
        Tutor tutor = TutorFactory.createTutor(
                "Alice",
                "Smith",
                "0723456789",
                "alice.smith@gmail.com",
                "SecurePass123!",
                250.0,                      // hourly rate
                "Experienced Java tutor.",  // bio
                4.8,                        // average rating
                true                        // verification status
        );

        // user-level fields
        assertNotNull(tutor);
        assertNotNull(tutor.getUserId());
        assertEquals("Alice", tutor.getFirstName());
        assertEquals("Smith", tutor.getLastName());
        assertEquals("0723456789", tutor.getPhoneNumber());
        assertEquals("alice.smith@gmail.com", tutor.getEmail());
        assertEquals("SecurePass123!", tutor.getPassword());

        // tutor-level fields
        assertNotNull(tutor.getTutorID());
        assertEquals(250.0, tutor.getHourlyRate());
        assertEquals("Experienced Java tutor.", tutor.getBio());
        assertEquals(4.8, tutor.getAverageRating());
        assertTrue(tutor.isVerificationStatus());

        System.out.println(tutor);
    }

    @Test
    void createTutor_withEmptyBio_shouldReturnNull() {
        Tutor tutor = TutorFactory.createTutor(
                "Bob",
                "Johnson",
                "0734567890",
                "bob.johnson@gmail.com",
                "Password123!",
                200.0,
                "",       // empty bio
                4.0,
                false
        );

        assertNull(tutor);
    }

    @Test
    void createTutor_withInvalidBioLength_shouldReturnNull() {
        String longBio = "a".repeat(1000); // assume Helper.isValidBio fails if too long

        Tutor tutor = TutorFactory.createTutor(
                "Charlie",
                "Brown",
                "0745678901",
                "charlie.brown@gmail.com",
                "Password123!",
                300.0,
                longBio,
                3.5,
                false
        );

        assertNull(tutor);
    }
}
