package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Subject;

import static org.junit.jupiter.api.Assertions.*;

class SubjectFactoryTest {

    @Test
    void createSubject() {
        Subject subject= SubjectFactory.createSubject("ADP3","Application Development",
                "ADP","IT","9");
        assertNotNull(subject);
        assertEquals("ADP3", subject.getSubjectCode());
        assertEquals("Application Development", subject.getSubjectName());
        assertEquals("ADP", subject.getSubjectDescription());
        assertEquals("IT", subject.getDepartment());
        assertEquals("9", subject.getDifficultyLevel());
        System.out.println(subject);




    }
}