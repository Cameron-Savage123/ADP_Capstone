package za.ac.cput.factory;

import za.ac.cput.domain.TutorSubject;
import za.ac.cput.util.Helper;

public class TutorSubjectFactory {

    public static TutorSubject createTutorSubject(String proficiencyLevel,
                                                  double specializedRate) {

        String studentSubjectId = Helper.generateId();

        if (Helper.isValidSpecializedRate(specializedRate)) {
            return null;

        }

        return new TutorSubject.TutorSubjectBuilder()
                .setStudentSubjectId(studentSubjectId)
                .setProficiencyLevel(proficiencyLevel)
                .setSpecializedRate(specializedRate)
                .build();


    }
}
