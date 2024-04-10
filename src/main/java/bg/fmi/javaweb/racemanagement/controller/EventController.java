package bg.fmi.javaweb.racemanagement.controller;

import bg.fmi.javaweb.racemanagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("/requestParam")
    public String getSomethingWithQuery(@RequestParam("id") Integer id) {
        return "pathVariable";
    }
}
