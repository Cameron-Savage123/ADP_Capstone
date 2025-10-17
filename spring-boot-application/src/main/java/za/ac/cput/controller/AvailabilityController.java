package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Availability;
import za.ac.cput.service.AvailabilityService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    private final AvailabilityService service;

    @Autowired
    public AvailabilityController(AvailabilityService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Availability> create(@RequestBody Availability availability) {
        return ResponseEntity.ok(service.create(availability));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Availability> read(@PathVariable Long id) {
        Availability a = service.read(id);
        return a != null ? ResponseEntity.ok(a) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Availability> update(@PathVariable Long id, @RequestBody Availability updated) {
        Availability existing = service.read(id);
        if (existing == null) return ResponseEntity.notFound().build();

        Availability updatedAvailability = new Availability.Builder()
                .copy(existing)
                .setDayOfWeek(updated.getDayOfWeek())
                .setStartTime(updated.getStartTime())
                .setEndTime(updated.getEndTime())
                .build();

        return ResponseEntity.ok(service.update(updatedAvailability));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Availability>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
