package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.TutorSubject;

import static org.junit.jupiter.api.Assertions.*;

class TutorSubjectFactoryTest {

    @Test
    void createTutorSubject() {
        TutorSubject tutorsubject= TutorSubjectFactory.createTutorSubject("Degree",
                9.00);
        assertNotNull(tutorsubject);
        assertEquals("Degree",tutorsubject.getProficiencyLevel() );
        assertEquals(9.00,tutorsubject.getSpecializedRate());
        System.out.println(tutorsubject);
    }
}