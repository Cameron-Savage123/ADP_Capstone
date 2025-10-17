package za.ac.cput.factory;
/*  UniversityFactoryTest.java
    University Factory test class
    Author: Angelo Smidt - 230688020
    Date: 18 May 2025
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.University;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniversityFactoryTest {
    @Test
    void createUniversity_Successful(){
        University university = UniversityFactory.createUniversity("CPUT", "District Six", "Idk");
        assertEquals("CPUT", university.getUniversityName());
        assertEquals("District Six", university.getLocation());
        assertEquals("Idk", university.getDomain());

    }
}
