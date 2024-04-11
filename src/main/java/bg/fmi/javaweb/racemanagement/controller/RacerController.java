package bg.fmi.javaweb.racemanagement.controller;


import bg.fmi.javaweb.racemanagement.models.RacerDTO;
import bg.fmi.javaweb.racemanagement.service.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/racers")
public class RacerController {
    @Autowired
    RacerService racerService;

    @PostMapping("/create")
    public String createRacer(@RequestParam("firstName") String firstName){
        racerService.createRacer(firstName, "testName", 0);
        return "create racer: " + firstName;
    }
    @PostMapping("/")
    String createRacer(@RequestBody RacerDTO newRacer) {
        racerService.createRacer(newRacer.getFirstName(), newRacer.getLastName(), newRacer.getAge());
        return newRacer.toString();
    }

}
