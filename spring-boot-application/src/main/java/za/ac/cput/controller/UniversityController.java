package za.ac.cput.controller;
/*  UniversityController.java
    University Controller class
    Author: Angelo Smidt - 230688020
    Date: 18 September 2025
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.University;
import za.ac.cput.service.UniversityService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/university")

public class UniversityController {
    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping("/create")
    public University createUniversity(@RequestBody University university) {
        return universityService.createUniversity(university);
    }

    @GetMapping("/read/{universityId}")
    public University readUniversity(@PathVariable String universityId) {
        return universityService.readUniversity(universityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "University not found"));
    }

    @PutMapping("/update")
    public University updateUniversity(@RequestBody University university) {
        return universityService.updateUniversity(university);
    }

    @DeleteMapping("/delete/{universityId}")
    public void deleteUniversity(@PathVariable String universityId) {
        universityService.deleteUniversity(universityId);
    }

    @GetMapping("/all")
    public List<University> getAllUniversities() {
        return universityService.getAllUniversities();
    }

    @GetMapping("/test")
    public String test() {
        return "University controller works!";
    }
}
