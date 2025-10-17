package za.ac.cput.controller;
/*keewan Titus
230778577
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Subject;

import za.ac.cput.service.SubjectService;


import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectService service;
    @Autowired

    public SubjectController(SubjectService service) {
        this.service = service;

    }
    @PostMapping("/create")
    public ResponseEntity<Subject> create(@RequestBody Subject subject) {
        return ResponseEntity.ok(service.create(subject));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Subject> read(@PathVariable String id) {
        Subject s=service.read(id);
        return s !=null ? ResponseEntity.ok(s):ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Subject> update(@PathVariable String id, @RequestBody Subject updated) {
        Subject existing=service.read(id);
        if(existing==null)return ResponseEntity.notFound().build();

        Subject updatedSubject=new Subject.SubjectBuilder()
                .copy(existing)

                .setSubjectName(updated.getSubjectName())
                .setSubjectDescription(updated.getSubjectDescription())
                .setDepartment(updated.getDepartment())
                .setDifficultyLevel(updated.getDifficultyLevel())
                .build();


        return ResponseEntity.ok(service.update(updatedSubject));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return service.delete(id)? ResponseEntity.ok().build():ResponseEntity.notFound().build();

    }
    @GetMapping("/all")
    public ResponseEntity<List<Subject>> getAll() {
        return ResponseEntity.ok(service.getAll());

    }

}

