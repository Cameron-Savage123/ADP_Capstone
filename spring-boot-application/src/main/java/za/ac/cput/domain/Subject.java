package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/* Subject.java

     Subject POJO class

     Author: Keewan Titus (230778577)

     Date: 04 May 2025 */
@Entity
public class Subject {
    @Id
    private String subjectCode;
    private String subjectName;
    private String subjectDescription;
    private String department;
    private String difficultyLevel;

    private Subject(SubjectBuilder builder) {
        this.subjectCode = builder.subjectCode;
        this.subjectName = builder.subjectName;
        this.subjectDescription = builder.subjectDescription;
        this.department = builder.department;
        this.difficultyLevel = builder.difficultyLevel;

    }

    public Subject() {

    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public String getDepartment() {
        return department;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    @Override
    public String toString() {
        return "Subject= " + subjectCode + ", subjectName= " + subjectName + ", subjectDescription= "
                + subjectDescription + ", department= " + department + ", difficultyLevel= " + difficultyLevel;
    }

    public static class SubjectBuilder {
        private String subjectCode;
        private String subjectName;
        private String subjectDescription;
        private String department;
        private String difficultyLevel;

        public SubjectBuilder setSubjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
            return this;
        }

        public SubjectBuilder setSubjectName(String subjectName) {
            this.subjectName = subjectName;
            return this;
        }

        public SubjectBuilder setSubjectDescription(String subjectDescription) {
            this.subjectDescription = subjectDescription;
            return this;

        }

        public SubjectBuilder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public SubjectBuilder setDifficultyLevel(String difficultyLevel) {
            this.difficultyLevel = difficultyLevel;
            return this;
        }

        public Subject build() {
            return new Subject(this);
        }

        public SubjectBuilder copy(Subject subject) {
            this.subjectCode = subject.subjectCode;
            this.subjectName = subject.subjectName;
            this.subjectDescription = subject.subjectDescription;
            this.department = subject.department;
            this.difficultyLevel = subject.difficultyLevel;
            return this;
        }
    }

}
