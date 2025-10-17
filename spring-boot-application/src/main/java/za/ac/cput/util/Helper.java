package za.ac.cput.util;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

    //generate unique ID
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    // check for nulls and empty inputs
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    // email validation
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    // User firstName validation
    private static final String FIRST_NAME_REGEX = "^[a-zA-Z]+(?:[\\s-'][a-zA-Z]+)*$";

    public static boolean isValidFirstName(String firstName) {
        Pattern pattern = Pattern.compile(FIRST_NAME_REGEX);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }


    // User lastName validation
    private static final String LAST_NAME_REGEX = "^[a-zA-Z]+(?:[\\s-'][a-zA-Z]+)*$";

    public static boolean isValidLastName(String lastName) {
        Pattern pattern = Pattern.compile(LAST_NAME_REGEX);
        Matcher matcher = pattern.matcher(lastName);
        return matcher.matches();
    }


    // User password validation
    private static final String PASSWORD_REGEX =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()+=])(?=\\S+$).{8,20}$";

    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    public static boolean isValidPassword(final String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    // User phoneNumber validation
    public static boolean isValidPhone(String phoneNumber) {
        String valid = "^$|(\\+27|0)[1-8][0-9]{8}$";
        return phoneNumber.matches(valid);
    }

    // studentNumber validation
    public static boolean isValidStudentNumber(String studentNumber) {
        return studentNumber.length() == 9;
    }


    //studentCourse validation
    public static boolean isValidStudentCourse (String studentCourse) {
        return studentCourse.equals("DPICT: Applications Development") || studentCourse.equals("DPICT: Multimedia") ||
                studentCourse.equals("DPICT: Communications Network");
    }


    //year of study validation (accepts only "1", "2", "3", "4")
    public static boolean isValidYearOfStudy(String yearOfStudy) {
        if (isNullOrEmpty(yearOfStudy)) {
            return false;
        }
        return yearOfStudy.equals("1") || yearOfStudy.equals("2") ||
                yearOfStudy.equals("3") || yearOfStudy.equals("4");
    }

    // Tutor hourlyRate validation


    //Tutor bio validation
    public static boolean isValidBio(String bio) {
        return bio.length() <= 150;
    }

    // specializedRate validation
    public static boolean isValidSpecializedRate(double specializedRate) {
        if (specializedRate >= 0.00 || specializedRate <= 10.00) {
            return false;
        }
        return true;
    }
}




