package bg.fmi.javaweb.racemanagement.controller;

import bg.fmi.javaweb.racemanagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("/requestParam")
    public String getSomethingWithQuery(@RequestParam("id") Integer id) {
        return "pathVariable" + id;
    }


    @GetMapping("/pathVariable/{id}")
    public String getSomethingWithPathVar(@PathVariable Integer id) {
        return "pathVariable";
    }
    @PostMapping
    public void fakeMethod() {
        //testEvent();
    }
    @GetMapping
    public String getCar(@RequestParam("cvqt") String color) {
        if (color.equals("red")) {
            return "ferrari";
        } else {
            return "opel";
        }
    }
}
