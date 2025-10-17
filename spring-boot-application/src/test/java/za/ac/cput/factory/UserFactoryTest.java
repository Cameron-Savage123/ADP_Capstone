package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void validateCommonAndGenerateId_withValidData_returnsId() {
        String userId = UserFactory.validateCommonAndGenerateId(
                "John",
                "Doe",
                "0685050842",
                "johndoe@gmail.com",
                "Password123!"
        );

        assertNotNull(userId);        // userId should be generated
        assertFalse(userId.isEmpty()); // not an empty string

        System.out.println("Generated userId: " + userId);
    }

    @Test
    void validateCommonAndGenerateId_withInvalidEmail_shouldThrow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> UserFactory.validateCommonAndGenerateId(
                "Jane",
                "Doe",
                "0685050842",
                "not-an-email",
                "Password123!"
        ));

        assertTrue(exception.getMessage().contains("Invalid email"));
    }

    @Test
    void validateCommonAndGenerateId_withEmptyFirstName_shouldThrow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> UserFactory.validateCommonAndGenerateId(
                "",
                "Doe",
                "0685050842",
                "janedoe@gmail.com",
                "Password123!"
        ));

        assertTrue(exception.getMessage().contains("Missing required fields"));
    }
}
