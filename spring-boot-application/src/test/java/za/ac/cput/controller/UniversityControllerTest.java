package za.ac.cput.controller;
/*  UniversityControllerTest.java
    University Controller test class
    Author: Angelo Smidt - 230688020
    Date: 18 September 2025
 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import za.ac.cput.domain.University;
import za.ac.cput.factory.UniversityFactory;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UniversityControllerTest {

    private static University university;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getBaseUrl() {
        return "http://localhost:" + port + "/TutorMe-ADP3-Capstone/spring-boot-application/payment";
    }

    @BeforeAll
    public static void setup() {
        university = UniversityFactory.createUniversity(
                "CPUT021",                                 // universityId
                "Cape Peninsula University of Technology", // universityName
                "Cape Town, District Six",                 // location
                "District Six",                            // domain
        );
    }

    @Test
    @Order(1)
    void createUniversity() {
        String url = getBaseUrl() + "/create";
        ResponseEntity<University> response = restTemplate.postForEntity(url, university, University.class);
        assertNotNull(response.getBody());
        university = response.getBody();
        System.out.println("Created_University: " + university);
    }

    @Test
    @Order(2)
    void readUniversity() {
        String url = getBaseUrl() + "/read/" + university.getUniversityId();
        ResponseEntity<University> response = restTemplate.getForEntity(url, University.class);
        assertNotNull(response.getBody());
        assertEquals(university.getUniversityId(), response.getBody().getUniversityId());
        System.out.println("Read_University: " + response.getBody());
    }

    @Test
    @Order(3)
    void updateUniversity() {
        University updatedUniversity = new University.UniversityBuilder()
                .copy(university)
                .setLocation("Cape Town")
                .build();

        String url = getBaseUrl() + "/update";
        ResponseEntity<University> response = restTemplate.exchange(
                url, HttpMethod.PUT, new HttpEntity<>(updatedUniversity), University.class);

        assertNotNull(response.getBody());
        assertEquals(updatedUniversity.getLocation(), response.getBody().getLocation());
        System.out.println("Updated_University: " + response.getBody());
    }

    @Test
    @Order(4)
    void deleteUniversity() {
        String url = getBaseUrl() + "/delete/" + university.getUniversityId();
        restTemplate.delete(url);

        ResponseEntity<University> response = restTemplate.getForEntity(getBaseUrl() + "/read/" + university.getUniversityId(), University.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        System.out.println("Deleted_University: Status " + response.getStatusCode());
    }
}