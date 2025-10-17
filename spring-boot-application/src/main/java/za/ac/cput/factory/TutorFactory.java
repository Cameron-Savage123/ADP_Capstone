/* TutorFactory.java
      Tutor factory class
     Author: Henzley Spogter (230013309)
     Date: 18 May 2025
     */

package za.ac.cput.factory;

import za.ac.cput.domain.Tutor;
import za.ac.cput.util.Helper;

public class TutorFactory {
    public static Tutor createTutor(String firstName,
                                    String lastName,
                                    String phoneNumber,
                                    String email,
                                    String password,
                                    double hourlyRate,
                                    String bio,
                                    double averageRating,
                                    boolean verificationStatus) {

        // check for null or empty
        if (Helper.isNullOrEmpty(bio) ||
                Helper.isNullOrEmpty(String.valueOf(hourlyRate)) ||
                Helper.isNullOrEmpty(String.valueOf(averageRating))) {
            return null;
        }

        // validate bio length
        if (!Helper.isValidBio(bio)) {
            return null;
        }

        //generate tutorID
        String tutorID = Helper.generateId();

        //User factory
        String userId = UserFactory.validateCommonAndGenerateId(
                firstName, lastName, phoneNumber, email, password);

        return new Tutor.TutorBuilder()
                .setUserId(userId)        // Pass the User data
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setPassword(password)
                .setTutorID(tutorID)
                .setHourlyRate(hourlyRate)
                .setBio(bio)
                .setAverageRating(averageRating)
                .setVerificationStatus(verificationStatus)
                .build();
    }
}
