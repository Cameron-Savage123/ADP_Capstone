package za.ac.cput.factory;

/*  UserFactory.java
    User Factory class
    Author: Hope Ringane (221174109)
    Date: 18 May 2025
 */


import za.ac.cput.util.Helper;

public final class UserFactory {

    public static String validateCommonAndGenerateId(String firstName,
                                                     String lastName,
                                                     String phoneNumber,
                                                     String email,
                                                     String password) {

        // check if values are null or empty
        if (Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(phoneNumber) ||
                Helper.isNullOrEmpty(email) ||
                Helper.isNullOrEmpty(password)) {
            throw new IllegalArgumentException("Missing required fields");
        }

        // check if firstName is valid
        if (!Helper.isValidFirstName(firstName)) {
            throw new IllegalArgumentException("Invalid first name");
        }

        // check if lastName is valid
        if (!Helper.isValidLastName(lastName)) {
            throw new IllegalArgumentException("Invalid last name");
        }

        // check if phoneNumber is valid
        if (!Helper.isValidPhone(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        // check if email is valid
        if (!Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }

        // check if password is valid
        if (!Helper.isValidPassword(password)) {
            throw new IllegalArgumentException("Invalid password");
        }

        // generate unique userId
        return Helper.generateId(); // userId
    }
}

