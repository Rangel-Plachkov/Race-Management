package bg.fmi.javaweb.racemanagement.controller;

import bg.fmi.javaweb.racemanagement.models.RacerDTO;
import bg.fmi.javaweb.racemanagement.service.RacerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/racers")
public class RacerController {
    @Autowired
    RacerService racerService;

    @GetMapping("/")
    String getRacers(@RequestParam(name = "firstName", required = false) String firstName) {
        if (firstName != null) {
            return racerService.getAllRacersByFirstName(firstName).toString();
        } else {
            return racerService.getAllRacers().toString();
        }
    }

    @PostMapping("/")
    String createRacer(@Valid @RequestBody RacerDTO newRacer) {
        racerService.createRacer(newRacer.getFirstName(), newRacer.getLastName(), newRacer.getAge());
        return newRacer.toString();
    }
    @DeleteMapping("/")
    String deleteRacer(@RequestParam(name = "id") Integer id) {
        if (racerService.deleteRacerById(id)) {
            return "Racer with id " + id + " deleted";
        } else {
            return "Racer with id " + id + " not found";
        }
    }
    @PatchMapping("/")
    String updateRacer(@Valid @RequestParam(name = "id") Integer id, @RequestBody RacerDTO newRacer) {
        if (racerService.deleteRacerById(id)) {
            racerService.createRacer(newRacer.getFirstName(), newRacer.getLastName(), newRacer.getAge());
            return "Racer with id " + id + " updated";
        } else {
            return "Racer with id " + id + " not found";
        }
    }
}
