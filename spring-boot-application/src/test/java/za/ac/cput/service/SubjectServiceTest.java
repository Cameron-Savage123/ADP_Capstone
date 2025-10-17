package za.ac.cput.service;
/* Subject.java

     SubjectServiceTest POJO class

     Author: Keewan Titus (230778577)

     Date: 25 May 2025 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.factory.SubjectFactory;
import za.ac.cput.domain.Subject;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class SubjectServiceTest {
    private SubjectService service;
    private Subject subject= SubjectFactory.createSubject("ADP3","Application Development","ADP","IT","9");

    @Test
    void a_create() {
        Subject created = service.create(subject);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        Subject read=service.read(subject.getSubjectCode());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Subject updated=new Subject .SubjectBuilder().copy(subject).setSubjectName("Information Systems")
        .build();
        assertNotNull(updated);
        System.out.println(updated);

    }

    @Test
    void getAll() {
        System.out.println(service.getAll());
    }


}