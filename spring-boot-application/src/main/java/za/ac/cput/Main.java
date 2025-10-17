package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Tutor;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.factory.TutorFactory;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        // test creation of student object
        Student student1 = StudentFactory.createStudent(
                "Henzley",
                "Spogter",
                "0685050842",
                "230013309@mycput.ac.za",
                "@StrongPass123",
                "230013309",
                "DPICT: Multimedia",
                "3");
//        System.out.println(student1);


        // test creation of tutor object
        Tutor tutor1 = TutorFactory.createTutor(
                "Greg",
                "Heffley",
                "0818808982",
                "gHeffley@gmail.com",
                "@StrongPass123",
                100.00,
                "I am a student who is eager to help you improve your programming skills and help you along your coding journey",
                4.5,
                true);
//        System.out.println(tutor1);

    }
}

//docpat-qitceH-mahhi5