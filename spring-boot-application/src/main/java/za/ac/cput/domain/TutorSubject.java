package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/* TutorSubject.java

     TutorSubject POJO class

     Author: Keewan Titus (230778577)

     Date: 04 May 2025 */
@Entity
public class TutorSubject {
    @Id
    private String tutorID;
    private String studentSubjectId;
    private String proficiencyLevel;
    private double specializedRate;

    private TutorSubject(TutorSubjectBuilder builder) {
        this.studentSubjectId = builder.studentSubjectId;
        this.proficiencyLevel = builder.proficiencyLevel;
        this.specializedRate = builder.specializedRate;
    }

    public TutorSubject() {

    }

    public String getStudentSubjectId() {
        return studentSubjectId;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public double getSpecializedRate() {
        return specializedRate;
    }

    @Override
    public String toString() {
        return "TutorSubject+ " + studentSubjectId + ", " +
                "proficiencyLevel=" + proficiencyLevel + ", specializedRate=" + specializedRate;


    }

    public static class TutorSubjectBuilder {
        private String studentSubjectId;
        private String proficiencyLevel;
        private double specializedRate;

        public TutorSubjectBuilder setStudentSubjectId(String studentSubjectId) {
            this.studentSubjectId = studentSubjectId;
            return this;
        }

        public TutorSubjectBuilder setProficiencyLevel(String proficiencyLevel) {
            this.proficiencyLevel = proficiencyLevel;
            return this;

        }

        public TutorSubjectBuilder setSpecializedRate(double specializedRate) {
            this.specializedRate = specializedRate;
            return this;
        }

        public TutorSubjectBuilder copy(TutorSubject tutor) {
            this.studentSubjectId = tutor.studentSubjectId;
            this.proficiencyLevel = tutor.proficiencyLevel;
            this.specializedRate = tutor.specializedRate;
            return this;
        }

        public TutorSubject build() {
            return new TutorSubject(this);
        }
    }
}
