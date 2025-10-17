package za.ac.cput.factory;
/*  UniversityFactory.java
    University Factory class
    Author: Angelo Smidt - 230688020
    Date: 18 May 2025
 */

import za.ac.cput.domain.University;
import za.ac.cput.util.Helper;

public class UniversityFactory {
    public static University createUniversity(String universityName,
                                              String location,
                                              String domain) {

        String universityId = Helper.generateId();

        return new University.UniversityBuilder()
                .universityId(universityId)
                .universityName(universityName)
                .location(location)
                .domain(domain)
                .build();
    }
}
