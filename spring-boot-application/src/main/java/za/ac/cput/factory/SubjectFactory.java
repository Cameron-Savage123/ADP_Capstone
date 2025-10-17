package za.ac.cput.factory;

import za.ac.cput.domain.Subject;
import za.ac.cput.util.Helper;

public class SubjectFactory {
    public static Subject createSubject(String subjectCode,
                                        String subjectName,
                                        String subjectDescription,
                                        String department,
                                        String difficultyLevel) {

        if (Helper.isNullOrEmpty(subjectCode)) {
            return null;
        }
        if (Helper.isNullOrEmpty(difficultyLevel)) {
            return null;
        }


        return new Subject.SubjectBuilder()
                .setSubjectCode(subjectCode)
                .setSubjectName(subjectName)
                .setSubjectDescription(subjectDescription)
                .setDepartment(department)
                .setDifficultyLevel(difficultyLevel)
                .build();


    }
}
